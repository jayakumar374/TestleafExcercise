package day1.week1;

public class ChangeOddIndexToUpperCase {

	public static void indexToUppercase()
	{
		String test = "changename";
		char[] c = test.toCharArray();
		for (int i = 0; i < c.length; i++) {

			if (i % 2 == 0) {

				
				System.out.print(Character.toUpperCase(c[i]));
			}

			else {
				System.out.print(c[i]);

			}
		}
	}
	public static void main(String[] args) {
		ChangeOddIndexToUpperCase uppercase = new ChangeOddIndexToUpperCase();
		uppercase.indexToUppercase();
		

	}

}
