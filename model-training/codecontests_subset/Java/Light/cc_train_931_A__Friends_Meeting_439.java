
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

/**
 * Created by David on 3/4/2018.
 */
public class anyshit {
    static FastScanner fastScanner = new FastScanner();

    public static void main(String[] args) {

        int a = fastScanner.nextInt();
        int b =fastScanner.nextInt();
        if(a>b){
            int temp = a;
            a = b;
            b = temp;
        }
        long totalTiredeness =0;
        int count = 1;
        while(true){
            a++;
            totalTiredeness+=count;
            if(a==b) break;
            b--;
            totalTiredeness+=count;

            if(a==b) break;
            count++;

        }


        System.out.println(totalTiredeness);

    }
}

class FastScanner {

    BufferedReader br;
    StringTokenizer st;

    public FastScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}


