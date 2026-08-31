import java.util.*;
import java.io.PrintWriter;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int k=sc.nextInt();
		long[][] dp=new long[s.length()][k+1];
		int count=0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)!='0'){
				count++;
			}
			if(i==0){
				dp[0][1]=s.charAt(i)-'0';
			}else{
				dp[i][1]=dp[i-1][1]+9;
				for(int j=2; j<=k; j++){
					if(count==j && s.charAt(i)!='0'){
						dp[i][j]+=(dp[i-1][j-1]-1)*9+dp[i-1][j]+(s.charAt(i)-'0');
					}else if(count+1==j && s.charAt(i)=='0'){
						dp[i][j]+=(dp[i-1][j-1]-1)*9+dp[i-1][j];
					}else{
						dp[i][j]+=dp[i-1][j-1]*9+dp[i-1][j];
					}
				}
			}
		}
		
		System.out.println(dp[s.length()-1][k]);
	}
}
