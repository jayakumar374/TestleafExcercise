package Assignment3;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ReverseTreeMap {
	/*100	Hari
	101     Naveen
	102	Sam
	104	Balaji*/

	public static void main(String[] args) {
		
		TreeMap<Integer,String> empDetails = new TreeMap<Integer,String>(Collections.reverseOrder());
		empDetails.put(100, "Hari");
		empDetails.put(101, "Naveen");
		empDetails.put(102, "sam");
		empDetails.put(104, "Balaji");
		System.out.println(empDetails.size());
		
		System.out.println(empDetails);
		
	}

}
