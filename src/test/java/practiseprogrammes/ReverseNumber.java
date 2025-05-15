package practiseprogrammes;

public class ReverseNumber {

	public static void main(String[] args) {
		int num = 121;
		int reverse = 0;
		int originalNum = num;
		for(; num != 0; num /= 10)
		{
			int digit = num % 10;
			
			reverse = reverse * 10 + digit;
		}

		System.out.println("The reverse is : "+reverse);
		
		if (reverse == originalNum)
		{
			System.out.println("The number is palindrome");
		}
		else {
			System.out.println("The number is not palindrome");
		}
	}

}
