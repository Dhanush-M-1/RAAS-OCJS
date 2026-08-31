import java.util.*;
public class Mat{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int len=2000002;
		int mod=1000000007;
		long ans[]=new long[len];
		
		ans[1]=0;
		ans[2]=0;
		ans[3]=1;
		for(int i=4;i<len;i++){
			
			if(i%3==0)
			   ans[i]=(ans[i-1]%mod+ans[i-2]%mod+ans[i-2]%mod+1 )%mod;
			else   
		       ans[i]=(ans[i-1]%mod+ans[i-2]%mod+ans[i-2]%mod)%mod;
		       
		}
		while(t-->0){
			int n=sc.nextInt();
			long res=(ans[n]*4)%mod;
			System.out.println(res);
			
			
			
		}
	}
}


