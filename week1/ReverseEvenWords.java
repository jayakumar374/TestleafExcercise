package day1.week1;

public class ReverseEvenWords {
	
	public static void rev()
	{
		String test[] = "I am a software tester".split(" "); 
		int length = test.length;
	 	String result = "";  
		String r = ""; 
		for (int i = 0; i < length; i++) 
		{ 
			 
			String w = test[i]; 
			 
			if (i % 2 == 0)
			{ 
				 
				for (int j = w.length() - 1; j >= 0; j--)
				{ 
					r = r + w.charAt(j); 
				} 
				 
				result = result + r + " ";
				r = ""; 
			} 
			
			else 
				result = result + test[i] + " ";
		} 
		System.out.println(result); 
	} 

	
	public static void main(String[] args) {
		
	
		ReverseEvenWords re = new ReverseEvenWords();
		re.rev();

}
}