import java.util.*;
import java.io.*;
import java.text.*;

public class Main{
    final long mod = (long)1e9+7, IINF = (long)1e19;
    final int MAX = (int)3e5+1, MX = (int)1e7+1, INF = (int)1e9;
    DecimalFormat df = new DecimalFormat("0.0000000000");
    final double EPS = 1e-8;
    FastReader in;
    PrintWriter out;
    boolean multipleTC = false;

    public static void main(String[] args) throws Exception{
        new Thread(null, new Runnable(){public void run(){try{new Main().run();}catch(Exception e){}}}, "1", 1 << 28).start();
    };
    void run() throws Exception{
        in = new FastReader();
        out = new PrintWriter(System.out);
        for(int i = 1, t = (multipleTC)?ni():1; i<=t; i++)solve(i);
        out.flush();    
        out.close();
    }

    void solve(int TC) throws Exception{
        int n = ni(), m = ni(), k = ni();
        boolean[] b = new boolean[n];
        for(int i = 0; i< m; i++)b[ni()] = true;
        int[] p = new int[n];
        Arrays.fill(p, -INF);
        int pr = -INF;
        for(int i = 0; i< n; i++){
            if(!b[i])pr = i;
            p[i] = pr;
        }
//        long[] cost = new long[k+1];
        
        long ans = IINF;
        for(int i = 1; i<= k; i++){
            long c = nl(), cur = 0;
            boolean v = true;
            for(int j = 0; j< n && v; j+=i){
                if(b[j]){
                    if(j-p[j]>=i){
                        v = false;
                        break;
                    }else j = p[j];
                }
                cur+=c;
            }
            if(v)ans = Math.min(ans, cur);
        }
        if(ans==IINF)ans = -1;
        pn(ans);
    }
    
    int find(int[] set, int i){
        if(set[i]!=i)set[i] = find(set, set[i]);
        return set[i];
    }
    void union(int[] set, int i,int j){
        set[i] = j;
    }
    
    void addEdge(boolean[][] grid, int i, int j){
        grid[i][j] = grid[j][i] = true;
    }
    
    int[] reverse(int[] a){
        int[] o = new int[a.length];
        for(int i = 0; i< a.length; i++)o[i] = a[a.length-i-1];
        return o;   
    }

    int[] sort(int[] a){
        if(a.length==1)return a;
        int mid = a.length/2;
        int[] b = sort(Arrays.copyOfRange(a,0,mid)), c = sort(Arrays.copyOfRange(a,mid,a.length));
        for(int i = 0, j = 0, k = 0; i< a.length; i++){
            if(j<b.length && k<c.length){
                if(b[j]<c[k])a[i] = b[j++];
                else a[i] = c[k++];
            }else if(j<b.length)a[i] = b[j++];
            else a[i] = c[k++];
        }
        return a;
    }

    long[] sort(long[] a){
        if(a.length==1)return a;
        int mid = a.length/2;
        long[] b = sort(Arrays.copyOfRange(a,0,mid)), c = sort(Arrays.copyOfRange(a,mid,a.length));
        for(int i = 0, j = 0, k = 0; i< a.length; i++){
            if(j<b.length && k<c.length){
                if(b[j]<c[k])a[i] = b[j++];
                else a[i] = c[k++];
            }else if(j<b.length)a[i] = b[j++];
            else a[i] = c[k++];
        }
        return a;
    }

    int[] ia(int ind,int n){
        int[] out = new int[ind+n];
        for(int i = 0; i< n; i++)out[ind+i] = ni();
        return out;
    }

    long[] la(int ind, int n){
        long[] out = new long[ind+n];
        for(int i = 0; i< n; i++)out[ind+i] = nl();
        return out;
    }

    double[] da(int ind, int n){
        double[] out = new double[ind+n];
        for(int i = 0; i< n; i++)out[ind+i] = nd();
        return out;
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