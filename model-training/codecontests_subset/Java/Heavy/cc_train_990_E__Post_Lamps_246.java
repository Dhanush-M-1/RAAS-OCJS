import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by pidvadi on 21.06.2018.
 */
public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int s[] = new int[m];
        int a[] = new int[k];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < k; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        if (m > 0 && s[0] == 0) {
            System.out.println("-1");
        } else {
            int block[] = new int[n];
            for (int i = 0; i < n; i++) {
                block[i] = -1;
            }
            for (int i = 0; i < m; i++) {
                if(block[s[i]-1] == -1) {
                    block[s[i]] = s[i]-1;
                } else {
                    block[s[i]] = block[s[i]-1];
                }
            }
            long MAX_COST = Long.MAX_VALUE;
            int max_inr = 0;
            if(m > 0){
                int inr = 1;
                int prev = s[0];
                for (int i = 1; i < m; i++) {
                    if(s[i] == prev+1){
                        inr += 1;
                    } else {
                        if(inr > max_inr){
                            max_inr = inr;
                        }
                        inr  = 1;
                    }
                    prev = s[i];
                }
                if(inr > max_inr){
                    max_inr = inr;
                }
            }
            double best_cost[] = new double[k];
            for (int i = 0; i < k; i++) {
                if(i < max_inr){
                    best_cost[i] = MAX_COST;
                } else {
                    best_cost[i] = a[i] * Math.ceil(1.0*n / (i+1));
                }
            }
            Integer[] best_cost_ind = new Integer[k];
            for (int i = 0; i < k; i++) {
                best_cost_ind[i] = i;
            }
            Arrays.sort(best_cost_ind, (o1, o2) -> Double.compare(best_cost[o1], best_cost[o2]));
            double min_cost = MAX_COST;
            for (int i = 0; i < k; i++) {
                int test = best_cost_ind[i];
                if(best_cost[test] >= min_cost) break;
                int t_size = test+1;
                int pos = 0;
                int count = 1;
                while(pos < n){
                    int new_pos = pos + t_size;
                    if(new_pos >= n) break;
                    if(block[new_pos] != -1){
                        new_pos = block[new_pos];
                    }
                    pos = new_pos;
                    count ++;
                }
                min_cost = Math.min(min_cost, 1.0*a[test]*count);
            }
            if(min_cost < MAX_COST){
                System.out.println(new Double(min_cost).longValue());
            }else{
                System.out.println("-1");
            }



        }


    }
}
