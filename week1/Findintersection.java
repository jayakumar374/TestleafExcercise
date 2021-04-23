package day1.week1;

public class Findintersection {
	public static void interSection()
	{
		int a[] = {1,2,3,4,5,6,7};
		int b[] = {8,9,10,3,5,13};
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b.length;j++)
			{
				if(a[i]==b[j])
				{
					System.out.println("Intersection array "+ a[i]);
				}
			}
		}
	}

	public static void main(String[] args) {
		Findintersection f = new Findintersection();
		f.interSection();

	}

}
