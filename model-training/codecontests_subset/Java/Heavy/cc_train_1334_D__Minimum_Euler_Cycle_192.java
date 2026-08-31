import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException 
	{ 
		FastScanner f = new FastScanner(); 
		int t=1;
		t=f.nextInt();
		PrintWriter out=new PrintWriter(System.out);
		for(int tt=0;tt<t;tt++) {
			int n=f.nextInt();
			long L=f.nextLong()-1;
			long R=f.nextLong()-1;
			long base = 0;
			for(int i = 1;i <= n-1;i++){
				long len = 2*(n-i)-1;
				if(Math.max(base, L) <= Math.min(base+len-1, R)){
					for(int j = 0;j < len;j++){
						if(L <= base+j && base+j <= R){
							if(j % 2 == 0){
								out.print(i + " ");
							}else{
								out.print(j/2+i+1 + " ");
							}
						}
					}
				}
				
				base += len;
				if(L <= base && base <= R){
					out.print(n + " ");
				}
				base++;
			}
			if(L <= base && base <= R){
				out.print(1 + " ");
			}
			base++;
			out.println();
		}
		out.close();
	} 
	static void sort(int [] a) {
        ArrayList<Integer> q = new ArrayList<>();
        for (int i: a) q.add(i);
        Collections.sort(q);
        for (int i = 0; i < a.length; i++) a[i] = q.get(i);
    }
    
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		long[] readLongArray(int n) {
			long[] a=new long[n];
			for (int i=0; i<n; i++) a[i]=nextLong();
			return a;
		}
	}
} 	
//Some things to notice
//Check for the overflow
//Binary Search
//Bitmask