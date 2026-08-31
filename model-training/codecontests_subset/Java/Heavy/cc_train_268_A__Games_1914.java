
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        FastReader read = new FastReader();
        int n = read.nextInt();
        Pair arr[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(read.nextInt(), read.nextInt());
        }
        int ans = 0; 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if( i == j )
                    continue; 
                if(arr[i].x == arr[j].y){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

}

class Pair implements Comparable<Pair> {

    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.x - o.x != 0) {
            return this.x - o.x;
        } else {
            return o.y - this.y;
        }
    }

}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
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

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
