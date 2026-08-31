import java.lang.*;
import java.util.*;

public class run_for_your_prize{

	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int i,j,k;
		int p=0;
		int count=0;
		for(i=0;i<n;i++)
		{
			p=sc.nextInt();
			if(p<=1000000/2)
			{
				count=Math.max(p-1,count);
			}
			if(p>1000000/2)
			{
				count=Math.max(1000000-p,count);
			}
		}
		System.out.println(count);	
	}
}
