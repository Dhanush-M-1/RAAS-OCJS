import java.util.Arrays;
import java.util.Scanner;


public class A226 {

	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int c=sc.nextInt();
		int[]prices=new int[n];
		int[]profits=new int[n];
		int profit=0;
		for(int i=0;i<n;i++)
			prices[i]=sc.nextInt();
		
		profit=prices[0]-c;
			for(int i=1;i<n;i++){
			profits[i-1]=profit-prices[i];
			profit=prices[i]-c;
		}
			int max=0;
			for(int i=0;i<n;i++)
				if(profits[i]>max)
					max=profits[i];
		profit=max;
		
	
		//System.out.println(Arrays.toString(profits));
		
		System.out.println(profit);
	}
}