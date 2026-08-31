import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by nadya on 6/11/17.
 */
public class Educational {
    public static void main(String[] args) throws IOException {
        Educational c = new Educational();
        c.start();
    }

    private void start() throws IOException {
        //BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(str.nextToken());
        for (int i  = 0; i < n; ++i) {
            str = new StringTokenizer(in.readLine());
            int l = Integer.parseInt(str.nextToken());
            int r = Integer.parseInt(str.nextToken());
            int d = Integer.parseInt(str.nextToken());
            
            if ( l > d) {
                System.out.println(d);
                continue;
            }
            int k = (int)(r / d);
            int m = (int) (r % d);
            if(m == 0)  {
                System.out.println(r + d);
                continue;
            }
            
            System.out.println((k + 1) * d);
        }
    }
}