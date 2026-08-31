import java.util.*;
import java.io.*;
import java.text.*;
//Solution Credits: Taranpreet Singh
public class Main{
    //SOLUTION BEGIN
    void pre() throws Exception{}
    void solve(int TC) throws Exception{
        int n = ni();
        boolean[][] g = new boolean[1+n][1+n];
        for(int i = 1; i<= n; i++){
            String s = n();
            for(int j = 0; j< n/4; j++){
                int x = get(s.charAt(j));
                for(int k = 0; k< 4; k++){
                    g[i][j*4+4-k] =((x>>k)&1)==1;
                }
            }
        }
        int[][] sum = new int[1+n][1+n];
        for(int i = 1; i<= n; i++)
            for(int j = 1; j<= n; j++)
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+(g[i][j]?1:0);
        int ans = 1;
        for(int cur = 1; cur <= n; cur++){
            if(n%cur!=0)continue;
            boolean f = true;
            int sz = n/cur;
            for(int i = 0; i< cur && f; i++)
                for(int j = 0; j< cur && f; j++){
                    int sm = sum[(i+1)*sz][(j+1)*sz]+sum[i*sz][j*sz]-sum[(i+1)*sz][j*sz]-sum[i*sz][(j+1)*sz];
                    if(sm!= 0 && sm!= sz*sz)f = false;
                }
            if(f){
                ans = sz;
                break;
            }
        }
        pn(ans);
    }
    int get(char c){
        if(c<='9')return c-'0';
        return c-'A'+10;
    }
    //SOLUTION END
    void hold(boolean b)throws Exception{if(!b)throw new Exception("Hold right there, Sparky!");}
    long mod = (long)1e9+7, IINF = (long)1e10;
    final int INF = (int)1e9, MX = (int)1e4+1;
    DecimalFormat df = new DecimalFormat("0.000000000000000");
    double PI = 3.1415926535897932384626433832792884197169399375105820974944, eps = 1e-8;
    static boolean multipleTC = false, memory = false;
    FastReader in;PrintWriter out;
    void run() throws Exception{
        in = new FastReader();
        out = new PrintWriter(System.out);
        int T = (multipleTC)?ni():1;
        //Solution Credits: Taranpreet Singh
        pre();for(int t = 1; t<= T; t++)solve(t);
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
    String n()throws Exception{return in.next();}
    String nln()throws Exception{return in.nextLine();}
    int ni()throws Exception{return Integer.parseInt(in.next());}
    long nl()throws Exception{return Long.parseLong(in.next());}
    double nd()throws Exception{return Double.parseDouble(in.next());}

    class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception{
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception{
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        String nextLine() throws Exception{
            String str = "";
            try{   
                str = br.readLine();
            }catch (IOException e){
                throw new Exception(e.toString());
            }  
            return str;
        }
    }
}     