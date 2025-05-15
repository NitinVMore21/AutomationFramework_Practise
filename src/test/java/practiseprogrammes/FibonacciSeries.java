package practiseprogrammes;

import java.util.ArrayList;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		int num = 6;
		int first = 0;
		int second = 1;
		int next;
		System.out.println("Series is ");
		for (int i = 0; i<=num; i++)
		{
			System.out.print(first + " ");
			next = second + first;
			first = second;
			second = next;
		}

	
	}

}
