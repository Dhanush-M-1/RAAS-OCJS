import java.util.Scanner;

public class Compile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long n=Long.parseLong(sc.nextLine());
		long x=0;
		for(int i=0;i<n;i++)
			x+=sc.nextLong();
		
		long y=0;
		for(int i=0;i<n-1;i++)
			y+=sc.nextLong();
		
		long z=0;
		for(int i=0;i<n-2;i++)
			z+=sc.nextLong();
		
		System.out.println(x-y);
		System.out.println(y-z);
	}

}
