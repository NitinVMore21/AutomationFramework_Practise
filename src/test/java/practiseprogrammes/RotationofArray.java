package practiseprogrammes;

public class RotationofArray {

	public static void main(String[] args) {

		int [] arr = { 1, 2, 3, 4, 5};
		
		int d = 2;
		
		System.out.println("The rotated array :");
		
		for (int i = d; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		
		for (int i = 0; i < d; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

}

