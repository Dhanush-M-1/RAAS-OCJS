import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		// 整数の入力
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] t = new int[n+1];
		boolean flg = true;
		int ans = 0;
		int mod = 1000000007;

		for(int i=0;i<m;i++)t[sc.nextInt()]=-1;
		t[0]=1;

		for(int i=0;i<n-1;i++){
			if(t[i]!=-1){
				if(t[i+1]!=-1){
					t[i+1]=(t[i]+t[i+1])%mod;
				}
				if(t[i+2]!=-1){
					t[i+2]=(t[i]+t[i+2])%mod;
				}
				if(t[i+1]==-1&&t[i+2]==-1){
					flg=false;
					break;
				}
			}
		}

		if(flg){
			if(t[n-1]!=-1){
				ans = (t[n]+t[n-1])%mod;
				
			} else {
				ans = t[n]%mod;
			}
		}

		// 出力
		System.out.println(ans);
	}
}