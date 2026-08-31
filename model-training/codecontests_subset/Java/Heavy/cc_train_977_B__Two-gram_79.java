import java.io.*;
import java.util.*;
import java.math.*;
 
public class B {
 
    public static void main(String[] args) throws IOException {
        FastScanner fs=new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
 
        // int T=fs.nextInt();
        // for (int tt=0; tt<T; tt++) {
            
        // }
 
        int n = fs.nextInt();
        String s = fs.next();

        String best = "";
        HashMap<String, Integer> hm = new HashMap();
        int max = 0;
        for (int i=1; i<n; i++) {
            String cur = s.charAt(i-1)+""+s.charAt(i);
            hm.put(cur, hm.getOrDefault(cur, 0) + 1);
            if (max<hm.get(cur)) {
                max = hm.get(cur);
                best = cur;
            }
        }
        out.println(best);
        

 
        out.close();
    }

 
 
    static final Random random=new Random();
    
    static void ruffleSort(int[] a) {
        int n=a.length;//shuffle, then sort 
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
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
