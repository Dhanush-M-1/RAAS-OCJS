import java.lang.*;
import java.util.*;

public class Salamander
{	
	public static void main(String args[])
	{	Scanner s = new Scanner(System.in);	
		int n = s.nextInt();
		int a[] = new int[n];
		int sumE = 0;
		int sumA = 0;
		for(int i=0; i<n; i++){
			a[i] = s.nextInt();
			sumE = sumE + a[i];		
		}		
		Arrays.sort(a);
		int k=a[n-1];
		while(true){
			for(int i=0; i<n; i++){
				sumA = sumA + k-a[i];			
			}
			if(sumA>sumE){
				System.out.println(k);
				break;			
			}
			else
				k++;
				sumA=0;		
		}
	}
}