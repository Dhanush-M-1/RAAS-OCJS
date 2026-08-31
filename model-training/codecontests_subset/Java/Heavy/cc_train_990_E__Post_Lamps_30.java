import java.util.*;
import java.lang.*;
import java.io.*;

public class PostLamps {

    public static void main(String args[]) throws IOException {
        FastReader in = new FastReader();
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        Task.solve(in, out);
        out.close();
    }

    static class Task {

        public static void solve(FastReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int[] next = new int[n+1];
            boolean[] blocked = new boolean[n+1];
            for(int i=0;i<m;i++){
                int val = in.nextInt();
                blocked[val] = true;
            }

//            System.out.println(Arrays.toString(blocked));
            next[n] = Integer.MAX_VALUE;
            for(int i=n-1;i>=0;i--){
                if(!blocked[i]){
                    next[i] = i;
                }else{
                    next[i] = next[i+1];
                }
            }

            long[] cost = new long[k+1];
            for(int i=1;i<=k;i++){
                cost[i] = in.nextLong();
            }

            if(blocked[0]){
                System.out.println(-1);
                return;
            }

            long ans = Long.MAX_VALUE;
//            System.out.println(Arrays.toString(next));
            boolean flag = false;
            for(int i=k;i>=1;i--){
                long count = 0;
                int cur = n;
//                System.out.println(i);
                while(cur-i>=0){
//                    System.out.println("Start cur: "+cur);
                    if(next[cur-i]>cur){
                        flag = true;
                        break;
                    }else{
                        count+=cost[i];
                        if(cur==next[cur-i]){
                            flag = true;
                            break;
                        }else{
                            cur = next[cur-i];
                        }
                    }
//                    System.out.println("End cur: "+cur);
                }

                if(flag){
                    break;
                }else{
                    if(cur>0){
                        count+=cost[i];
                    }
//                    if(count<ans){
//                        System.out.println("Updating: "+i+" "+count);
//                    }
                    ans = Math.min(ans,count);
                }
            }

            if(ans==Long.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(ans);
            }

        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
}
