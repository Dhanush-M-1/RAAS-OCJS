import java.io.*;
import java.util.*;
public class SubInRybinsk {
	static long ans = 0, MOD = 998244353, power[] = new long[20];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		int len[] = new int[11];
		for(int i = 0; i < N; ++i) {
			String s = (st.nextToken());
			arr[i] = Integer.parseInt(s);
			++len[s.length()];
		}
		for(int i = 0; i < N; ++i) {
			String s = Integer.toString(arr[i]);
			for(int j = 1; j <= 10; ++j) {
				long terp = 0;
				if(s.length()>=j) {
					int dex = 0;
					for(int k = s.length()-1; k > s.length()-1-j; --k) {
						int temp = Integer.parseInt(Character.toString(s.charAt(k)));
						terp = add(mult(temp, pow(10,dex)), add(mult(temp,pow(10, dex+1)),terp));
						dex+=2;
					}
					for(int k = s.length()-1-j; k >= 0; --k) {
						int temp = Integer.parseInt(Character.toString(s.charAt(k)));
						int eye = s.length()-1-j-k;
						terp = add(2*mult(temp,pow(10,2*j+eye)),terp);
					}
				}else {
					int dex = 0;
					for(int k = s.length()-1; k >=0;--k) {
						int temp = Integer.parseInt(Character.toString(s.charAt(k)));
						terp = add(mult(temp, pow(10,dex)), add(mult(temp,pow(10, dex+1)),terp));
						dex += 2;
					}
				}
				//if(len[j]>0) System.out.println(terp+" " + j);
				ans = add(ans,mult(len[j],terp)); 
				//if()
			}
		}
		System.out.println(ans);
	}
	private static long mult(long i, long j) {
		// TODO Auto-generated method stub
		return ((long)i*j)%MOD;
	}
	private static long add(long l, long terp) {
		// TODO Auto-generated method stub
		return (l+terp)%MOD;
	}
	private static long pow(int num, int dex) {
		// TODO Auto-generated method stub
		if(power[dex]>0) return power[dex];
		long c = 1;
		for(int i = 0; i < dex; ++i) {
			c*= num; c%=MOD;
		}
		return power[dex] = c;
	}

}
