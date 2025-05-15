package practiseprogrammes;

public class FactorialofNumber {

	public static void main(String[] args) {
		
		int factorial = 1;
		
		int number = 5;
		
		for(int i = 1; i <= number; i++)
		{
			factorial = factorial*i;
		}

		System.out.println(factorial);
	}

}
