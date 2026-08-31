//package math_codet;

import java.io.*;
import java.util.*;

public class lets_do {
    FastReader in;
    PrintWriter out;
    Helper_class h;
    final long mod = 1000000007;
    int MAXN = 200005;
    int lgN = 20;
    long INF = (long)1e15;
    public static void main(String[] args) throws java.lang.Exception{
        new lets_do().run();
    }
    void run() throws Exception{
        in=new FastReader();
        out = new PrintWriter(System.out);
        h = new Helper_class();
        int t = 1;
        solve(t);
        out.flush();
        out.close();
    }
    void solve(int t){
        int n = h.ni();
        String st = h.n();
        int i = 0;
        int mx = st.charAt(0) - 'a';
        int ind = 0;
        for(i = 1; i < n; i++){
            if(st.charAt(i) - 'a' >= mx){
                ind = i;
                mx = st.charAt(i) - 'a';
            }
            else{
                h.pn("YES");
                h.pn(ind + 1+" "+(i + 1));
                return;
            }
        }
        h.pn("NO");
    }
    static final Comparator<Pair> com=new Comparator<Pair>(){
        public int compare(Pair a, Pair b){
            if(Integer.compare(a.x, b.x) != 0)
                return Integer.compare(a.x, b.x);
            else if(Integer.compare(a.y, b.y) != 0)
                return Integer.compare(a.y, b.y);
            else
                return Integer.compare(a.id, b.id);
        }
    };
    class Pair{
        int x;
        int y;
        int id;
        Pair(int p, int q, int ind){
            x = p;
            y = q;
            id = ind;
        }
    }
    class Edge{
        int u , v;
        long wt;
        Edge(int a, int b, long p){
            u = a;
            v = b;
            wt = p;
        }
        int other(int x) {
            return u ^ v ^ x;
        }
    }
    class Helper_class{
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

        long mul(long a,long b){
            if(a>=mod)a%=mod;
            if(b>=mod)b%=mod;
            a*=b;
            if(a>=mod)a%=mod;
            return a;
        }
        long modPow(long a, long p){
            long o = 1;
            while(p>0){
                if((p&1)==1)o = mul(o,a);
                a = mul(a,a);
                p>>=1;
            }
            return o;
        }
        long add(long a, long b){
            if(a>=mod)a%=mod;
            if(b>=mod)b%=mod;
            if(b<0)b+=mod;
            a+=b;
            if(a>=mod)a-=mod;
            return a;
        }
    }

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