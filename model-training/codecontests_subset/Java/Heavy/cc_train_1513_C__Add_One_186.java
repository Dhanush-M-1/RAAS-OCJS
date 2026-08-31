import java.util.*;import java.io.*;import java.math.*;
public class CF1513C
{
    static final Random random=new Random();
    static boolean memory = true;
    
    static void ruffleSort(int[] a) {
        int n = a.length; 
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i : a)
            lst.add(i);
        Collections.sort(lst);
        for(int i = 0; i < n; i++)
            a[i] = lst.get(i);
    }

    static void ruffleSort(long[] a) {
        int n = a.length; 
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n);
            long temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        ArrayList<Long> lst = new ArrayList<>();
        for(long i : a)
            lst.add(i);
        Collections.sort(lst);
        for(int i = 0; i < n; i++)
            a[i] = lst.get(i);
    }

    static long[][] dp;
    static long mod = (int)1e9+7;

    static void precompute(int max){
        dp = new long[max][10];
        for(int i = 0; i < 10; i++)
            dp[0][i] = 1;
        for(int i = 1; i < max; i++){
            for(int j = 0; j < 9; j++)
                dp[i][j] =  dp[i-1][j+1];
            dp[i][9] = (dp[i-1][1] + dp[i-1][0])%mod;
        }
    }


    public static void process()throws IOException
    {
        int n = ni(), m = ni();
        long ans = 0;
        char[] ch = String.valueOf(n).toCharArray();
        for(char c : ch)
            ans = (ans + dp[m][c-'0'])%mod;
        pn(ans);
    }
   
    static AnotherReader sc;
    static PrintWriter out;

    public static void main(String[] args) throws Exception{
        if(memory)new Thread(null, new Runnable() {public void run(){try{new CF1513C().run();}catch(Exception e){e.printStackTrace();System.exit(1);}}}, "1", 1 << 28).start();
        else new CF1513C().run();
    }

    void run()throws Exception
    {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        if(oj){sc=new AnotherReader();out=new PrintWriter(System.out);}
        else{sc=new AnotherReader(100);out=new PrintWriter("output.txt");}
        long s = System.currentTimeMillis();
        int t=1;
        t=ni();
        precompute(200001);
        //int k = t;
        while(t-->0) {/*p("Case #"+ (k-t) + ": ")*/;process();}
        out.flush();
        System.err.println(System.currentTimeMillis()-s+"ms");
        out.close();
    }

    static long power(long k, long c, long mod){
        long y = 1;
        while(c > 0){
            if(c%2 == 1)
                y = y * k % mod;
            c = c/2;
            k = k * k % mod;
        }
        return y;
    }

    static int power(int x, int y, int p){ 
        int res = 1;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static int log2(int N)
    {
        int result = (int)(Math.log(N) / Math.log(2));
        return result;
    }

 
    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static void pni(Object o){out.println(o);out.flush();}
    static int ni()throws IOException{return sc.nextInt();}
    static long nl()throws IOException{return sc.nextLong();}
    static double nd()throws IOException{return sc.nextDouble();}
    static String nln()throws IOException{return sc.nextLine();}
    static int[] nai(int N)throws IOException{int[]A=new int[N];for(int i=0;i!=N;i++){A[i]=ni();}return A;}
    static long[] nal(int N)throws IOException{long[]A=new long[N];for(int i=0;i!=N;i++){A[i]=nl();}return A;}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////
 
    static class AnotherReader{BufferedReader br; StringTokenizer st;
    AnotherReader()throws FileNotFoundException{
    br=new BufferedReader(new InputStreamReader(System.in));}
    AnotherReader(int a)throws FileNotFoundException{
    br = new BufferedReader(new FileReader("input.txt"));}
    String next()throws IOException{
    while (st == null || !st.hasMoreElements()) {try{
    st = new StringTokenizer(br.readLine());}
    catch (IOException  e){ e.printStackTrace(); }}
    return st.nextToken(); } int nextInt() throws IOException{
    return Integer.parseInt(next());}
    long nextLong() throws IOException
    {return Long.parseLong(next());}
    double nextDouble()throws IOException { return Double.parseDouble(next()); }
    String nextLine() throws IOException{ String str = ""; try{
    str = br.readLine();} catch (IOException e){
    e.printStackTrace();} return str;}}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}