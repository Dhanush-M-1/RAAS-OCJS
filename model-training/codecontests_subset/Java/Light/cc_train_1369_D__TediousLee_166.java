import java.util.*;
import java.lang.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		
		int k=sc.nextInt();
		long[] ans=new long[2000001];
		ans[3]=1;
		ans[4]=1;
		for(int i=5;i<2000001;i++){
		    
		    ans[i]=(ans[i-1]+2*ans[i-2])%1000000007;
		    if(i%3==0)ans[i]+=1;
		    ans[i]%=1000000007;
		}
		while(k-->0){
		    int n=sc.nextInt();
		    System.out.println((ans[n]*4)%1000000007);
		}
		
	}
}