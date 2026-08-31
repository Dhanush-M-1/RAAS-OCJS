import java.util.*;import java.io.*;import java.math.*;
public class Main
{
    public static void process()throws IOException
    {
        int n=ni();
        int m=ni();
        long[]A=nal(n);
        long[]q=nal(m);
        long[]ans=new long[m];
        long sum=A[0];
        long[]pref=new long[n];
        pref[0]=Math.max(A[0],0);
        TreeMap<Long,Long>mp=new TreeMap<>();
        mp.put(pref[0],1l);
        for(int i=1;i<n;i++)
        {
            sum+=A[i];
            pref[i]=Math.max(sum,pref[i-1]);
            if(!mp.containsKey(pref[i]))
                mp.put(pref[i],(i+1l));
        }
        for(int i=0;i<m;i++)
        {
            if(mp.ceilingKey(q[i])==null && sum<=0)
                ans[i]=-1;
            else
            {
                if(mp.ceilingKey(q[i])!=null)
                    ans[i]=mp.get(mp.ceilingKey(q[i]));
                else
                {
                    long iter=(long)Math.ceil((double)(q[i]-mp.lastKey())/sum);
                    ans[i]=n*iter;
                    ans[i]+=mp.get(mp.ceilingKey(q[i]-iter*sum));
                }
            }
            if(ans[i]>0)
                ans[i]--;
        }
        for(long i:ans)
            p(i+" ");
        pn("");
    }

    static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        if(oj){sc=new AnotherReader();out=new PrintWriter(System.out);}
        else{sc=new AnotherReader(100);out=new PrintWriter("output.txt");}
        int t=1;
        t=ni();
        while(t-->0) {process();}
        out.flush();out.close();  
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