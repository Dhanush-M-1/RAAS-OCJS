import java.util.Scanner;

public class Compile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long n=Long.parseLong(sc.nextLine());
		String[] a=sc.nextLine().split(" ");
		long x=0;
		for(int i=0;i<n;i++)
			x+=Long.parseLong(a[i]);
		
		String[] b=sc.nextLine().split(" ");
		long y=0;
		for(int i=0;i<n-1;i++)
			y+=Long.parseLong(b[i]);
		
		String[] c=sc.nextLine().split(" ");
		long z=0;
		for(int i=0;i<n-2;i++)
			z+=Long.parseLong(c[i]);
		
		System.out.println(x-y);
		System.out.println(y-z);
	}

}
