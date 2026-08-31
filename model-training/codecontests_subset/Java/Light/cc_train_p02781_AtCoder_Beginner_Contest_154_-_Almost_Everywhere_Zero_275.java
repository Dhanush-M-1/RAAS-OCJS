				
import java.util.*;import java.io.*;import java.math.*;

public class Main
{

    static long dp[][][]=new long[101][101][101];//(idx,k,tight)

    static long count_ans_when(int idx,int k,int tight,int n,int arr[]){
        if(idx==n+1)
        {
            if(k==0)
                return 1l;
            else
                return 0l;
        }

        if(k<0)
            return 0;
        
        if(dp[idx][k][tight]!=-1)
            return dp[idx][k][tight];

        int range=(tight==1)?arr[idx]:9;

        long res=0l;

        int new_tight=tight;

        if(arr[idx]>0)
            new_tight = 0;

        res+=count_ans_when(idx+1,k,new_tight,n,arr);

        for(int i=1;i<=range;i++){
            new_tight=(arr[idx]==i)?tight:0;
            res+=count_ans_when(idx+1,k-1,new_tight,n,arr);
        }

        return (dp[idx][k][tight]=res);
    }
    public static void process()throws IOException
    {
    	char ch[]=(" "+nln()).toCharArray();
    	int tk=ni();
    	
        int len=ch.length,arr[]=new int[len];

        len--;
        for(int i=1;i<=len;i++) arr[i]=ch[i]-'0';

        for(int i=0;i<=100;i++) for(int j=0;j<=100;j++) for(int k=0;k<=100;k++) dp[i][j][k]=-1l;

        pn(count_ans_when(1,tk,1,len,arr));
    }


   	static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc=new AnotherReader();
        boolean oj = true;

    	//oj = System.getProperty("ONLINE_JUDGE") != null;
    	if(!oj) sc=new AnotherReader(100);

        long s = System.currentTimeMillis();
        int t=1;
        while(t-->0)
            process();
        out.flush();
        if(!oj)
            System.out.println(System.currentTimeMillis()-s+"ms");
        System.out.close();  
    }

    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static void pni(Object o){out.println(o);System.out.flush();}
    static int ni()throws IOException{return sc.nextInt();}
    static long nl()throws IOException{return sc.nextLong();}
    static double nd()throws IOException{return sc.nextDouble();}
    static String nln()throws IOException{return sc.nextLine();}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}
    static boolean multipleTC=false;



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
	
	
	