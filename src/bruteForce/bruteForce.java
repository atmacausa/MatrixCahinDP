package bruteForce;

import java.util.ArrayList;

/*
 * 
 * Please Ignore this class!!! Because I am just testing myself with hard coding
 * 
 * 
 * */

public class bruteForce {
	
	public void testBruteForce(ArrayList<ArrayList<Integer>> doubleArray) {
		/* I have tried to hardcode but it didnt work :) so I have wrote new class 
		 Please see the bruteForceNew.java.
		 */ 
		int  mmResult1, mmResult2, mmResult3, mmResult4,mmResult5,mmResult6,mmResult7,mmResult8=0;
		int mmResultA1=0;
		//System.out.println("Array Size ="+doubleArray.size());
		System.out.println("Brute Force Class icindeyim ve calsiyorum");
		//lets print the double array values and check if everything is fine!!! 
		for (int i=0; i<doubleArray.size(); i++) { 		    
			for (int j=0; j<2; j++) { 
	           System.out.println(doubleArray.get(i).get(j)); 		
	      }
		}
		// I am going to test at most 10 matrices
		
		//System.out.println(doubleArray.size());
		int mSize = doubleArray.size(); 
		
		if(mSize == 1 ) {
			System.out.println("You can not multiply one matrices!!! Please Try Again!");
		}
		bruteForceMatrixMultiply mm = new bruteForceMatrixMultiply();
		
		//mm.letMultiply(1,2,3,4);
		
		if(mSize==2) {
			System.out.println("Burdayim");
			int row1= doubleArray.get(0).get(0);
			int col1 = doubleArray.get(0).get(1);
			int row2= doubleArray.get(1).get(0);
			int col2 = doubleArray.get(1).get(1);
			
			mmResult1 = mm.letMultiply(row1, col1, row2, col2); 
			
			System.out.println(mmResult1+ " times Multiplication");
		}
		else if(mSize == 3) {
			int row1= doubleArray.get(0).get(0);
			int col1 = doubleArray.get(0).get(1);
			int row2= doubleArray.get(1).get(0);
			int col2 = doubleArray.get(1).get(1);
			int row3= doubleArray.get(2).get(0);
			int col3 = doubleArray.get(2).get(1);
			
			
			mmResult1 = mm.letMultiply(row1, col1, row2, col2); //(A*B)*C
			mmResult1 = mmResult1 + mm.letMultiply(row1, col2, row3, col3);
			
			System.out.println("(A*B)*C ="+ mmResult1 +" times Multiplication");
			
			
			
			mmResult2 = mm.letMultiply(row2, col2, row3, col3); //A*(B*C)
			mmResult2 = mmResult2 + mm.letMultiply(row1, col1, row2, col3);
			
			System.out.println("A*(B*C) = "+ mmResult2+" times Multiplication");
			
			
		}
		else if(mSize == 4) {
			
			int row1= doubleArray.get(0).get(0);
			int col1 = doubleArray.get(0).get(1);
			int row2= doubleArray.get(1).get(0);
			int col2 = doubleArray.get(1).get(1);
			int row3= doubleArray.get(2).get(0);
			int col3 = doubleArray.get(2).get(1);
			int row4= doubleArray.get(3).get(0);
			int col4 = doubleArray.get(3).get(1);
			
			//(A*B)*(C*D)
			mmResult1 = mm.letMultiply(row1, col1, row2, col2);
			mmResultA1 =mm.letMultiply(row3, col3, row4, col4);
			mmResult1 = mmResult1+ mm.letMultiply(row1, col2, row3, col4)+mmResultA1;
			
			System.out.println("(A*B)*(C*D) ="+ mmResult1 +" times Multiplication");
			
			//(A*(B*C)*D
			mmResultA1 =mm.letMultiply(row2, col2, row3, col3);
			mmResult1 =mmResultA1 + mm.letMultiply(row1, col1, row2, col3);
			mmResult2 = mmResult1 + mm.letMultiply(row1, col3, row4, col4);
			
			System.out.println("(A*(B*C)*D) ="+ mmResult2 +" times Multiplication");
			//((A*B)*C)*D
			mmResult1 = mm.letMultiply(row1, col1, row2, col2);
			mmResult1 = mmResult1 + mm.letMultiply(row1, col2, row3, col3);
			mmResult3 = mmResult1 + mm.letMultiply(row1, col3, row4, col4);
			System.out.println("((A*B)*C)*D ="+ mmResult3 +" times Multiplication");
			
			
			//A*(B*(C*D))
			mmResult1 = mm.letMultiply(row3, col3, row4, col4);
			mmResult1 = mmResult1+mm.letMultiply(row2, col2, row3, col4);
			mmResult4 = mmResult1 + mm.letMultiply(row1, col1, row2, col4);
			
			System.out.println("A*(B*(C*D)) ="+ mmResult4 +" times Multiplication");
			}
			else if(mSize == 5) {
				int row1= doubleArray.get(0).get(0);
				int col1 = doubleArray.get(0).get(1);
				int row2= doubleArray.get(1).get(0);
				int col2 = doubleArray.get(1).get(1);
				int row3= doubleArray.get(2).get(0);
				int col3 = doubleArray.get(2).get(1);
				int row4= doubleArray.get(3).get(0);
				int col4 = doubleArray.get(3).get(1);
				int row5= doubleArray.get(4).get(0);
				int col5 = doubleArray.get(4).get(1);
				//((A*B)*(C*D))*E	
				mmResult1 = mm.letMultiply(row1, col1, row2, col2);
				mmResultA1 =mm.letMultiply(row3, col3, row4, col4);
				mmResult1 = mmResult1 + mmResultA1+ mm.letMultiply(row1, col2, row3, col4);
				mmResult1 = mmResult1+mm.letMultiply(row1, col4, row5, col5);
				System.out.println("((A*B)*(C*D))*E ="+ mmResult1 +" times Multiplication");
				
				//(A*B)*(C*(D*E))
				mmResult1 = mm.letMultiply(row1, col1, row2, col2);
				mmResultA1 = mm.letMultiply(row4, col4, row5, col5); //D*E
				mmResultA1 = mmResultA1 + mm.letMultiply(row3, col3, row4, col5); //C*(D*E)
				mmResult2 = mmResult1 + mm.letMultiply(row1, col2, row3, col5)+mmResultA1;
				
				System.out.println("(A*B)*(C*(D*E)) ="+ mmResult2 +" times Multiplication");

				
				//(A*B)*((C*D)*E)
				
				mmResult1 = mm.letMultiply(row1, col1, row2, col2);
				mmResultA1 = mm.letMultiply(row3, col3, row4, col4);
				
				mmResultA1 = mmResultA1+mm.letMultiply(row3, col4, row5, col5);
				mmResult3 = mmResult1+mm.letMultiply(row1, col2, row3, col5)+mmResultA1;
				
				System.out.println("(A*B)*((C*D)*E) ="+ mmResult2 +" times Multiplication");

				
				//(A*(B*C))*(D*E)
				mmResult1 = mm.letMultiply(row2, col2, row3, col3);
				mmResult1 = mmResult1+ mm.letMultiply(row1, col1, row2, col3);
				mmResultA1=mm.letMultiply(row4, col4, row5, col5);
				mmResult4 = mmResult1 + mm.letMultiply(row1, col3, row4, col5)+mmResultA1;
				
				System.out.println("(A*(B*C))*(D*E) ="+ mmResult4 +" times Multiplication");

				
				
				// (A*(B*(C*D))*E
				
				mmResult1 = mm.letMultiply(row3, col3, row4, col4);//C*D
				mmResult1 = mmResult1 + mm.letMultiply(row2, col2, row3, col4);//B*(C*D)
				mmResult1 = mmResult1 + mm.letMultiply(row1, col1, row2, col4);//A*(B*(C*D))
				mmResult5 = mmResult1 + mm.letMultiply(row1, col4, row5, col5);//(A*(B*(C*D))*E
				
				System.out.println("(A*(B*(C*D))*E ="+ mmResult5 +" times Multiplication");
				
				
				
				
				//(((A*B)*C)*D)*E
				mmResult1 = mm.letMultiply(row1, col1, row2, col2); //(A*B)
				mmResult1 = mmResult1 + mm.letMultiply(row1, col2, row3, col3);//((A*B)*C)
				mmResult1 = mmResult1 + mm.letMultiply(row1, col3, row4, col4);//(((A*B)*C)*D)
				mmResult6 = mmResult1 + mm.letMultiply(row1, col4, row5, col5);//(((A*B)*C)*D)
				
				System.out.println("(((A*B)*C)*D)*E ="+ mmResult6 +" times Multiplication");
				
				//((A*B)*C)*(D*E))
				mmResult1 = mm.letMultiply(row1, col1, row2, col2); //(A*B)
				mmResult1 =mmResult1+ mm.letMultiply(row1, col2, row3, col3); //(A*B)*C
				mmResultA1 = mm.letMultiply(row4, col4, row5, col5);
				mmResult7 = mmResult1 + mmResultA1+mm.letMultiply(row1, col3, row4, col5);
				System.out.println("((A*B)*C)*(D*E)) ="+ mmResult7 +" times Multiplication");

				
				
				//(((A*(B*C))*D)*E)
				mmResult1 = mm.letMultiply(row2, col2, row3, col3); //(B*C)
				mmResult1 = mmResult1+mm.letMultiply(row1, col1, row2, col3);//(A*(B*C))
				mmResult1 = mmResult1+mm.letMultiply(row1, col3, row4, col4);
				mmResult8 = mmResult1+mm.letMultiply(row1, col4, row5, col5);
				System.out.println("(((A*(B*C))*D)*E)) ="+ mmResult8 +" times Multiplication");
				
				
			}
			else if(mSize == 6){
				//(A*B)*(C*D)*(E*F)
				//(((A*B)*C)*D)*(E*F)
				//(A*(B*C)*(D*E)*F
				//((A*B)*C*(D*E)*F
				//(A*B)*C
				
			}
		
	}

}
