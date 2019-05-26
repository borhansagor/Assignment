#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/mman.h>

//function to operate on collatz sequence numbers
int collatz(int n)
{
      if(n%2==0)
      {
         n=n/2;
      }
      else
      {
	 n=(3*n)+1;
      }

}

//*********main
int main(int argc, char** argv)
{

//Error checks for no argument/more than 1 argument
        if(argc!=2)
        {
           if(argc==1)
           {
              fprintf(stderr, "No argument\n");
              exit(1);
           }
           else
           {
              fprintf(stderr, "One argument only\n");
              exit(1);
           }
        }

        //converting ascii to int and Error check for 0 or negative numbers
        if(atoi(argv[1])<=0)
        {
           fprintf(stderr, "Only positive integers\n");
           exit(1);
        }

        int number=atoi(argv[1]);//command line argument to determine Collatz-sequence



	/* The size (in bytes) of shared-memory object */
	const int SIZE = 4096;

	/* The name of shared-memory object */
	const char *Obj = "Shm";

	/* The shared-memory file descriptor */
	int shm_fd;

	/* The pointer to shared-memory object */
	void *ptr;

	/* Create the shared-memory object */
	shm_fd = shm_open(Obj, O_CREAT | O_RDWR, 0666);

	/* Configure the size of the shared-memory object */
	ftruncate(shm_fd, SIZE);

	/* Map the shared-memory object in the address space of the process */
	ptr = mmap(0, SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, shm_fd, 0);

	if (ptr == MAP_FAILED) 
	{
	   printf("Map failed\n");
	   return -1;
	}

	/* Create a message and write it to the shared-memory object */

	int arr[SIZE];  //int array to store the collatz-sequence
	char str[SIZE]; //string that holds the sequence to pe written

	//loop to run collatz-sequence until it reaches 1	
	int j=1;
	arr[0]=number;
	while(number!=1)
	{
	      number=collatz(number);
	      arr[j]=number;
	      j++;
	

	}
	int i=0;
	int k=0;
	
	//int array to char array conversion
	for(i=0;arr[i]>=1;i++)
	{
	    k+=sprintf(&str[k], "%d ", arr[i]);	

		
	}
	sprintf(ptr,"%s",str);
	printf("Producer: Writing the sequence to the shared memory is done! \n");


	return 0;
}
