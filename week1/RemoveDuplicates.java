package day1.week1;

public class RemoveDuplicates {
	public static void duplicates()
	{
		String text = "We learn java basics as part of java sessions in java week1";
		int count =0;
		String[] s = text.split(" ");
		for(int i=0;i<s.length;i++)
		{
			for(int j =i+1;j<s.length-1;j++)
			{
				
		    if(s[i]==s[j])
		    {
		    	
		    	count = count+1;
		    	break;
		    }
		    if(count<1)
		    {
		    	
		    	s[i]="";
		    }
		    
			}
			System.out.println(s[i] + "");
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
RemoveDuplicates r = new RemoveDuplicates();
r.duplicates();
	}

}
