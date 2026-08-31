import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int MAX_INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        int[] a = new int[4];
        int r = 0, l = 0;
        while ((line = in.readLine()) != null) {
            st = new StringTokenizer(line, ",");
            a[0] = Integer.parseInt(st.nextToken());
            a[1] = Integer.parseInt(st.nextToken());
            a[2] = Integer.parseInt(st.nextToken());
            if (a[0] * a[0] + a[1] * a[1] == a[2] * a[2]) {
                r++;
            } 
            if (a[0] == a[1]) {
                l++;
            }
        }
        
        System.out.println(r);
        System.out.println(l);
    }
}
