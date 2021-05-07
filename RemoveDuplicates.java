package Assignment3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class RemoveDuplicates {

	public static void main(String[] args) {

		String s = "PayPal India";

		char[] orginal = s.toCharArray();

		Set<Character> charSet = new HashSet<Character>();

		Set<Character> dupCharSet = new HashSet<Character>();

		for (int i = 0; i < orginal.length; i++) {
			char val = orginal[i];
			if (val != ' ') {
				charSet.add(new Character(orginal[i]));

			}

			if (charSet.contains(orginal[i])) {
				dupCharSet.add(new Character(orginal[i]));

			}

		}

		if (dupCharSet.equals(charSet)) {
			charSet.remove(dupCharSet);
		}

		Iterator last = charSet.iterator();
		while (last.hasNext()) {
			System.out.print(last.next());
		}
	}

}
