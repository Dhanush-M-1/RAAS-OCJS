import java.util.*;
import java.io.*; 
import java.text.*;
//Solution Credits: Taranpreet Singh
public class Main{
    //SOLUTION BEGIN
    void solve(int TC) throws Exception{
        int n = ni(), m = ni(), k = ni();
        TreeSet<Long> set = new TreeSet<>();
        HashSet<Integer>[] g = new HashSet[n];
        for(int i = 0; i< n; i++)g[i] = new HashSet<>();
        int[][] edge = new int[m][2];
        for(int i = 0; i< m; i++){
            edge[i] = new int[]{ni()-1, ni()-1};
            g[edge[i][0]].add(edge[i][1]);
            g[edge[i][1]].add(edge[i][0]);
        }
        for(int i = 0; i< n; i++)set.add(g[i].size()*(long)n+i);
//        while(!set.isEmpty() && set.first()/n<k){
//            long x = set.first();
//            int v=  (int)(x/n);
//            for(int w:g[v]){
//                set.remove(g[w].size()*(long)n+w);
//                g[w].remove(v);
//                set.remove(g[w].size()*(long)n+w);
//            }
//            g[v].clear();
//        }
        int[] ans = new int[m];
        for(int i = m-1; i>= 0; i--){
            while(!set.isEmpty() && set.first()/n<k){
                long x = set.pollFirst();
                int v = (int)(x%n);
                for(int w:g[v]){
                    set.remove(g[w].size()*(long)n+w);
                    g[w].remove(v);
                    set.add(g[w].size()*(long)n+w);
                }
                g[v].clear();
            }
            ans[i] = set.size();
            if(g[edge[i][0]].contains(edge[i][1])){
                set.remove(g[edge[i][0]].size()*(long)n+edge[i][0]);
                g[edge[i][0]].remove(edge[i][1]);
                set.add(g[edge[i][0]].size()*(long)n+edge[i][0]);
            }
            if(g[edge[i][1]].contains(edge[i][0])){
                set.remove(g[edge[i][1]].size()*(long)n+edge[i][1]);
                g[edge[i][1]].remove(edge[i][0]);
                set.add(g[edge[i][1]].size()*(long)n+edge[i][1]);
            }
        }
        for(int i:ans)pn(i);
    }
    //SOLUTION ENDS
    long mod = (int)1e9+7, IINF = (long)1e19;
    final int MAX = (int)1e5+1, INF = (int)1e9, root = 3;
    DecimalFormat df = new DecimalFormat("0.00000000");
    double PI = 3.141592653589793238462643383279502884197169399375105820974944, eps = 1e-8;
    static boolean multipleTC = false, memory = true;
    FastReader in;PrintWriter out;
    void run() throws Exception{
        in = new FastReader();
        out = new PrintWriter(System.out);
        int T = (multipleTC)?ni():1;
//        long ct = System.currentTimeMillis();
        //Solution Credits: Taranpreet Singh
        for(int i = 1; i<= T; i++)solve(i);
//        pn(System.currentTimeMillis()-ct);
        out.flush();
        out.close();
    }
    public static void main(String[] args) throws Exception{
        if(memory)new Thread(null, new Runnable() {public void run(){try{new Main().run();}catch(Exception e){e.printStackTrace();}}}, "1", 1 << 28).start();
        else new Main().run();
    }
    long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
    int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
    int bit(long n){return (n==0)?0:(1+bit(n&(n-1)));}
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