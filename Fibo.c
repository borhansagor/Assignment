#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

//Function to calculate Fib sequence and print it out
void fib(int n)
{
        int next=0;
        int previous=0;
        int current=1;
        int i;
        for(i=1;i<=n;i++)
        {
            printf("%d ",previous);
            next=current+previous;
            previous=current;
            current=next;

        }

}

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

        int number=atoi(argv[1]);//command line argument to determine Fib

        pid_t id, pid;

        /* Fork a child process */
        id = fork();

        if (id < 0)   {  /* Error occurred */
                fprintf(stderr, "Fork Failed");
                return 1;
        }

        else if (id == 0)   {  /* Child process */
                printf("Child: The first %d numbers in the Fibonacci sequence are: ",atoi(argv[1]));
                fib(number);
                return 1;
        }

        else  {  /* Parent process */
                wait(NULL);
                printf("\nParent: The child process is done!\n");

        }

	return 0;
}
