import java.io.*;
import java.util.*;  
public class Main {
	public static long fastPow(int num, int mod)
	{
		if(num==0)return 1;
		long val=fastPow(num/2, mod);
		if(num%2==0)return (val*val)%mod;
		return (2*val*val)%mod;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		int num=1000000000+7;
		long fac=1;
		for (int i = 2; i <= n; i++) {
			fac=(fac*i)%num;
		}
		long not=fastPow(n-1, num);
		pw.println((fac-not+num)%num);
		pw.close();
	}
}
