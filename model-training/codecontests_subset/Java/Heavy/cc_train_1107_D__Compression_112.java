
import java.io.*;
import java.util.*;

public class B{

	static String z="0123456789ABCDEF";
	static ArrayList<Integer>primes;
	static void sieve() {
		int n=a.length;
		primes=new ArrayList();
		boolean []isPrime=new boolean[n+10];
		Arrays.fill(isPrime, true);
		for(int i=2;i<=n;i++) {
			if(isPrime[i]) {
				primes.add(i);
				for(int j=i+i;j<=n;j+=i)
					isPrime[j]=false;
			}
		}
	}
	static int [][]a;
	static String get(char c) {
		String ans;
		if(c<='9') {
			ans=Integer.toBinaryString(c-'0');
		}
		else
			ans=Integer.toBinaryString(c-'A'+10);
		while(ans.length()<4) {
			ans='0'+ans;
		}
		return ans;
	}
	static int getIdx(char c) {
		return z.indexOf(c);
	}
	static boolean can(int x) {
		int n=a.length;
		int [][]b=new int [n/x][n/x];
		for(int []y:b)
			Arrays.fill(y,-1);
		for(int i=0;i<n;i++){
			int k=(i+x)/x-1;
			for(int j=0;j<n;j++)
			{
				int tmp=a[i][j];
				int k2=(j+x)/x-1;
				
				if(b[k][k2]!=-1 && b[k][k2]!=tmp)
					return false;
				b[k][k2]=tmp;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner();
		PrintWriter out=new PrintWriter(System.out);
		int n=sc.nextInt();
		String []codes=new String[z.length()];
		for(int i=0;i<z.length();i++)
			codes[i]=get(z.charAt(i));
		
		a=new int [n][n];
		for(int i=0;i<n;i++)
		{
			char []s=sc.next().toCharArray();
			int j=0;
			while(j<n) {
				char c=s[j/4];
				String code=codes[getIdx(c)];
				
				for(int k=0;k<4;k++)
					a[i][j++]=code.charAt(k)-'0';
				
			}
		}
		sieve();
		int ans=1;
		for(int p:primes) {
			int x=p;
			int z=1;
			while(n%x==0) {
				if(can(x))
				{
					z=x;
					x=x*p;
				}
				else
					break;
			}
			ans=ans*z;
		}
		out.println(ans);
		out.close();

	}
	static class Scanner
	{
		BufferedReader br;
		StringTokenizer st;
		Scanner(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		Scanner(String fileName) throws FileNotFoundException{
			br=new BufferedReader(new FileReader(fileName));
		}
		String next() throws IOException {
			while(st==null || !st.hasMoreTokens())
				st=new StringTokenizer(br.readLine());
			return st.nextToken();
		}
		String nextLine() throws IOException {
			return br.readLine();
		}
		int nextInt() throws IOException{
			return Integer.parseInt(next());
		}
		long nextLong()  throws NumberFormatException, IOException {
			return Long.parseLong(next());
		}
		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(next());
		}
	}
}
