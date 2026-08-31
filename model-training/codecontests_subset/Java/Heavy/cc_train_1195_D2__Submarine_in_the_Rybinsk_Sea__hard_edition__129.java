import java.io.*;
import java.util.*;

public class A {

	static 	long []pow=new long [100];

	static long solve(int len,int cnt,char []s) {
//		System.out.println(len+" "+cnt);
//		System.out.println(s);
		long ans=0;
		int n=s.length,j=0,i=n-1;
		for(int pro=1;i>=0;i--,pro++) {
			
			int x=s[i]-'0';
			ans+=x*pow[j]%MOD;
//			System.out.println(x+" "+j);
			if(pro>len) {
				i--;
				j++;
				break;
			}
			j+=2;
		}
		while(i>=0) {
			int x=s[i--]-'0';
//			System.out.println(x+" "+j);

			ans+=pow[j++]*x%MOD;
			ans%=MOD;
		}
		return ans*cnt%MOD;
	}

	static long solveSec(int len,int cnt,char []s) {
		long ans=0;
		int n=s.length,j=0,i=n-1;
		for(int pro=1;i>=0 && pro<=len;i--,pro++) {
			j++;
			int x=s[i]-'0';
			ans+=x*pow[j]%MOD;
			
			j++;
		}
//		j++;
		while(i>=0) {
			int x=s[i--]-'0';
			ans+=pow[j++]*x%MOD;
			ans%=MOD;
		}
		return ans*cnt%MOD;
	}
	static int MOD= 998244353;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner();
		PrintWriter out = new PrintWriter(System.out);
		int n=sc.nextInt();
		pow[0]=1;
		for(int i=1;i<pow.length;i++)
			pow[i]=pow[i-1]*10%MOD;
		int []cnt=new int [15];
		char [][]nums=new char[n][];
		long ans=0;
		for(int k=0;k<n;k++) {
			nums[k]=sc.next().toCharArray();
			cnt[nums[k].length]++;
		}
		for(char []x:nums) {
			for(int len=1;len<15;len++) {
				ans+=solve(len, cnt[len], x);
				ans+=solveSec(len, cnt[len], x);
				ans%=MOD;
			}
		}
		out.println(ans);
		out.close();

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		Scanner(String fileName) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(fileName));
		}

		String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		String nextLine() throws IOException {
			return br.readLine();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}

		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}

		boolean ready() throws IOException {
			return br.ready();
		}

	}

}