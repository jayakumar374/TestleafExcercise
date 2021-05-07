package Assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingusingCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] input = { "HCL", "Wipro", "Aspire Systems", "CTS" };
		System.out.println("Array Length : " + input.length);
		List<String> company = new ArrayList<String>();
		for (String companyName : input) {
			company.add(companyName);

			Collections.sort(company);
			/*for(int i=company.size();i>=1;i--)
			{
				System.out.println(input[i]);
			}*/
Collections.sort(company,Collections.reverseOrder());

		}
		System.out.println(company);
	}

}
