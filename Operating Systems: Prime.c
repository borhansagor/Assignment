#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

//Helper method to determine if number is prime or not
bool isPrime(int n)
{
                if(n==2||n==3||n==5||n==7)
                {
                        return true;
                }
                if(n%2==0)
                {
                        return false;
                }
                if(n%3==0)
                {
                        return false;
                }
                if(n%5==0)
                {
                        return false;
                }
                if(n%7==0)
                {
                        return false;
                }
                else
                {
                        return true;
                }

}


void *primeThread(void* rank) // Thread function
{

long argNumber=(long) rank;//Typecasting to long
int i;
printf("The prime number of a given number %d are: ",argNumber);
//loop 2-command line argument and printout each prime number
   for(i=2;i<=argNumber;i++)
   {
      if(isPrime(i))
      {
         printf("%d ",i);
      }
   }


  pthread_exit(NULL);
}

int main(int argc, char* argv[])
{
        //Error check for no argument/more than one argument and number less than 2
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

        if(atoi(argv[1])<2)
        {
           fprintf(stderr, "Integer no less than 2\n");
           exit(1);
        }

        long number=atol(argv[1]);


   pthread_t* Threads;

   Threads = malloc(1*sizeof(pthread_t));

           pthread_create(&Threads[0], NULL, primeThread, (void*)number);//Create thread
           pthread_join(Threads[0],NULL);

   free(Threads);
   return 0;
}

