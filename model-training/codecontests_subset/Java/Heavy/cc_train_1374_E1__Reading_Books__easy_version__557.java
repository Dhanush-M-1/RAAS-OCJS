import java.io.*;
import java.util.*;

public class Main {

    private static void solver(InputReader sc, PrintWriter out) throws Exception {
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> alice = new ArrayList<>();
        List<Integer> bob = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        int countalice=0,countbob=0;
        for(int i=0; i<n; i++) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a==1 && b==1){
                com.add(t);
                countalice++; countbob++;
            }
            else if(a==1 && b==0){
                alice.add(t);
                countalice++;
            }
            else if(a==0 && b==1){
                bob.add(t);
                countbob++;
            }
        }
        if(countalice < k || countbob < k){
            out.println(-1); return;
        }
        Collections.sort(alice); Collections.sort(bob); Collections.sort(com);
        long count=0; long keeper=0;
        int x=0,y=0,z=0;
        while(keeper < k){
            while(x < alice.size() && y < bob.size() && z<com.size()) {
                if ((alice.get(x) + bob.get(y)) < com.get(z)) {
                    count += (alice.get(x) + bob.get(y));
                    x++;
                    y++;
                } else {
                    count += com.get(z);
                    z++;
                }
                keeper++;
                if(keeper >= k) break;
            }
          //  out.prinln(count);
            if(keeper >= k) break;
            while(z < com.size()){
                count += com.get(z);
                z++;
                keeper++;
                if(keeper >= k) break;
            }
            if(keeper >= k) break;

            while(x < alice.size() && y < bob.size()){
                count += (alice.get(x) + bob.get(y));
                x++;
                y++; keeper++;
                if(keeper >= k) break;
            }
            if(keeper >= k) break;
        }
        out.print(count);
    }


    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solver(in, out);
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}

class Pair implements Comparable<Pair> {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Pair p) {
        return (this.y - p.y);
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, z;

    public Tuple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int compareTo(Tuple t) {
        if (this.z == t.z) {
            if (this.y == t.y) {
                return t.x - this.x;
            } else return t.y - this.y;
        } else
            return this.z - t.z;
    }


}
