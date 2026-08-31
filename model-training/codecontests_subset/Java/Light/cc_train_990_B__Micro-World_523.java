
import java.util.*;
import java.io.*;

public class Micro{
    
    static int N, M, K;
    static String s;
    static StringTokenizer st;
    static int[] d;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        PrintWriter out = new PrintWriter(System.out);
        
        TreeSet<Integer> ts = new TreeSet();
        LinkedList<Integer> d = new LinkedList();
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            ts.add(a);
            d.add(a);
        }
        
        int ans = 0;
        for (int e: d) {
           
            if(ts.floor(e + K) != null && ts.floor(e + K) == e){
                ans++;
            }
        }
        
        System.out.println(ans);
        
        out.close();
    }    
}
