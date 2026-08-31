
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/* Name: chilliagon
 * Date: 9.1.21
 * Lang: Java
 */
public class cp {

	public static void main(String[] args) {
		FastScanner in=new FastScanner();
		int n = in.nextInt();
		int k = in.nextInt();
		int[] buckets = new int[n];
		for(int i = 0;i<n;i++){
			buckets[i] = in.nextInt();
			
		}
		sort(buckets);
		int curr = n-1;
		boolean condition = true;
		while(condition = true){
			if (curr<0){
				 condition = false;
				 break;
			 }
			else{
				if(k%buckets[curr] == 0){
					System.out.println(k/buckets[curr]);
					condition =false;
					break;
				}
				else{
					curr--;
				}
				
			}
		}
		
		
		
	}

	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
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
	}

	
}



