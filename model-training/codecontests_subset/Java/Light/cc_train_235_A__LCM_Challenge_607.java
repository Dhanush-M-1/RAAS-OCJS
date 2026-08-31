import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class hals {
	
	static long gcd(long a,long b){
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long max = 0,res;
		for(long j=n;j>=3;j--){
			long temp = j*(j-1);
			for(long k=j ; k>=1;k--){
				if(gcd(temp,k)==1){
					temp*=k;break;
				}
			}
			if(temp>max)
				max=temp;
		}
		if(n==2){
			res=2;
		}
		else if(n==1)
			res=1;
		else
			res=max;
		
		System.out.println(res);
	}
}