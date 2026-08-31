import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n;
		
		int ans=0;
		boolean check = false;
		boolean check1 = false;
		n = scan.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[n-1];
		int[] c = new int[n-2];
		
		for(int i=0;i<n;i++)
		{
			a[i] = scan.nextInt();
		}
		
		Arrays.sort(a);
		for(int i=0;i<n-1;i++)
		{
			b[i] = scan.nextInt();
		}
		Arrays.sort(b);
		
		for(int i=0;i<n-2;i++)
		{
			c[i] = scan.nextInt();
		}
		Arrays.sort(c);
		
		for(int i=0;i<n-1;i++)
		{
			if(a[i]!=b[i]) {
				System.out.println(a[i]);
				check = true;
				break;
			}				
				
		}
		if(check==false)
			System.out.println(a[n-1]);
		
		for(int i=0;i<n-2;i++)
		{
			if(b[i]!=c[i]) {
				System.out.println(b[i]);
				check1 = true;
				break;
			}
		}
		if(check1==false)
			System.out.println(b[n-2]);
	}
}

