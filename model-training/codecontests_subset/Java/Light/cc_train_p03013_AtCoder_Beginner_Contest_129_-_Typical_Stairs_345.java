import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		long mod=1000000007;
		int[] a =new int[m];
		long[] dp=new long[n+1];
		dp[0]=1;
		for(int i=0; i<m; i++){
			a[i] = sc.nextInt();
			if(i!=0 && a[i]==a[i-1]+1){
				System.out.println(0);
				return;
			}
		}
		int count=0;
		boolean kk=false;
		for(int i=1; i<n+1; i++){
			if(m!=0 && !kk && i==a[count] && i!=n){
				count++;
				if(count>m-1){
					count=0;
					kk=true;
				}
				dp[i+1]=dp[i-1];
			}else{
				if(i==1){
					dp[i]+=dp[i-1];
					dp[i]%=mod;
					continue;
				}
				if(dp[i]==0){
					dp[i]+=dp[i-1]+dp[i-2];
					dp[i]%=mod;
				}
			}
		}
		System.out.println(dp[n]);
	}
}
