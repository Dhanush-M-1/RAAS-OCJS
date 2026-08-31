import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C {


    public static void main(String[] args) {

        MyScanner in = new MyScanner();

        int n = in.nextInt();
        int k = in.nextInt();
        int s = in.nextInt();
        int t = in.nextInt();

        int[][] cars = new int[n][2];
        for (int i = 0; i < n; ++i) {
            cars[i][0] = in.nextInt();
            cars[i][1] = in.nextInt();
        }

        int[] pos = new int[k];
        for (int i = 0; i < k; ++i) {
            pos[i] = in.nextInt();
        }

        Arrays.sort(pos);
        long low = 0;
        long high = 2000_000_010;

        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (f(pos, mid, t, s)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<n;++i){
            if(cars[i][1]>=high){
                minPrice = Math.min(minPrice,cars[i][0]);
            }
        }

        if(minPrice==Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(minPrice);
        }
    }

    private static boolean f(int[] pos, long v, int t, int s) {
        int currX = 0;
        int nextStation = 0;
        int currTime = 0;
        while(currX<s){
            if(nextStation<pos.length && pos[nextStation]<s){
                int distance = pos[nextStation] - currX;
                if(minTime(distance,v)==-1){
                    return false;
                }
                currTime += minTime(distance,v);
                nextStation++;
                currX+=distance;
            }else{
                int distance = s - currX;
                if(minTime(distance,v)==-1){
                    return false;
                }
                currTime += minTime(distance,v);
                currX+=distance;
            }
        }
//        if(currTime<=t){
//            System.out.println(" V "+v);
//        }
        return currTime<=t;
    }

    private static long minTime(int distance, long v) {
        if(v<distance){
            return -1;
        }
        long delta = v-distance;
        if(delta>=distance){
            return distance;
        }
        return delta + (distance - delta) * 2;
    }

    // -----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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
    // --------------------------------------------------------

}