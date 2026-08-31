import java.util.*;
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long [] x = new long[n];
		long [] h = new long [n];
		
		for (int i =0;i<n;i++)
		{
			x[i] = sc.nextLong();
			h[i] = sc.nextLong();
			
		}
		
		int s =2;
		if (n==1)
			s--;
		for (int i =1;i<n-1;i++)
		{
				
			 if (x[i]-h[i]>x[i-1])
				s++;
			 else if (x[i]+h[i]<x[i+1])
			 {
				s++;
				x[i]+=h[i];
			 }
				
			
		}
		System.out.println(s);
		sc.close();

	}

}