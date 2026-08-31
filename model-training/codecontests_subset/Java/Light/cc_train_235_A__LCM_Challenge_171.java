import java.io.*;
import java.util.*;
public class LCMChallenge{
	public static long gcd(long a, long b){
		return (b==0)?a:gcd(b, a%b);
	}
	public static void main(String fdjkfd[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());
		if(n>=3){
		long max = -1;
		long tmp = n*n-n;
		for(long i=n-2;i>0;i--){
			max = (long)Math.max(max, tmp*i/(gcd(n,i)*gcd(n-1,i)));
			if((i&1)==1 && gcd(i, i+2)==1)
				max = (long)Math.max(max, i*(i+1)*(i+2));
		}
		System.out.println(max);
		}
		else
			System.out.println(n);
	}
}
