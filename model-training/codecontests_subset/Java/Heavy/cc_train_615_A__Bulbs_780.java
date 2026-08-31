import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://codeforces.com/problemset/problem/615/A
public class Bulbs {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int buttons = Integer.parseInt(st.nextToken());
        int bulbs = Integer.parseInt(st.nextToken());
        int[] on = new int[bulbs+1];
        int count = 0;
        for(int i=0; i<buttons; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            for(int j=0; j<n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num != 0 && on[num] == 0) {
                    on[num] = 1;
                    if(++count == bulbs) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }
        System.out.println("NO");

    }

}
