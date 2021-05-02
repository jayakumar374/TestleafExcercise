
public class Calculator {
	public void add(int num1,int num2)
	{
		System.out.println(num1+num2);
	}
	public void add(int num1,int num2,int num3)
	{
		System.out.println(num1+num2+num3);
	}
	public void multiply(int num1,int num2)
	{
		System.out.println(num1*num2);
	}
	public void multiply(int num1,double num2)
	{
		System.out.println(num1*num2);
	}
	public void sub(int num1,int num2)
	{
		System.out.println(num1-num2);
	}
	public void sub(int num1,double num2)
	{
		System.out.println(num1-num2);
	}
	public void div(int num1,int num2)
	{
		System.out.println(num1/num2);
	}
	public void div(int num1,double num2)
	{
		System.out.println(num1/num2);
	}

	public static void main(String[] args) {
		Calculator cr = new Calculator();
		cr.add(2, 2);
		cr.add(2, 2, 2);
		cr.sub(24, 45);
		cr.sub(56, 78945);
		cr.multiply(2, 0);
		cr.multiply(34, 5667);
		cr.add(3, 1);
		cr.div(34, 567);

	}

}
