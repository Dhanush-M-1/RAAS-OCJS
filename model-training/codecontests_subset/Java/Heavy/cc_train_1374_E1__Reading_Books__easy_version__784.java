import java.util.*;import java.io.*;import java.math.*;
public class Main
{
    public static void process()throws IOException
    {
        int n=ni();
        int k=ni();
        int k1=0,k2=0;
        ArrayList<Integer>alice=new ArrayList<Integer>();
        ArrayList<Integer>bob=new ArrayList<Integer>();
        ArrayList<Integer>both=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            int val=ni();
            int x=ni();
            int y=ni();
            if(x==1 && y==1)
            {
                both.add(val);
                k2++;k1++;
            }
            else if(x==0 && y==1)
            {
                alice.add(val);
                k2++;
            }
            else if(x==1 && y==0)
            {
                bob.add(val);
                k1++;
            }
        }
        Collections.sort(alice);
        Collections.sort(bob);
        Collections.sort(both);
        if(k1<k || k2<k)
                {pn(-1);return;}
        long ans=0;
        int i=0,j=0;
        while(k>0)
        {
            if(i==alice.size() || i==bob.size())
            {
                ans+=both.get(j);
                j++;
            }
            else if(j==both.size())
            {
                ans+=alice.get(i)+bob.get(i);
                i++;
            }
            else
            {
                ans+=Math.min(both.get(j),alice.get(i)+bob.get(i));
                if(both.get(j)<alice.get(i)+bob.get(i))
                    j++;
                else
                    i++;
            }
            k--;
        }
        pn(ans);
    }

    static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
        if(oj){sc=new AnotherReader();out=new PrintWriter(System.out);}
        else{sc=new AnotherReader(100);out=new PrintWriter("output.txt");}
        int t=1;
        // t=ni();
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