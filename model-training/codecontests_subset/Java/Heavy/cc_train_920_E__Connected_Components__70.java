import java.lang.*;
import java.util.*;
import java.io.*;

public class Main {
    void solve() {
        int n=ni(),m=ni();
        HashSet<Integer> hs[]=new HashSet[n+1];
        for(int i=1;i<=n;i++) hs[i]=new HashSet<>();
        int deg[]=new int[n+1];
        Arrays.fill(deg,n-1);
        while(m-->0){
            int x=ni(),y=ni();
            deg[x]--; deg[y]--;
            hs[x].add(y); hs[y].add(x);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(2*deg[i]>n)list.add(i);
        }
        F=new int[n+1];
        sz=new int[n+1];
        for(int i=1;i<=n;i++) {
            F[i]=i;
            sz[i]=1;
        }

        for(int i=1;i<list.size();i++){
            union(list.get(i-1),list.get(i));
        }
        for(int i=1;i<=n;i++){
            if(2*deg[i]>n) continue;
            for(int j=1;j<=n;j++)if(!hs[i].contains(j)) union(i,j);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=1;i<=n;i++)if(root(i)==i) ans.add(sz[i]);
        Collections.sort(ans);
        pw.println(ans.size());
        for(int u : ans) pw.print(u+" ");
        pw.println("");
    }

    int F[];
    int sz[];
    int root(int a){
        while(F[a]!=a){
            F[a]=F[F[a]];
            a=F[a];
        }
        return a;
    }
    void union(int a,int b){

        int rootA=root(a);
        int rootB=root(b);
        if(rootA==rootB) return;
        if(sz[rootA]>sz[rootB]){
            int tmp=rootA; rootA=rootB; rootB=tmp;
        }
        F[rootA]=rootB;
        sz[rootB]+=sz[rootA];


    }


    long M = (long)1e9+7;
    // END
    PrintWriter pw;
    StringTokenizer st;
    BufferedReader br;

    void run() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        solve();
        pw.flush();
    }
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    String ns() {
        while (st == null || !st.hasMoreElements()) {

            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    String nextLine() throws Exception {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            throw new Exception(e.toString());
        }
        return str;
    }

    int ni() {
        return Integer.parseInt(ns());
    }

    long nl() {
        return Long.parseLong(ns());
    }

    double nd() {
        return Double.parseDouble(ns());
    }
}