
import java.io.*;
import java.math.BigInteger;
import static java.math.BigInteger.*;
import java.util.*;


public class Solution{
    
    void solve()throws Exception
    {
        int k=nextInt();
        for(int i=1;i<=k-1;i++)
            for(int j=1;j<=k-1;j++)
            {
                String s=(valueOf(i*j)).toString(k);
                if(j==k-1)
                    System.out.println(s);
                else
                    System.out.print(s+" ");
            }
    }



    BufferedReader reader;
    StringTokenizer stk;
    void run()throws Exception
    {
        reader=new BufferedReader(new InputStreamReader(System.in));
        stk=null;
        solve();
        reader.close();
    }
    int nextInt()throws Exception
    {
        return Integer.parseInt(nextToken());
    }
    long nextLong()throws Exception
    {   
        return Long.parseLong(nextToken());
    }
    double nextDouble()throws Exception
    {       
        return Double.parseDouble(nextToken());
    }
    String nextString()throws Exception
    {
        return nextToken();
    }
    String nextLine()throws Exception
    {
        return reader.readLine();
    }
    String nextToken()throws Exception
    {
        if(stk==null || !stk.hasMoreTokens())
        {
            stk=new StringTokenizer(nextLine());
            return nextToken();
        }
        return stk.nextToken();
    }
    
    public static void main(String[]a) throws Exception
    {   
        new Solution().run();

    }
    
            
    
}
