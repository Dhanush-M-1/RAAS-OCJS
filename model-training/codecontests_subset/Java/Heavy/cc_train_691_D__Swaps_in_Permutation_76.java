import java.io.*;
import java.lang.*;
import java.util.*;

// Sachin_2961 submission //
public class CodeforcesA {


    public int getParent(int[]parent,int x){
        if(parent[x] != x)
            parent[x] = getParent(parent,parent[x]);

        return parent[x];
    }
    public void join(int[]parent,int[]rank,int u,int v){
        u = getParent(parent,u); v = getParent(parent,v);
        if(u == v)
            return;
        if( rank[u] > rank[v]){
            parent[v] = u;
        }else if( rank[u] < rank[v]){
           parent[u] = v;
        }else{
            rank[u]++;
            parent[v] = u;
        }
    }
    public void sort(int[]pp,int[]qq,Pair[]pairs,int l,int k){
        for(int i=0;i<k;i++){
            int j = pairs[l+i].i;
            qq[i] = pp[j];
        }
        Arrays.sort(qq,0,k);
        for(int i=0;i<k;i++){
            int j = pairs[l+i].i;
            pp[j] = qq[k-i-1];
        }
    }
    public void solve() {
        int[]ar = new int[(int)1e6+1];
        int[]parent = new int[(int)1e6+1];
        int[]rank = new int[(int)1e6+1];
        int[] qq = new int[(int)1e6+1];
        int n = fs.nInt(), m = fs.nInt();
        for(int i=0;i<n;i++)
            ar[i] = fs.nInt();
        for(int i=0;i<n;i++)
            parent[i] = i;

        for(int i=0;i<m;i++){
            int u = fs.nInt()-1,v=fs.nInt()-1;
            join(parent,rank,u,v);
        }
        Pair[]pairs = new Pair[n];
        for(int i=0;i<n;i++){
            int r = getParent(parent,i);
            pairs[i] = new Pair(r,i);
        }
        Arrays.sort(pairs,(p,q) -> p.r != q.r ?p.r-q.r:p.i-q.i);
        int l = 0, k = 1;
        for(int i=1;i<=n;i++){
            if( i < n && pairs[i].r == pairs[i-1].r){
                k++;
            }else{
                if( k > 1)
                    sort(ar,qq,pairs,l,k);
                l = i;
                k = 1;
            }
        }
        for(int i=0;i<n;i++){
            out.print(ar[i]+" ");
        }
    }
    class Pair{
        int r,i;
        Pair(int r,int i){
            this.r = r;
            this.i = i;
        }
    }
    static boolean multipleTestCase = false; static FastScanner fs; static PrintWriter out;
    public void run(){
        fs = new FastScanner();
        out = new PrintWriter(System.out);
        int tc = (multipleTestCase)?fs.nInt():1;
        while (tc-->0)solve();
        out.flush();
        out.close();
    }
    public static void main(String[]args){
        try{
            new CodeforcesA().run();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String n() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
        String Line()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
        int nInt() {return Integer.parseInt(n()); }
        long nLong() {return Long.parseLong(n());}
        int[]aI(int n){
            int[]ar = new int[n];
            for(int i=0;i<n;i++)
                ar[i] = nInt();
            return ar;
        }
    }
}