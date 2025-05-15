package practiseclasses;

public class PractiseMethods {
	//static method
	//non static

	public static void m1() //static 
	{
		System.out.println("Savita is Quick learner");
		
		
	}
	
	public void m2() //non static
	{
		m1();
		System.out.println("Savita is Smart");
	}
	
	public void m3() //non static 
	{
		m1();
		System.out.println("Savita is Beautiful");
		m2();
	}
	
	public void addition()
	{
		int i = 10;
		int j = 20;
		int k = i + j;
		System.out.println("The additon is :" + k);
	}
	

	public static void main(String[] args) { // static main method
		// classname variable name = new classname(); syntax of class
		
		PractiseMethods pm = new PractiseMethods();
//		m1();
//		pm.m2();
		pm.addition();
	}
}
