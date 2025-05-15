package practiseclasses;

public class MethodCategories {
	
	
	// method without return and with arg
	
	public void m1(int i)
	{
		int j = i + 2;
		System.out.println(j);
	}
	
	public static void main(String[] args) {
		
		MethodCategories mct = new MethodCategories();
		
		mct.m1(10);
	}

}
