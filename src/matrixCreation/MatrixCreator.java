package matrixCreation;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MatrixCreator {
	/*
	 * I am going to create Matrices and save them to the files
	 * File names will be A1, A2... so on
	 * Each line of the files are demonstrate the rows
	 * Each line has integer with separated by comma (,)
	 *  */
	
	
	final int MATRIXELEMENTS=100; // Matrix elements between 1 - 100
	
	public int creator(ArrayList<ArrayList<Integer>> table){
		
		int a,b=1;
		int tablesize = table.size();
		
				//System.out.println("table size "+table.size());
		
				
		RandomNumberGenerator rnd = new RandomNumberGenerator();
		for(int k=1; k<=tablesize; k++) {
			
			File myarray = new File("A"+k+".txt");
			
				try {
					myarray.createNewFile();
					PrintWriter pw = new PrintWriter(myarray);
					int row = table.get(k-1).get(0);
					
					for (a = 1; a<=row; a++) { //create the rows
						int col = table.get(k-1).get(1);
						
						for (b = 1; b<=col; b++) {
							if(b<col) {
								int temp1 =rnd.randomNumber(MATRIXELEMENTS);
								
								pw.print(temp1+",");
							}
							else {
								int temp2 = rnd.randomNumber(MATRIXELEMENTS);
								pw.print(temp2);//last element on same row.
								
								pw.println();
							}
						}
					}
					pw.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}	
		}						
		return 0;
		
	}

}
