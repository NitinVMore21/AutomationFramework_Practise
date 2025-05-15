package practiseclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorPractise {

	public static void main(String[] args) {
		
		List l = new ArrayList(); 
		
		l.add(100);
		l.add(200);
		l.add(300);
		
		System.out.println(l);
		
		l.remove(2);
		
		Iterator itr = l.iterator();
		
        while (itr.hasNext())
        {
        	System.out.println(itr.next());
        }
	}

}
