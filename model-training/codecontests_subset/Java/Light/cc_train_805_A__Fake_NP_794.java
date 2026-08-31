import java.util.Scanner;

public class NightGFG {

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		int b=s.nextInt();
		if(a==b)
			System.out.println(a);
		else
			System.out.println("2");
	}
}