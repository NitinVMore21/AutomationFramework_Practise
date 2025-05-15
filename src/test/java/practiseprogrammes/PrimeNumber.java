package practiseprogrammes;

import java.util.Scanner;

public class PrimeNumber {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Enter the number :");
		
		int number = scanner.nextInt();
//		int number = 23;
		
		if (isPrime(number))
		{
			System.out.println(number + " it is a prime number");
		}
		else {
			System.out.println(number + " it is not a prime number");
		}
	}
		public static boolean isPrime (int num)
		{
			for (int i = 2; i <= num / 2; i++)
			{
				if (num % i == 0)
				{
					return false;
				}
			}
			
		return true;
	}

}
