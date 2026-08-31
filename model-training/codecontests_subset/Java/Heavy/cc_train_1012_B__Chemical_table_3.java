import java.util.*;
import java.io.*; 
import java.text.*;

public class Main{
    long mod = (int)1e9+7, IINF = (long)1e17;
    final int MAX = (int)1e3+1, INF = (int)1e9, root = 3;
    DecimalFormat df = new DecimalFormat("0.00000000");
    double PI = 3.141592653589793238462643383279502884197169399375105820974944;
    static boolean multipleTC = false, memory = false;
    FastReader in;PrintWriter out;
    public static void main(String[] args) throws Exception{
        if(memory)new Thread(null, new Runnable() {public void run(){try{new Main().run();}catch(Exception e){e.printStackTrace();}}}, "1", 1 << 28).start();
        else new Main().run();
    }

    void run() throws Exception{
        in = new FastReader();
        out = new PrintWriter(System.out);
        for(int i = 1, T= (multipleTC)?ni():1; i<= T; i++)solve(i);
        out.flush();
        out.close();
    }
    
    void solve(int TC) throws Exception{
        int n = ni(), m = ni(), q = ni();
        int[] cnt = new int[n+m];
        int[][] edge = new int[q][2];
        for(int i = 0; i< q; i++){
            edge[i] = new int[]{ni()-1, ni()-1+n};
            cnt[edge[i][0]]++;cnt[edge[i][1]]++;
        }
        int[][] g = new int[n+m][];
        for(int i = 0; i< n+m; i++)g[i] = new int[cnt[i]];
        for(int i = 0; i< q; i++){
            g[edge[i][0]][--cnt[edge[i][0]]] = edge[i][1];
            g[edge[i][1]][--cnt[edge[i][1]]] = edge[i][0];
        }
        int ans = 0;
        int[] st = new int[n+m];int p = -1;
        boolean[] vis = new boolean[n+m];
        for(int i = 0; i< n+m; i++){
            if(vis[i])continue;
            ans++;
            st[++p] = i;
            vis[i] = true;
            while(p>=0){
                int x = st[p--];
                for(int v:g[x])if(!vis[v]){
                    st[++p] = v;
                    vis[v] = true;
                }
            }
        }
        pn(ans-1);
    }
    
    long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
    int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
    int bitcount(long n){return (n==0)?0:(1+bitcount(n&(n-1)));}
    void p(Object o){out.print(o);}
    void pn(Object o){out.println(o);}
    void pni(Object o){out.println(o);out.flush();}
    String n(){return in.next();}
    String nln(){return in.nextLine();}
    int ni(){return Integer.parseInt(in.next());}
    long nl(){return Long.parseLong(in.next());}
    double nd(){return Double.parseDouble(in.next());}

    class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception{
            br = new BufferedReader(new FileReader(s));
        }

        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String str = "";
            try{    
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }   
            return str;
        }
    }
}     