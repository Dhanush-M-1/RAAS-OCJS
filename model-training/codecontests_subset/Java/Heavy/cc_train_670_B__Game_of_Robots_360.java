import java.util.*;
import java.lang.*;

public class A
{
	public static Scanner scn=new Scanner(System.in);
	public static void main (String[] args) throws java.lang.Exception
	{
	
		int n;
		long k;
		
		StringTokenizer st=new StringTokenizer(scn.nextLine());
		n=Integer.parseInt(st.nextToken()); k=Long.parseLong(st.nextToken());
		
		//st=new StringTokenizer(scn.nextLine());
		int x=0,sum=0; long track=0;
		int arr[]=new int[100000];
		//StringBuffer sup=new StringBuffer();
		for(int i=0;i<n;i++){
			arr[i]=scn.nextInt();
			sum++;
			x+=sum;
			
			if(x>=k){
				int a=(int)(k-(x-sum));
				System.out.println(arr[a-1]);
				break;
			}
			
			
			
		}
	}
}
