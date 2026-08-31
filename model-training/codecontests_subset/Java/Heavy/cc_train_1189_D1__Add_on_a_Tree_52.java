//I AM THE CREED
/* //I AM THE CREED
/* package codechef; // don't place package name! */
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;
import java.awt.Point;
public class Main{
    
    public static void main(String[] args) throws IOException 
    { 
        
        FastScanner input = new FastScanner();
        int n=input.nextInt();
        int[] deg=new int[n];
        for(int i=0;i<n-1;i++){
            deg[input.nextInt()-1]++;
            deg[input.nextInt()-1]++;
        }
        boolean possible=true;
        for(int i=0;i<n;i++){
            if(deg[i]==2){
                possible=false;
            }
        }
        System.out.println(possible?"YES":"NO");
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
