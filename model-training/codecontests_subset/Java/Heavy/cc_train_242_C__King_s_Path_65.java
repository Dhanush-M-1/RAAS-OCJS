import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class P_242C {
    static final FS sc = new FS();
    static final PrintWriter pw = new PrintWriter(System.out);
    static class Pair implements Comparable<Pair>{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.x==o.x) return this.y-o.y;
            return this.x-o.x;
        }
    }
    static boolean isValid(int x, int y){
        return x>=0 && x<1e9 && y>=0 && y<1e9;
    }
    public static void main(String[] args) {
        int x0 = sc.nextInt();
        int y0 = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int n = sc.nextInt();
        int[] dx = {1,1,0,-1,-1,-1,0,1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};
        HashMap<Integer, HashSet<Integer>> cells = new HashMap<>();
        for(int i=0; i<n; i++){
            int r = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(!cells.containsKey(r))
                cells.put(r, new HashSet<>());
            for(int j=a; j<=b; j++){
                cells.get(r).add(j);
            }
        }
        TreeMap<Pair,Integer> d = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x0, y0));
        d.put(new Pair(x0, y0), 0);
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i=0; i<8; i++){
                int x = p.x+dx[i];
                int y = p.y+dy[i];
                if (isValid(x, y) && cells.containsKey(x) && cells.get(x).contains(y) && !d.containsKey(new Pair(x, y))) {
                    q.add(new Pair(x,y));
                    d.put(new Pair(x,y), d.get(p)+1);
                }
            }
        }
        System.out.println(d.containsKey(new Pair(x1,y1))?d.get(new Pair(x1,y1)):-1);
    }

    static class FS {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception ignored) {
                }
            }
            return st.nextToken();
        }

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
