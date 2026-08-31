import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Reg {
    static FastScanner fs = new FastScanner();
    static boolean can(Node car, int[] stops, int n, long t){
        double total = 0.0;
        for (int i = 1; i <= n; ++i){
            double dist = 1.0*(stops[i]-stops[i-1]);
            if (dist > car.cap){
                return false;
            }
            if (2*dist <= car.cap){
                total += dist;
                continue;
            }
            total += 3.0*dist-car.cap;
        }
        return total <= (double)t;
    }
    static void solve(){
        int n = fs.nextInt();
        int k = fs.nextInt();
        int s = fs.nextInt();
        long t = fs.nextLong();
        ArrayList<Node> toSort = new ArrayList(n);
        for (int i = 0; i < n; ++i){
            toSort.add(new Node(fs.nextInt(), fs.nextInt()));
        }
        k += 2;
        int[] stops = new int[k];
        stops[0] = 0;
        stops[k-1] = s;
        for (int i = 1; i < k-1; ++i){
            stops[i] = fs.nextInt();
        }
        Arrays.sort(stops);
        Collections.sort(toSort);
        Node[] cars = new Node[n];
        for (int i = 0; i < n; ++i){
            cars[i] = toSort.get(i);
        }
        for (int i = 1; i < n; ++i){
            cars[i].cap = Math.max(cars[i].cap, cars[i-1].cap);
        }
        // now assume that cap:cost ratio is increasing
        int left = 0, right = n-1;
        while (left != right){
            int mid = (left+right)/2;
            if (can(cars[mid], stops, k-1,  t)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        boolean ans = can(cars[left], stops, k-1,  t);
        if (ans) System.out.println(cars[left].cost);
        else System.out.println(-1);
    }
    public static void main(String[] args) {
        solve();
    }







    static class Node implements Comparable<Node>{
        int cost;
        int cap;
        Node(int cost, int cap){
            this.cost = cost;
            this.cap = cap;
        }

        @Override
        public int compareTo(Node o) {
            // sort by price
            if (this.cost < o.cost){
                return -1;
            }
            return 1;
        }
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readIntArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long[] readLongArray(int n){
            long a[] = new long[n];
            for (int i = 0; i < n; ++i){
                a[i] = nextLong();
            }
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
    }
}