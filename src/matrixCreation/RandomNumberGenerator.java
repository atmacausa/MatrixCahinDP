package matrixCreation;

import java.util.Random;

public class RandomNumberGenerator {

	public int randomNumber(int a) {
		
		Random rand = new Random();
		int randoms = rand.nextInt(a)+1;
	
		return randoms;
		
	}
}
