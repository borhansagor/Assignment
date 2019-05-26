#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>


#define SIZE       100
#define WRITE_END	1
#define READ_END	0


int main(void)
{
	char Write_Msg[SIZE];
	char Write_Msg2[SIZE];
	char Read_Msg[SIZE];
	char Read_Msg2[SIZE];
	int fd[2];
	int fd2[2];
	pid_t pid;

	/* Create a message */
	printf("Please input a character string: \n");
	fgets(Write_Msg, SIZE, stdin);


	 /* Create a pipe */
	 if (pipe(fd) == -1) 
	{
		fprintf(stderr,"Pipe failed");
		return 1;
	}
	//Create the second pipe
	if(pipe(fd2)==-1)
	{
	
		fprintf(stderr,"Pipe failed");
		return 1;
	}

	 /* Fork a child process */
	pid = fork();

	 if (pid < 0) 
	{
		fprintf(stderr, "Fork failed");
		return 1;
	}

	 /* The parent process */
	 if (pid > 0) 
	{  
	   /* Close the read end of the pipe1 and write end of pipe2*/
		 close(fd[READ_END]);
		 close(fd2[WRITE_END]);


	   /* Write the message to the pipe1 */
		 printf("\nParent: Write the message to the pipe 1.\n");
		 write(fd[WRITE_END], Write_Msg, strlen(Write_Msg)+1); 

		 
		 wait(NULL);//wait for child to finish
		 //read from Pipe2 and printout
		 read(fd2[READ_END],Read_Msg2,SIZE);
		 printf("\nParent: Read the modified message from pipe 2: %s\n", Read_Msg2);
		
	}

	 /* The child process */
	 else 
	{ 
	   /* Close the write end of the pipe1 and read end of pipe2*/
		  close(fd[WRITE_END]);
		  close(fd2[READ_END]);

	   /* Read the message from the pipe1 */
		  read(fd[READ_END], Read_Msg, SIZE);
		  printf("\nChild: Read the message from pipe 1: %s", Read_Msg);

		  //using toupper and tolower to chnage cases of each char
		  int i;
	          for(i=0;i<sizeof(Read_Msg);i++)
		  {
			if(islower(Read_Msg[i]))
		  	{
				Write_Msg2[i]=toupper(Read_Msg[i]);
			}
			else
			{

				Write_Msg2[i]=tolower(Read_Msg[i]);
			}
			
		  }
		
		  //write the modified string in pipe 2
		  write(fd2[WRITE_END],Write_Msg2,SIZE);
		  printf("\nChild: Write the modified message to pipe 2.\n");
		  
	}

	return 0;
}
