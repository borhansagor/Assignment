/* i declare that all materials in this assessment task is my own work, except where there is a clear acknowledgment 
 * or reference to the work of others. I further declare that I have compiled with and agree to abide by, the UIS Academic Integrity Policy at the University
 * Website. https://www.uis.edu/academicintegrity
 * Author's Name: Borhan Kader UIN-672595290 Date: 06/10/2018
 */




package kaderTask1;
import java.util.*;


public class kaderTask1 {
	
	/* Purpose is to write a method that prints out a possible solution to N^N Matrix chess board; where the queen are 
	 * represented by Q 
	 */
	//Static integer matrix to traverse and use throughout program default is 8 but user can redefine in main;
	public static  int matrix=8;
	
	
	//Method for printing the board;
	public static void printBoard(int [][]board)
	{	
		
		System.out.printf("Solution board: [%d] [%d]\n",matrix,matrix);
		for(int i=0;i<matrix;i++)
		{
			for(int j=0;j<matrix;j++)
			{
				if(board[i][j]==1){
				System.out.print(" "+"|Q|");
				}else{
					System.out.print(" "+"|");
				}
		}
			System.out.println();
		}
		
	}
	
	//checks row and diagonals to see if possible queen,1 exits if not returns true 
	public static boolean isValid(int [][]board, int row, int column)
	{
		int i,j;
		
		for (i=0;i<column;i++)
		{
			if (board[row][i]==1)
				return false;
		}
		for(i=row,j=column;i>=0 && j>=0; i--, j--)
		{
			if (board[i][j]==1)
				return false;
			
		}
		for (i=row, j=column; j>=0 && i<matrix; i++,j--)
		{	if (board[i][j] == 1)
			return false;
		}
		return true;
		
	}
	
	
	public static boolean solveBoard(int board [][], int column)
	{
		if(column>=matrix)
			return true;
		
		for(int i=0; i<matrix;i++)
		{
			if(isValid(board, i, column))
			{
				board[i][column]=1;
				if(solveBoard(board, column+1))//moves on to next column
					return true;
				board[i][column]=0;
			}
		}
		return false;
		
	}
	
	
	public static void main(String[]args)
	{	
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter value for the Matrix [N][N]");
		matrix = scan.nextInt();
		int[][] board = new int[matrix][matrix];
		
		solveBoard(board,0);
		printBoard(board);
		
	}
	
	
}
	
	
	
	
		
	
	 

