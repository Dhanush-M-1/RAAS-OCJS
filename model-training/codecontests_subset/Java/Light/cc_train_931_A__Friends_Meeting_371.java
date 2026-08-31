import java.util.*;
public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		long n = Math.abs(a-b);
		
		if(n%2 == 0)
		{
			n = n/2;
			System.out.println(n*(n+1));
		}
		else
		{
			long n1 = n/2;
			long s1 = n1*(n1+1)/2;
			long n2 =n1+1;
			long s2 = n2*(n2+1)/2;
			
			System.out.println(s1+s2);
		}

	}

}
