package practiseprogrammes;

public class AddElementsinaStringArray {

	public static void main(String[] args) {
		
		String [] str = {"1","2","3","4"};
		
		int sum = 0;
		
		for (String s : str)
		{
			sum = sum + Integer.parseInt(s);
		}
		
		System.out.println("The sum of the element is : "+sum);

	}

}
