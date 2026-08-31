import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
 
import java.util.*;
public class Main {
	Scanner cin = new Scanner(System.in);
	String s;
	int S,N;
	int[] ans,op;
	ArrayList<Integer> plist,mlist;
	public boolean dfs(int n,int sum){
		if(n == N){
			return sum == S;
		}
		
		for(int i = 1;i<=S;i++){
			boolean ret;
			if(op[n] == 0)ret = dfs(n + 1,sum + i);
			else ret = dfs(n + 1,sum - i);
			
			if(ret){
				ans[n] = i;
				return true;
			}
		}
		return false;
	}
	public void solve(){
		s = cin.nextLine();
		S = Integer.parseInt(s.substring(s.indexOf("=") + 2));
		int plus = 1;
		int minus = 0;
		for(int i = 0;i < s.length();i++){
			if(s.charAt(i) == '+')plus++;
			else if(s.charAt(i) == '-')minus++;
		}
		
		N = plus + minus;
		ans = new int[N];
		op = new int[N];
		int it = 0;
		op[it] = 0;
		it = 1;
		for(int i = 0;i < s.length();i++){
			if(s.charAt(i) == '+'){
				op[it] = 0;
				it++;
			}else if(s.charAt(i) == '-'){
				op[it] = 1;
				it++;
			}
		}
		if(plus == 1 && minus == 0){
			out.println("Possible");
			out.println(S + " = " + S);
			return;
		}
		else if(plus <= minus){
			int plusSum = (plus  - 1)* S;
			int minusCnt = 0;
			ans[0] = S;
			for(int i = 1;i < N;i++){
				if(op[i] == 1){
					int m = minus - minusCnt - 1;
					if(plusSum <= m){
						out.println("Impossible");
						return;
					}
					
					ans[i] = Math.min(S,plusSum - m);
					plusSum -= ans[i];
					minusCnt++;
				}else{
					ans[i] = S;
				}
			}
		}else if(plus > minus){
			int minusSum = minus * S + (S - 1);
			int plusCnt = 1;
			ans[0] = 1;
			for(int i = 1;i < N;i++){
				if(op[i] == 0){
					int p = plus - plusCnt - 1;
					if(minusSum <= p){
						out.println("Impossible");
						return;
					}
					ans[i] = Math.min(S,minusSum - p);
					minusSum -= ans[i];
					plusCnt++;
				}else{
					ans[i] = S;
				}
			}
		}
		
		out.println("Possible");
		out.print(ans[0]);
		for(int i = 1;i < N;i++){
			out.print(" " + (op[i] == 0 ? "+ " : "- ") + ans[i]);
		}
		out.println(" = " + S);
	}
 
	public static void main(String[] args) {
		out.flush();
		new Main().solve();
		out.close();
	}
 
	/* Input */
	private static final InputStream in = System.in;
	private static final PrintWriter out = new PrintWriter(System.out);
	private final byte[] buffer = new byte[2048];
	private int p = 0;
	private int buflen = 0;
 
	private boolean hasNextByte() {
		if (p < buflen)
			return true;
		p = 0;
		try {
			buflen = in.read(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (buflen <= 0)
			return false;
		return true;
	}
 
	public boolean hasNext() {
		while (hasNextByte() && !isPrint(buffer[p])) {
			p++;
		}
		return hasNextByte();
	}
 
	private boolean isPrint(int ch) {
		if (ch >= '!' && ch <= '~')
			return true;
		return false;
	}
 
	private int nextByte() {
		if (!hasNextByte())
			return -1;
		return buffer[p++];
	}
 
	public String next() {
		if (!hasNext())
			throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = -1;
		while (isPrint((b = nextByte()))) {
			sb.appendCodePoint(b);
		}
		return sb.toString();
	}
 
	public int nextInt() {
		return Integer.parseInt(next());
	}
 
	public long nextLong() {
		return Long.parseLong(next());
	}
 
	public double nextDouble() {
		return Double.parseDouble(next());
	}
}