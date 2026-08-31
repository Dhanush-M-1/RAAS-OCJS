import java.io.*;
import java.lang.reflect.Field;
import java.util.*;


public class Main {

    long MOD = (long) (1e9 + 7);
    HashSet<Integer>[] graph;
    static int[] deg;
    int rem;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        new Main();
    }

    Main() throws IOException {
        solve();
    }

    void solve() throws IOException {
        int n = Reader.nextInt();
        int m = Reader.nextInt();
        int k = Reader.nextInt();
        int[] X = new int[m];
        int[] Y = new int[m];
        boolean[] del = new boolean[n];
        Node[] arr = new Node[n];
        deg = new int[n];
        graph = new HashSet[n];
        for(int i = 0; i < n; i++){graph[i] = new HashSet<>();}

        for(int i = 0; i < m; i++){
            int x = Reader.nextInt()-1;
            int y = Reader.nextInt()-1;
            X[i] = x;
            Y[i] = y;
            deg[x]++;deg[y]++;
            graph[x].add(y);
            graph[y].add(x);
        }
        List<Integer> gone = new ArrayList<>();

        for(int i = 0; i < n; i++){
            arr[i] = new Node(i,deg[i]);
            if(deg[i] < k){del[i] = true; gone.add(i);}
        }

        while(gone.size() > 0){
            int v = gone.remove(gone.size() - 1);
            del[v] = true;
            for(int ele : graph[v]){
                if(!del[ele]) {
                    deg[ele]--;
                    if (deg[ele] < k) {
                        gone.add(ele);
                        del[ele] = true;
                    }
                }
            }
        }
        rem = 0;
        for(int i = 0; i <n; i++){if(!del[i])rem++;}
        int[] ans = new int[m+1];
        for(int i = m-1; i >= 0; i--){
            ans[i] = rem;
            if(del[X[i]] && del[Y[i]]){ continue; }
            if(!del[Y[i]]) deg[X[i]]--;
            if(!del[X[i]]) deg[Y[i]]--;
            graph[X[i]].remove((Integer) Y[i]);
            graph[Y[i]].remove((Integer) X[i]);
            if(!del[X[i]]){
                if(deg[X[i]] < k){
                    remove(X[i],k,del);
                }
            }
            if(!del[Y[i]]){
                if(deg[Y[i]] < k){
                    remove(Y[i],k,del);
                }
            }
        }
        for(int i = 0; i < m; i++) System.out.println(ans[i]);
    }

    void remove(int u, int k, boolean[] del){
        del[u] = true;
        rem--;
        for(int ele : graph[u]){
            if(del[ele]) continue;
            deg[ele]--;
            if(deg[ele] < k){
                remove(ele, k, del);
            }
        }
    }

    class Node{
        int ind;
        int deg;
        Node(int i, int d){
            ind = i;
            deg = d;
        }
    }

}




class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
    /** call this method to initialize reader for InputStream */

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");

    }

    static String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {

                tokenizer = new StringTokenizer(reader.readLine());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    static String next() throws IOException {

        while ( ! tokenizer.hasMoreTokens() ) {

            tokenizer = new StringTokenizer(

                    reader.readLine() );

        }
        return tokenizer.nextToken();

    }

    static int nextInt() throws IOException {

        return Integer.parseInt( next() );

    }

    static double nextDouble() throws IOException {

        return Double.parseDouble( next() );

    }

    static long nextLong() {

        return Long.parseLong(nextToken());
    }
}