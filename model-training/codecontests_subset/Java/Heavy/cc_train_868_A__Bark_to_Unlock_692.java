import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		FastScanner sc=new FastScanner();
		PrintWriter pw=new PrintWriter(System.out);
		while(sc.hasNext()){
			String s=sc.next();
			boolean flag=false;
			int n=sc.nextInt();
			String[]ss=new String[n];
			for(int i=0;i<n;i++){
				ss[i]=sc.next();
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					String temp1=ss[i]+ss[j];
					String temp2=ss[j]+ss[i];
					if(temp1.contains(s)){
						flag=true;
						break;
					}
					if(temp2.contains(s)){
						flag=true;
						break;
					}
				}
			}
			if(flag){
				pw.println("YES");
			}else{
				pw.println("NO");
			}
			pw.flush();
		}

	}
}

class FastScanner {
	BufferedReader br;
	StringTokenizer st;

	public FastScanner() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in),32768);
			st = new StringTokenizer("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean hasNext() {
		while (!st.hasMoreTokens()) {
			String line = nextLine();
			if (line == null) {
				return false;
			}
			st = new StringTokenizer(line);
		}
		return true;
	}

	public String next() {
		while(!st.hasMoreTokens()){
			st=new StringTokenizer(nextLine());
		}
		return st.nextToken();
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

	public String nextLine() {
		String line = "";
		try {
			line = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}
}