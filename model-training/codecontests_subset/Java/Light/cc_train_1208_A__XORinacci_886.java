import java.util.Scanner;
public class mostafa {

	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		long t=input.nextInt();
		for(int i=0;i<t;i++)
		{
		long a=input.nextInt();long b=input.nextInt();long n=input.nextInt();
		if (n%3==0)
		System.out.println(a);
		else if (n%3==1)
			System.out.println(b);
		else 
			System.out.println(a^b);
		}
			
	}

}
