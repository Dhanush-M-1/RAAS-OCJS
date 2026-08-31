import java.util.*;
import java.math.*;
import java.io.*;

public class Solution {

    static class Solver {
        FastScanner scanner;
        PrintWriter out;
        List<Integer> result;

        Solver() {
            scanner = new FastScanner(System.in);
            out = new PrintWriter(System.out);
            result = new LinkedList<Integer>();
        }

        public void solve() {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int s = scanner.nextInt();
            int t = scanner.nextInt();

            Car[] cars = new Car[n];
            for(int i = 0; i < n; i++) {
                cars[i] = new Car(scanner.nextInt(), scanner.nextInt());
            }

            int[] p = new int[k];
            for(int i = 0; i < k; i++) {
                p[i] = scanner.nextInt();
            }

            Arrays.sort(cars);
            Arrays.sort(p);
            
            int low = 0; int high = n-1;
            int minC = -1;
            while(low <= high) {
                int m = (low+high)/2;
                if(canReach(cars[m], p, s, t)) {
                    minC = m;
                    high = m-1;
                } else {
                    low = m+1;
                }
            }

            if(minC == -1) {
                out.println(-1);
                out.flush();
                return;
            }

            int minCost = cars[minC].c;
            for(int i = minC+1; i < n; i++) {
                minCost = Math.min(minCost, cars[i].c);
            }
            out.println(minCost == Integer.MAX_VALUE ? -1 : minCost);

            out.flush();
        }

        public boolean canReach(Car car, int[] k, int s, int t) {
            int time = 0;
            for(int i = 0; i <= k.length; i++) {
                //int d = i < k.length ? (i == 0 ? k[i] : (k[i] - k[i-1])) : (s - k[i-1]);
                int d = (i < k.length ? k[i] : s) - (i > 0 ? k[i-1] : 0);
                int modeA = Math.min(d, car.v - d);
                int modeS = d - modeA;

                if(modeA < 0) 
                    return false;
                time += modeA + (modeS*2);
                //System.out.println(car.c + ", " + d + ", " + time);
            }

            if(time > t)
                return false;
            return true;
        }

        public 

        class Car implements Comparable<Car>{
            int c;
            int v;
            
            public Car(int c, int v) {
                this.c = c;
                this.v = v;
            }

            public int compareTo(Car anotherCar) {
                return this.v - anotherCar.v;
            }
        }

    }

    public static void main(String[] args) throws IOException{
        (new Solver()).solve();

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        boolean hasNextToken() {
            if(st == null) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    
                }
            }
            return st.hasMoreTokens();
        } 

        String next() {
            while(st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        String nextLine() throws IOException{
            return br.readLine();
        }

        byte nextByte() {
            return Byte.parseByte(next());
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

    }

}


