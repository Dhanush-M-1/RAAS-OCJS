import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class D21195 {
	
	private static long mod = 998244353;
	
	private static long[] m = new long[21];

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("F:/books/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		m[0]=1;
		long[] l = new long[21];
		for(int i=1;i<21;m[i]=(m[i-1]*10)%mod,i++);
		Integer n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		Long[] a = new Long[s.length];
		for (int i = 0; i < s.length; i++) {
			l[s[i].length()]++;
			a[i] = Long.parseLong(s[i]);
		}
		long ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < 21; j++) {
				ret += calc(a[i],0,j)*l[j];
				ret %= mod;
				ret += calc(a[i],1,j-1)*l[j];
				ret %= mod;
			}
		}
		System.out.println(ret);
	}

	private static long calc(Long n, int s, int l) {
		long ret = 0;
		while(n>0) {
			ret += m[s]*(n%10);
			ret %= mod;
			n /=10;
			s++;
			if(l>0) {
				l--;s++;
			}
		}
		return ret;
	}

}
