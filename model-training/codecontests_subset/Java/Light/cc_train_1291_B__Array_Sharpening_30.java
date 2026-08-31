import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



import java.lang.Math;

public class Test {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int t= s.nextInt();
		
		for(int i=0; i<t;i++)
		{
			int n=s.nextInt();
			
			
			
			int[] r= new int[n];
			
			
			
			
			for(int j=0;j<n;j++)
			{
				r[j]=s.nextInt();
				
				
				
			}
			
			boolean ans=true;
			
			for(int j=0;j<(n+1)/2;j++)
			{
				if(r[j]<j)
					ans=false;
				
				
				
			}
			
			for(int j=(n+1)/2;j<n;j++)
			{
				if(r[j]<n-j-1)
					ans=false;
				
				
				
			}
			
			if(n>1&n%2==0)
			{
				if(r[n/2]+r[n/2-1]==n-2)
					ans=false;
				
			}
			
			
			if(ans)
				System.out.println("Yes");
			else
				System.out.println("No");
			
			
			
			
			
			
			
		}
		
		
	}

}
