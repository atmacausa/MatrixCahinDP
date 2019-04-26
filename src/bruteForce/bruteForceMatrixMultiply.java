package bruteForce;

/*
 * Please Ignore this class. This is just for self checking!
 */

public class bruteForceMatrixMultiply {
	//This class for counting how many multiplication occur during multiplication
	public int letMultiply(int row1, int col1, int row2, int col2) {
		int mmResult=0;
		if(col1 != row2) {
			System.out.println("This 2 matrices can not be multiply!");
		}
		else {
			mmResult = row1*col1*col2;
		}
		
		
		
		return mmResult;
	}

}
