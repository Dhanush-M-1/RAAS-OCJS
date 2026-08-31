import java.util.Arrays;
import java.util.Scanner;


public class D1571B {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String[] strarr = str.split(" ");
		int n = Integer.parseInt(strarr[0]);
		int k = Integer.parseInt(strarr[1]);
		String list = s.nextLine();
		String[] listarr = list.split(" ");
		int[] q = new int[n];
		for(int i = 0; i < listarr.length; i++){
			q[i] = Integer.parseInt(listarr[i]);
		}
		Arrays.sort(q);
		
		int large = n%k;
		int small = k-large;
		
		int[][] dp = new int[small+1][large+1];
		for(int i = 0; i <= small; i++){
			Arrays.fill(dp[i],Integer.MAX_VALUE);
		}
		dp[0][0]=0;
		
		for(int i = 0; i <= small; i++){
			for(int j = 0; j <= large; j++){
				int qais = i*(n/k)+j*(n/k+1);
				
				if(i > 0){
					dp[i][j] = dp[i-1][j]+q[qais-1]-q[qais-(n/k)];
				}
				
				if(j >0){
					dp[i][j] = Math.min(dp[i][j],dp[i][j-1] + q[qais-1]-q[qais-(n/k)-1]);
				}

			}
		}
		
		System.out.println(dp[small][large]);
		
	}
}
