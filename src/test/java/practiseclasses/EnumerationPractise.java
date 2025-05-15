package practiseclasses;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationPractise {

	// this is only used for legacy classes i.e. vector and stack
	// we can retrieve the elements in forward direction only
	// methods - hasMoreElements() and nextElement()
	public static void main(String[] args) {
		
		Vector v = new Vector();
		
		v.add(10);
		v.add(20);
		v.add(30);
		
		System.out.println(v);
		
		Enumeration enm = v.elements();
		
		while (enm.hasMoreElements())
		{
			System.out.println(enm.nextElement());
		}
	}

}
