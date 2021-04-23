package day1.week1;


public class Palindrome 
{
	public static void palindrome(String s)
	{
		//String s = "JJJ";
		String reverse = "";
		int length = s.length();
		for(int i=length-1;i>=0;i--)
		{
			reverse = reverse + s.charAt(i);
		}
			if(s.equalsIgnoreCase(reverse))
			{
				System.out.println("Palindrome");
			}
			else
			{
				System.out.println("Not Palindrome");
			}
		
		
	}
    public static void main( String[] args )
    {
        Palindrome p = new Palindrome();
        p.palindrome("AYA");
    }
}
