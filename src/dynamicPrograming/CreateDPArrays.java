package dynamicPrograming;


import java.util.*;

import matrixCreation.MatrixCreator;
import matrixCreation.RandomNumberGenerator;
public class CreateDPArrays {
	
	

	final int MAXDP = 10000; // I am using same constant value for DP 
	final int COLUMNSNUMBER=10; // max column number for each matrix
	final int ROWS=10;// max row number for each matrix
	
	int noOfMatrix = 0;
	int row, column = 0;
	
	public ArrayList<ArrayList<Integer>> cDPA() {
	Scanner userinput = new Scanner(System.in);
	
	//Create 2D Array list to store Matrix Colm. row values
	ArrayList<ArrayList<Integer>> table = new ArrayList<>();
	
	
	// Ask users how many matrices to create  for Brute Force	
	
	while(noOfMatrix<25 || noOfMatrix > MAXDP ) {
		System.out.println("Dynamic Programming Test ( 27 - 10000 matrices) ");
		System.out.println("How many Matrices? ");
		noOfMatrix = userinput.nextInt();
	}
	
	System.out.println("Please wait we are creating "+noOfMatrix+ " random matrices for you ");
			
	
	RandomNumberGenerator rnd = new RandomNumberGenerator();
	
	// Instantiate the MatrixCreator Class to write all the matrices to the files.
	MatrixCreator matrix = new MatrixCreator();
	
	//create matrices
	for (int j=1; j<=noOfMatrix; j++) {
		
		if (j ==1 ) {// if 1 matrix then there is no multiplication!!! do this part at the end!!!

	            //randomly pick the row value
	            row = rnd.randomNumber(ROWS);
	          

	            //if row is 1 then column have to be bigger than 1
	            if (row==1) {
	                while(column<=1) {
	                    //randomly pick the column value
	                    column = rnd.randomNumber(COLUMNSNUMBER);
	                }
	               
	            }else {
	                //randomly pick the column value
	                column = rnd.randomNumber(COLUMNSNUMBER);
	               
	            }
	            //created random row and col. values will be added to arraylist
	            table.add(new ArrayList<>());
	            table.get(j-1).add(row);
	            table.get(j-1).add(column);
	          

		}
		else {
			
			row = column;
			//if row is 1 then column have to be bigger than 1
			if (row==1) {
				while(column<=1) {
					//randomly pick the column value
					column = rnd.randomNumber(COLUMNSNUMBER);
					
				}
			
			}else {
				//randomly pick the column value
				column = rnd.randomNumber(COLUMNSNUMBER);
				
			}
			table.add(new ArrayList<>());
			table.get(j-1).add(row);
			table.get(j-1).add(column);
			
		}
	}
	
	matrix.creator(table);
	
	userinput.close();
	return table;
}

}
