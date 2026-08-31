import java.io.*;
import java.util.*;
import java.lang.*;

public class Sol {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        TreeSet<Integer> ts = new TreeSet<Integer>();
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            while(x-- > 0) ts.add(Integer.parseInt(st.nextToken()));
        }
        out.println( (ts.size() == m ? "YES" : "NO") );
        br.close(); out.close();
    }
}