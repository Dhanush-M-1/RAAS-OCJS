import java.io.*; 
import java.util.*;
  
public class Main {
	
    static class FastScanner
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastScanner() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
  
    public static void main(String[] args) throws IOException {
        FastScanner sc=new FastScanner();
        HashSet<String> targets = new HashSet<String>();
        targets.add(sc.next());
        targets.add(sc.next());
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
        	print(targets);
        	targets.remove(sc.next());
        	targets.add(sc.next());
        }
        print(targets);
    }
    
    public static void print(HashSet<String> targets) {
    	for (String s: targets) {
    		System.out.print(s + " ");
    	}
    	System.out.println();
    }
}