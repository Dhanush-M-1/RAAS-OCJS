import java.io.*;
import java.util.*;

public class B {

	public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while(t-->0) { 
        	int n = in.nextInt();
        	char ch[][] = new char[n][n];
        	for(int i=0;i<n;i++) ch[i] = in.next().toCharArray();
        	ArrayList<Integer> ans = new ArrayList<>();
        	if(ch[0][1]==ch[1][0]&&ch[1][0]=='1'){
        		if(ch[n-1][n-2]=='1') ans.add(400*n+(n-1));
        		if(ch[n-2][n-1]=='1') ans.add(400*(n-1)+n);
        	}
        	else if(ch[0][1]==ch[1][0]&&ch[1][0]=='0')
        	{
        		if(ch[n-1][n-2]=='0') ans.add(400*n+(n-1));
        		if(ch[n-2][n-1]=='0') ans.add(400*(n-1)+n);
        	}
        	else if(ch[n-1][n-2]==ch[n-2][n-1]&&ch[n-2][n-1]=='0')
        	{
        		if(ch[0][1]=='0') ans.add(400*1+2);
        		if(ch[1][0]=='0') ans.add(400*2+1);
        	}
        	else if(ch[n-1][n-2]==ch[n-2][n-1]&&ch[n-2][n-1]=='1')
        	{
        		if(ch[0][1]=='1') ans.add(400*1+2);
        		if(ch[1][0]=='1') ans.add(400*2+1);
        	}
        	else{
        		if(ch[0][1]=='0'){
        			ans.add(400*1+2);
        		}
        		if(ch[1][0]=='0'){
        			ans.add(400*2+1);
        		}
        		if(ch[n-1][n-2]=='1'){
        			ans.add(400*n+n-1);
        		}
        		if(ch[n-2][n-1]=='1'){
        			ans.add(400*(n-1)+n);
        		}
        	}
        	out.println(ans.size());
        	for(int i : ans){
        		out.println((i/400) + " "+ (i%400));
        	}
        }
        out.flush();
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens())
				try { st = new StringTokenizer(br.readLine()); }
				catch(IOException e) {}
			return st.nextToken();
		}
		
		String nextLine(){
			try{ return br.readLine(); } 
			catch(IOException e) { } return "";
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int[] readArray(int n) {
			int a[] = new int[n];
			for(int i=0;i<n;i++) a[i] = nextInt();
			return a;
		}
	}

	static final Random random = new Random();

	static void ruffleSort(int[] a){
		int n = a.length;
		for(int i=0;i<n;i++){
			int j = random.nextInt(n), temp = a[j];
			a[j] = a[i]; a[i] = temp;
		}
		Arrays.sort(a);
	}
}
