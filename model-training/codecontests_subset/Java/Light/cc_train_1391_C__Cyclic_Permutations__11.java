import java.util.*;
import java.io.*;
public class EdC {

	public static void main(String[] args) throws Exception{
		long num = 1000000007;
		long[] fact = new long[1000001];
 		fact[0] = 1;
 		long ans1 = 1;
 		for(int i = 1;i<=1000000;i++){
 			ans1= (ans1*i) % num;
 			fact[i] = ans1;
 		}
		// TODO Auto-generated method stub
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		PrintWriter out = new PrintWriter(System.out);
 		int t = Integer.parseInt(bf.readLine());
 		long sum =0 ;
 		long prod = 1;
 		for(int j=t-2;j>=1;j--){
 			sum+= (((j*(fact[j+1])%num)*prod)%num+num)%num;
 			prod*=2;
 			prod%=num;
 			sum%=num;
 		}
 		
 		
 		out.println(sum);
	 		
 		out.close();
 		
 		
 		
 	}
	public static int power(long x, long y, long mod){
		long ans = 1;
		while(y>0){
			if (y%2==1)
				ans = (ans*x)%mod;
			x = (x*x)%mod;
			y/=2;
		}
		return (int)(ans);
	}
}
 	
 
//StringJoiner sj = new StringJoiner(" "); 
//sj.add(strings)
//sj.toString() gives string of those stuff w spaces or whatever that sequence is

 		
 		
 		
 		
	


