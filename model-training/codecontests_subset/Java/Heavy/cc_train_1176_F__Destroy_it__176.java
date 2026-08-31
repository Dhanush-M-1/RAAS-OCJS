import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class practice {
    static class FastReader {
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
    public static FastReader scn = new FastReader();
    static long total = 0;
    static int count = 1;

    public static void main(String[] args){
        int n = scn.nextInt();
        long[][] dp = new long[n+1][10];
        for(int i = 0; i<=n; i++) Arrays.fill(dp[i],-1);
        dp[0][0] = 0;

        for(int t = 0; t<n; t++){
            int k = scn.nextInt();
            long max2 = 0, max3 = 0;
            ArrayList<Long> max1 = new ArrayList<>();
            for(int i = 0; i<k; i++){
                int c = scn.nextInt();
                long d = scn.nextLong();

                if(c==2) max2 = Math.max(max2,d);
                if(c==3) max3 = Math.max(max3,d);
                if(c==1) max1.add(-1*d);
            }

            Collections.sort(max1);
            for(int i =0; i<max1.size(); i++) max1.set(i,-1*max1.get(i));

            for(int i = 0; i<10; i++){
                dp[t+1][i] = Math.max(dp[t+1][i],dp[t][i]);
            }

            long best = Math.max(max2,max3);
            if(max1.size()>0) best = Math.max(best,max1.get(0));

            if(best > 0){
                for(int i = 0; i<10; i++){
                    if(dp[t][i]>-1 && i<9){
                        dp[t+1][i+1] = Math.max(dp[t+1][i+1],dp[t][i] + best);
                    }else if(dp[t][i]>-1 && i==9){
                        dp[t+1][(i+1)%10] = Math.max(dp[(t+1)][(i+1)%10],dp[t][i] + 2*best);
                    }
                }
            }

            if(max1.size()>0 && max2>0){
                long sum = max1.get(0) + max2;
                best = Math.max(max2,max1.get(0));

                for(int i = 0; i<10; i++){
                    if(dp[t][i]>-1 && i<8){
                        dp[t+1][i+2] = Math.max(dp[t+1][i+2],dp[t][i] + sum);
                    }else if(dp[t][i]>-1 && i>=8){
                        dp[t+1][(i+2)%10] = Math.max(dp[(t+1)][(i+2)%10],dp[t][i] + sum + best);
                    }
                }
            }

            if(max1.size()>1){
                long sum = max1.get(0) + max1.get(1);
                best = max1.get(0);

                for(int i = 0; i<10; i++){
                    if(dp[t][i]>-1 && i<8){
                        dp[t+1][i+2] = Math.max(dp[t+1][i+2],dp[t][i] + sum);
                    }else if(dp[t][i]>-1 && i>=8){
                        dp[t+1][(i+2)%10] = Math.max(dp[(t+1)][(i+2)%10],dp[t][i] + sum + max1.get(0));
                    }
                }
            }

            if(max1.size()>2){
                long sum = max1.get(0) + max1.get(1) + max1.get(2);
                best = max1.get(0);

                for(int i = 0; i<10; i++){
                    if(dp[t][i]>-1 && i<7){
                        dp[t+1][i+3] = Math.max(dp[t+1][i+3],dp[t][i] + sum);
                    }else if(dp[t][i]>-1 && i>=7){
                        dp[t+1][(i+3)%10] = Math.max(dp[(t+1)][(i+3)%10],dp[t][i] + sum + best);
                    }
                }
            }

        }

        long res = 0;
        for(int i = 0; i<10; i++) res = Math.max(res,dp[n][i]);

        System.out.println(res);
    }


}