package practiseprogrammes;

public class ReverseString {

	public static void main(String[] args) {
		String s = "nitin";
		String rev = "";
		for (int i = s.length()-1; i >=0 ; i--)
		{
			rev = rev + s.charAt(i);
		}
		System.out.println(rev);
		
		if (rev.equals(s))
		{
			System.out.println("The String is palindrome");
		}
		else {
			System.out.println("The string is not palindrome");
		}
	}

}
