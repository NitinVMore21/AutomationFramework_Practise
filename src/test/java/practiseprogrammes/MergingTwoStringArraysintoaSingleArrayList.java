package practiseprogrammes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergingTwoStringArraysintoaSingleArrayList {

	public static void main(String[] args) {
		
		List<String> l1 = new ArrayList<String>(Arrays.asList("1","2","3","4"));
		
		List<String> l2 = new ArrayList<String>(Arrays.asList("5","6","7","8"));
		
		l1.addAll(l2);
		
		System.out.println(l1);
 
	}

}
