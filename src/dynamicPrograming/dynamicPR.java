package dynamicPrograming;

import java.util.ArrayList;

public class dynamicPR {
	
	
	public int testDP(ArrayList<ArrayList<Integer>> doubleArray) {
		long m = (long) 1E7;
		long millisecond= System.currentTimeMillis(); // start time of DP 
		
		int arraySize = doubleArray.size();
		//System.out.println("DP array size"+arraySize);
		int tempSize = arraySize+1;
		//System.out.println("DP temp size"+tempSize);
		int arry[]= new int[tempSize];
		
		for (int i = 0; i<tempSize-1;i++) {
			arry[i]=doubleArray.get(i).get(0);
		}
		arry[tempSize-1] = doubleArray.get(arraySize-1).get(1);
		
		int n= arry.length;
		
		int result = DPRun(arry, n );
		//Here is the finish time of the Brute Force 
		m = System.currentTimeMillis()- millisecond;
		System.out.println("DP complation time: "+ m+" ms");
		return result;
		
	}
	public int DPRun(int a[], int n) {
		
		int m[][] = new int[n][n]; //M Table
		
		int i, j, k, l, q=0;
		
		//
		for (i = 1; i < n; i++) {
			m[i][i] = 0; // Diagonal of DP M table is always Zero 
		}
		
		for (l=2; l<n; l++) 
        { 
            for (i=1; i<n-l+1; i++) 
            { 
                j = i+l-1; 
                if(j == n) continue; 
                m[i][j] = Integer.MAX_VALUE; //this is creates a possible max integer value
                for (k=i; k<=j-1; k++) 
                { 
                    // q = cost/scalar multiplications 
                    q = m[i][k] + m[k+1][j] + a[i-1]*a[k]*a[j]; 
                    if (q < m[i][j]) 
                        m[i][j] = q; 
                } 
            } 
        } 
  
        return m[1][n-1]; 
	}

}
