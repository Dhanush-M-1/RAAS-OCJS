
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;


 
 
public class Main
{
    static StringTokenizer st=new StringTokenizer("");
    static BufferedReader br;
    
    ///////////////////////////////////////////////////////////////////////////////////
    public static void main(String args[]) throws FileNotFoundException, IOException, Exception
    {
        //Scanner in =new Scanner(new FileReader("input.txt"));
        //PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
        //Scanner in=new Scanner(System.in);
        br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        //StringTokenizer st;//=new StringTokenizer(br.readLine());
        //////////////////////////////////////////////////////////////////////////////////////
        
        int n =ni(), k=ni();
	int a=ni() , b=ni() , c=ni() , d=ni();
	if (k == n - 1 || k == n || n == 4){
		out.print("-1");
                out.close();
		return ;
	}
        int ans[]=new int[n];
	ans[0] = a; 
	ans[1] = c; 
	ans[n - 1] = b;
	ans[n - 2] = d;
	int j = 2;
    for( int i = 1 ; i <= n; ++i ){
    	if (i == a || i == b || i == c || i == d) continue;
    	ans[j++] = i;
    }
    for( int i = 0 ; i < n ; ++i ) out.print(ans[i]+" ");
    out.print("\n"+ans[1]+" "+ans[0]+" ");
    for(int i = 2; i < n-2; i++) out.print(ans[i]+" ");
    out.print(ans[n-1]+" ");
    out.print(ans[n-2]+" ");
        
        //////////////////////////////////////////////////////////////////////////////////////
        out.flush();
	out.close();
    }
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////////
    
    private static long gcd(long a,long b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    private static class pair implements Comparable<pair>
    {
        int first;
        int second;
        pair()
        {
            first=0;
            second=0;
        }
        pair(int f,int s)
        {
            first=f;
            second=s;
        }
 
        public int compareTo(pair o)
        {
            if(second>  o.second)
                return 1;
            else if(second < o.second)
                return -1;
            else
                return 0;
        }
    }
    
    public static Integer ni() throws Exception
    {
        if(!st.hasMoreTokens())
            st=new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
    public static BigInteger nb()throws Exception
    {
        if(!st.hasMoreElements())
            st=new StringTokenizer(br.readLine());
        return BigInteger.valueOf(Long.parseLong(st.nextToken()));
    }
    public static Long nl() throws Exception
    {
        if(!st.hasMoreTokens())
            st=new StringTokenizer(br.readLine());
        return Long.parseLong(st.nextToken());
    }
    public static Double nd()throws Exception
    {
        if(!st.hasMoreElements())
            st=new StringTokenizer(br.readLine());
        return Double.parseDouble(st.nextToken());
    }
    public static String ns()throws Exception
    {
        if(!st.hasMoreElements())
            st=new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}