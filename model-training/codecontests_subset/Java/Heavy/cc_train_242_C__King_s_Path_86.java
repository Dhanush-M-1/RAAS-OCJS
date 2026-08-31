import java.io.*;
import java.util.*;
import java.math.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
 
public class Main {
      
    int mod = 1000000007;

    int x0, y0, x1, y1;
    Set<Pair<Integer, Integer>> s = new HashSet<>();
    public void solve() throws IOException{

      int[] dx = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
      int[] dy = new int[]{1, -1, 0, 1, -1, 0, 1, -1};

      x0 = in.nextInt();
      y0 = in.nextInt();
      x1 = in.nextInt();
      y1 = in.nextInt();

      int m = in.nextInt();

      for(int i = 1; i <= m; i++){

         int r = in.nextInt();
         int a = in.nextInt();
         int b = in.nextInt();

         for(int j = a; j <= b; j++){
            s.add(new Pair<Integer, Integer>(r, j));
         }

      }


      Set<Pair<Integer, Integer>> visited = new HashSet<>();
      Queue<Tuple> q = new LinkedList<>();
      q.add(new Tuple(x0, y0, 0));
      
      while(!q.isEmpty()){

         Tuple t = q.poll();

         int x = t.x, y = t.y, d = t.z;
         Pair<Integer, Integer> p = new Pair<Integer, Integer>(x, y);
         if(visited.contains(p)){
            continue;
         }
         if(x == x1 && y  == y1){
            out.println(d);
            return;
         }
         visited.add(p);

         for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inBound(nx, ny) && s.contains(new Pair<Integer, Integer>(nx, ny))){
               q.add(new Tuple(nx, ny, d + 1));
            }
         }

      }

      out.println(-1);
      return;
    }

    public boolean inBound(int x, int y){
      return x >= 1 && x <= 1000000000 && y >= 1 && y <= 1000000000;
    }


    FastScanner in;
    PrintWriter out;
    
    static class FastScanner {
 
        BufferedReader br;
        StringTokenizer st;
 
        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
            st = null;
        }
 
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
 
        String nextLine() throws IOException {
            if (st == null || !st.hasMoreTokens())
                return br.readLine();
            StringBuilder result = new StringBuilder(st.nextToken());
            while (st.hasMoreTokens()) {
                result.append(" ");
                result.append(st.nextToken());
            }
            return result.toString();
        }
 
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
 
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
 
        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
 
    }
 
    void run() throws IOException {
        in = new FastScanner(System.in);
        out = new PrintWriter(System.out, false);
        solve();
        out.close();
    }
 
    public static void main(String[] args) throws IOException{
        new Main().run();
    }
 
    public void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            out.print(arr[i] + " ");
        }
        out.println();
    }
 
    public long gcd(long a, long b){
        if(a == 0) return b;
        return gcd(b % a, a);
    }

    public boolean isPrime(long num){

        if(num == 0 || num == 1){
            return false;
        }

        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }

    public class Pair<A, B>{
        public A x; 
        public B y;

        Pair(A x, B y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            if (!x.equals(pair.x)) return false;
            return y.equals(pair.y);
        }

        @Override
        public int hashCode() {
            int result = x.hashCode();
            result = 31 * result + y.hashCode();
            return result;
        }

    }

    class Tuple{
        int x; int y; int z;
        Tuple(int ix, int iy, int iz){
            x = ix;
            y = iy;
            z = iz;
        }
    }
}
