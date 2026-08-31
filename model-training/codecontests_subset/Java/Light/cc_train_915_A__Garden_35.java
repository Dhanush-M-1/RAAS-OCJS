import java.util.*;
 
public class Main{
 
	public static void main(String[] args) {
	
	    Scanner sc = new Scanner(System.in);
		int k, n;
		int[] a;
		n = sc.nextInt();
		k = sc.nextInt();
		a = new int[n];
		for(int i=0;i<n;i++)
		{
		    a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int max=1;
		for(int i= n-1;i>=0;i--)
		{
		    if(k%a[i]==0)
		    {
		        max = a[i];
		        break;
		    }
		}
		System.out.println(k/max);
		
		
		
		
	}
	
	
}