package Assignment3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindNumberofOccurance {

	public static void main(String[] args) {
		String s  = "welcome to Selenium automation";
		char[] original = s.toCharArray();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0;i<original.length;i++)
		{
			if(map.containsKey(original[i]))
			{
				Integer value = map.get(original[i]);
				
				int newValue = value + 1;
				map.put(original[i], newValue);
			}
			else
			{
				map.put(original[i],1);
			}
		}
		System.out.println(map);
		

	}

}
