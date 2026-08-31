import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Round582_3_d2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayList<Integer>[]  ai = new ArrayList[200001];
        for(int i=0 ; i<200001 ; i++) {
            ai[i] = new ArrayList<>();
        }

        for(int i=0 ; i<n ; i++) {
            int x = Integer.parseInt(st.nextToken());
            int curr = 0;
            while(x != 0) {
                ai[x].add(curr);
                x >>= 1;
                curr++;
            }
            ai[0].add(curr);
        }

        long min = Long.MAX_VALUE;
        for(int i=0 ; i<200001 ; i++) {
            if(ai[i].size() >= k) {
                Collections.sort(ai[i]);
                long sum = 0;
                for(int j=0 ; j<k ; j++) {
                    sum += ai[i].get(j);
                }

                min = Math.min(sum, min);
            }
        }

        System.out.println(min);
    }
}
