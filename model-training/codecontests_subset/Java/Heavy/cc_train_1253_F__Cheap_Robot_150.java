import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        InputStream  inputstream;
        OutputStream outputstream;
        inputstream = System.in;
        outputstream = System.out;
        InputReader in = new InputReader(inputstream);
        PrintWriter out = new PrintWriter(outputstream);
        Task solver = new Task();
        solver.solve(in,out);
        out.close();
    }

    static class Task{

        final static long inf = (long)1e18;
        final static int lg = 18;
        int n,m,k,q;
        ArrayList <Vertices> gr = new ArrayList <Vertices> ();
        ArrayList <Vertices> tree = new ArrayList <Vertices> ();
        ArrayList <Triple> edges = new ArrayList <Triple>();
        TreeSet <Tuples> heap = new TreeSet <Tuples> (new CompareValue());
        long[] dist;
        int[] f;
        int[] h;
        int[][] dp;
        long[][] maxValue;

        public void solve(InputReader in,PrintWriter out){
            n = in.nextInt();
            m = in.nextInt();
            k = in.nextInt();
            q = in.nextInt();
            for(int i = 0;i < n;++i){
                gr.add(new Vertices());
            }
            for(int i = 0;i < m;++i){
                int u = in.nextInt() - 1;
                int v = in.nextInt() - 1;
                int w = in.nextInt();
                edges.add(new Triple(w,u,v));
                gr.get(u).adj.add(new Tuples(w,v));
                gr.get(v).adj.add(new Tuples(w,u));
            }
            Dijkstra();
            for(int i = 0;i < k;++i){
                tree.add(new Vertices());
            }
            h = new int[k];
            dp = new int[k][lg + 1];
            maxValue = new long[k][lg + 1];
            Arrays.fill(h,0);

            for(int i = 0;i < edges.size();++i){
                Triple cur = edges.get(i);
                long w = cur.first;
                int u = (int)cur.second.first;
                int v = cur.second.second;
                if(f[u] != f[v]){
                    edges.get(i).first = dist[u] + w + dist[v];
                }
            }
            Collections.sort(edges,new CompareTriple());

            Dsu dsu = new Dsu(n);

            for(int i = 0;i < edges.size();++i){
                Triple cur = edges.get(i);
                long w = cur.first;
                int u = (int)cur.second.first;
                int v = cur.second.second;
                u = f[u];
                v = f[v];
                if(u != v && !dsu.join(u,v)){
                    tree.get(u).adj.add(new Tuples(w,v));
                    tree.get(v).adj.add(new Tuples(w,u));
                }
            }

            dfs(0,0);
            for(int j = 1;j <= lg;++j){
                for(int i = 0;i < k;++i){
                    dp[i][j] = dp[dp[i][j - 1]][j - 1];
                    maxValue[i][j] = Math.max(maxValue[i][j - 1],maxValue[dp[i][j - 1]][j - 1]);
                }
            }
            for(int queries = 0;queries < q;++queries){
                int a,b;
                a = in.nextInt() - 1;
                b = in.nextInt() - 1;
                long ans = lift(a,b);
                out.print(ans + "\n");
            }
        }

        long lift(int a,int b){
            long ret = -1;
            if(h[a] < h[b]){
                int tmp = a;
                a = b;
                b = tmp;
            }
            for(int j = lg;j >= 0;--j){
                if(h[dp[a][j]] >= h[b]){
                    ret = Math.max(ret,maxValue[a][j]);
                    a = dp[a][j];
                }
            }
            if(a == b){
                return ret;
            }
            for(int j = lg;j >= 0;--j){
                if(dp[a][j] != dp[b][j]){
                    ret = Math.max(ret,maxValue[a][j]);
                    ret = Math.max(ret,maxValue[b][j]);
                    a = dp[a][j];
                    b = dp[b][j];
                }
            }
            return Math.max(ret,Math.max(maxValue[a][0],maxValue[b][0]));
        }

        public void dfs(int u,int par){
            dp[u][0] = par;
            for(Tuples p : tree.get(u).adj){
                int v = p.second;
                long w = p.first;
                if(v == par)continue;
                maxValue[v][0] = w;
                h[v] = h[u] + 1;
                dfs(v,u);
            }
        }

        public void Dijkstra(){
            dist = new long[n];
            f = new int[n];
            Arrays.fill(dist,inf);
            Arrays.fill(f,0);
            for(int i = 0;i < k;++i){
                dist[i] = 0;
                heap.add(new Tuples(dist[i],i));
                f[i] = i;
            }
            while(!heap.isEmpty()){
                Tuples top = heap.pollFirst();
                int u = top.second;
                for(Tuples p : gr.get(u).adj){
                    int v = p.second;
                    long w = p.first;
                    if(dist[v] > dist[u] +  w){
                        if(heap.contains(new Tuples(dist[v],v))){
                            heap.remove(new Tuples(dist[v],v));
                        }
                        dist[v] = dist[u] + w;
                        f[v] = f[u];
                        heap.add(new Tuples(dist[v],v));
                    }
                }
            }
        }

        public class Dsu{
            int[] par;
            public Dsu(int _size){
                par = new int[_size + 1];
                for(int i = 0;i < _size;++i){
                    par[i] = i;
                }
            }

            public int findp(int u){
                if(u == par[u]){
                    return u;
                } else {
                    return par[u] = findp(par[u]);
                }
            }

            public boolean join(int u,int v){
                u = findp(u);
                v = findp(v);
                if(u == v){
                    return true;
                }
                par[u] = v;
                return false;
            }
        }

        public class Tuples {
            long first;
            int second;
            public Tuples(long first,int second){
                this.first = first;
                this.second = second;
            }
        }

        public class Triple {
            long first;
            Tuples second;
            public Triple(long first,int u,int v){
                this.first = first;
                this.second = new Tuples(u,v);
            }
        }

        public class Vertices {
            ArrayList <Tuples> adj;
            public Vertices(){
                adj = new ArrayList <Tuples> ();
            }
        }

        public class CompareValue implements Comparator <Tuples> {
            public int compare(Tuples x,Tuples y){
                int z = Long.compare(x.first,y.first);
                if(z == 0){
                    return Integer.compare(x.second,y.second);
                }
                return z;
            }
        }

        public class CompareTriple implements Comparator <Triple> {
            public int compare(Triple x,Triple y){
                int z = Long.compare(x.first,y.first);
                if(z == 0){
                    int t = Integer.compare((int)x.second.first,(int)y.second.first);
                    if(t == 0){
                        int v = Integer.compare((int)x.second.second,(int)y.second.second);
                        return v;
                    } else {
                        return t;
                    }
                }
                return z;
            }
        }
    }

    static class InputReader{
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream){
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next(){
            while(tokenizer == null || !tokenizer.hasMoreTokens()){
                try{
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }

        public long nextLong(){
            return Long.parseLong(next());
        }

        public  double nextDouble(){
            return Double.parseDouble(next());
        }

        public String nextLine(){
            String ret_str = "";
            try {
                ret_str = reader.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            return ret_str;
        }
    }
}
