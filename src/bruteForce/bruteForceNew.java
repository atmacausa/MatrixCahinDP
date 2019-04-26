package bruteForce;

import java.util.ArrayList;

public class bruteForceNew {
	
	public int bfN(ArrayList<ArrayList<Integer>> doubleArray) {
		long m = (long) 1E7;
		long millisecond= System.currentTimeMillis(); // start time of Brute force 
		
		int arraySize = doubleArray.size();
	
		int arry[]= new int[arraySize+1];
		
		
		for (int i = 0; i<arry.length-1;i++) {
			//create an array to find matrix amount.
			arry[i]=doubleArray.get(i).get(0); //first array row value
		}

		arry[arraySize] = doubleArray.get(arraySize-1).get(1); // last column of the chain
	
		
		int n= arry.length;
		
		int result=0;
		bruteForceMatrixMultiply mm = new bruteForceMatrixMultiply();
		
		  if(n==3) { // 2 matrix multiply
			  	int row1= doubleArray.get(0).get(0);
			  	int col1 = doubleArray.get(0).get(1);
				//int row2= doubleArray.get(1).get(0);
				int col2 = doubleArray.get(1).get(1);
	        	result = row1*col1*col2;
	        	
	        }
		  else if(n==4){ //3 matrix multiply
	        	int row1= doubleArray.get(0).get(0);
				int col1 = doubleArray.get(0).get(1);
				int row2= doubleArray.get(1).get(0);
				int col2 = doubleArray.get(1).get(1);
				int row3= doubleArray.get(2).get(0);
				int col3 = doubleArray.get(2).get(1);
				
				
				int mmResult1 = mm.letMultiply(row1, col1, row2, col2); //(A*B)*C
				mmResult1 = mmResult1 + mm.letMultiply(row1, col2, row3, col3);
				result= mmResult1;
				
				int mmResult2 = mm.letMultiply(row2, col2, row3, col3); //A*(B*C)
				mmResult2 = mmResult2 + mm.letMultiply(row1, col1, row2, col3);
				
				
				
				result = Math.min(mmResult1, mmResult2);
	        }else {
	        	result = MatrixChainParans(arry, 1, n-1 );
	        }
		//Here is the finish time of the Brute Force 
		m = System.currentTimeMillis()- millisecond;
		System.out.println("Brute Force complation time: "+ m+" ms");
		
		return result;
	}
		
	public int MatrixChainParans(int ar[], int i, int j) 
    { 
        int min = Integer.MAX_VALUE;// this is creates a possible max integer value
        
        
        if (i == j) 
            return 0; 
        
        int matrixTotalMultiplication=0;
        
	        for (int k=i; k<j; k++) 
	        { 
	            matrixTotalMultiplication = MatrixChainParans(ar, i, k) + MatrixChainParans(ar, k+1, j) + ar[i-1]*ar[k]*ar[j]; 
	            if (matrixTotalMultiplication < min) 
	                min = matrixTotalMultiplication; 
	        } 
        return min; 
    } 
	
	
}
