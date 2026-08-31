import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int k=in.nextInt();
		int[] arr=new int[n+1];
		for(int i=1;i<=n;++i) {
			arr[i]=in.nextInt();
		}
		
		Arrays.sort(arr,1,n+1);//
		
		//两种长度的子数组长度和数量
		int cntLong=n%k;
		int cntShort=k-cntLong;
		int lenLong=n/k+1;
		int lenShort=n/k;
		
		//dp
		int[][] dp=new int[cntLong+1][cntShort+1];//
		for(int i=0;i<=cntLong;++i) {//
			Arrays.fill(dp[i], Integer.MAX_VALUE);//
		}
		dp[0][0]=0;
		
		for(int i=0;i<=cntLong;++i) {//
			for(int j=0;j<=cntShort;++j) {//
				if(i!=0) {
					int idxStart=(i-1)*lenLong+j*lenShort+1;
					int idxEnd=i*lenLong+j*lenShort;
					dp[i][j]=Math.min(dp[i][j], dp[i-1][j]+arr[idxEnd]-arr[idxStart]);
				}
				if(j!=0) {
					int idxStart=i*lenLong+(j-1)*lenShort+1;
					int idxEnd=i*lenLong+j*lenShort;
					dp[i][j]=Math.min(dp[i][j], dp[i][j-1]+arr[idxEnd]-arr[idxStart]);
				}
			}
		}
		System.out.println(dp[cntLong][cntShort]);//
	}	
}