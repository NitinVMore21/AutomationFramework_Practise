package practiseclasses;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorPractise {

	public static void main(String[] args) {
		
		List l = new ArrayList();
		
		l.add(100);
		l.add("Nitin");
		l.add(200);
		
		System.out.println(l);
		
		ListIterator litr = l.listIterator();
		
		while (litr.hasNext())
		{
			System.out.println(litr.next());
		}
		
		System.out.println("--------------------------");
		
		while(litr.hasPrevious())
		{
			System.out.println(litr.previous());
		}

	}

}
