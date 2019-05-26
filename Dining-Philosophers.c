#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//const N=total number of philosophers
//const states THINKING,HUNGRY,EATING
#define N 5
#define THINKING 0
#define HUNGRY 1
#define EATING 2

pthread_mutex_t mutex;
pthread_cond_t cond_var[5];
pthread_t Threads[5];

int state[N];
int pArray[N]={0,1,2,3,4};

//***********void test(int i)*************//
//Check if hungry and neighbors are not eating, if not eat//
void test(int i)
{
        if((state[(i+4)%5]!=EATING) && (state[i]==HUNGRY) && (state[(i+1)%5]!=EATING))

        {
                state[i]=EATING;
                printf("Philosopher %d is eating\n",i);
                pthread_cond_signal(&cond_var[i]);
        }
}

//******************void Pick_Forks(int Philosopher_ID)************//
void Pick_Forks(int Philosopher_ID)
{
pthread_mutex_lock(&mutex);
state[Philosopher_ID]=HUNGRY;
test(Philosopher_ID);
	//if not able to eat then wait
	if(state[Philosopher_ID]!=EATING)
	{
		pthread_cond_wait(&cond_var[Philosopher_ID],&mutex);
	


	}
pthread_mutex_unlock(&mutex);

}
//**********************void Return_Forks(int Philosopher_ID)******************//
void Return_Forks(int Philosopher_ID)
{
//Lock
pthread_mutex_lock(&mutex);

state[Philosopher_ID]=THINKING;
printf("Philosopher %d is thinking\n",Philosopher_ID);

//sleep random time//
int random_Timer=(rand()%3)+1;
sleep(random_Timer);
//test left and right neibors//

test((Philosopher_ID+4)%5);
test((Philosopher_ID+1)%5);


//Release Lock//
pthread_mutex_unlock(&mutex);

}

//******************void *philosopher(void *i)********************//
void *philosopher(void *i)	
{              

		int random_Timer=(rand()%3)+1;
                int *number=i;
                Pick_Forks(*number);
		//sleep random time//
		sleep(random_Timer);
                Return_Forks(*number);
		
}



//*************************int main()**************************//
int main()
{
int i;
time_t t;
srand((unsigned)time(&t));

pthread_mutex_init(&mutex,NULL);

//initializing conditional variable//
for(i=0;i<N;i++)
{
	pthread_cond_init(&cond_var[i],NULL);

}
//creating threads//
for(i=0;i<N;i++)
{
	pthread_create(&Threads[i],NULL,philosopher,&pArray[i]);

}
//join threads//
for(i=0;i<N;i++)
{

	pthread_join(Threads[i],NULL);


}
//destroy mutex
pthread_mutex_destroy(&mutex);
return 0;
}
