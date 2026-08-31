import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CodeForcesDiv2A {

	public static void main(String[] args)throws IOException,NumberFormatException {
		try {
			FastScanner sc=new FastScanner();
			int n=sc.nextInt(),c=sc.nextInt();
			List<Integer> list=new ArrayList<>();
			int a[]=new int[n];
			for(int i=0;i<n;i++) {
				a[i]=sc.nextInt();
			}
			for(int i=0;i<n-1;i++) {
				list.add(a[i]-a[i+1]);
			}
			int max=Collections.max(list);
			if(max>=c) {
				System.out.println(max-c);
			}
			else {
				System.out.println(0);
			}
		}
		catch(Exception e) {
			return;
		}
	}
	public static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try { 
                                      st=new StringTokenizer(br.readLine());				               
                              } catch (IOException e) {}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		
	}
}
