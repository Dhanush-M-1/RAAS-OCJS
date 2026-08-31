import java.util.*;
import java.io.*;
public class Main
{
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
    static class Pair
    {
        int x,y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String args[])
    {
        FastReader fs=new FastReader();
        PrintWriter pw=new PrintWriter(System.out);
        int n=fs.nextInt();
        char c[][]=new char[n][n/4];
        for(int i=0;i<n;i++)
        c[i]=fs.nextLine().toCharArray();
        char cc[][]=new char[n][n];
        for(int i=0;i<n;i++)
        {
            int ptr=0;
            for(int j=0;j<n/4;j++)
            {
                char ct=c[i][j];
                int temp;
                if(ct>='A')
                temp=ct-'A'+10;
                else
                temp=ct-'0';
                for(int p=0,k=ptr+3;p<4;p++,k--)
                {
                    if((temp&(1<<p))>0)
                    cc[i][k]='1';
                    else
                    cc[i][k]='0';
                }
                ptr+=4;
            }
        }
        ArrayList<Integer> divisors=new ArrayList<>();
        divisors.add(n);
        for(int i=2;i<=n;i++)
        {
            if(n%i==0)
            divisors.add(i);
        }
        int mat[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++)
        Arrays.fill(mat[i],1);
        for(int i=2;i<=n;i++)
        {
            for(int j=2;j<=n;j++)
            {
                if(cc[i-2][j-1]==cc[i-2][j-2]&&cc[i-2][j-2]==cc[i-1][j-2]&&cc[i-1][j-1]==cc[i-2][j-1])
                mat[i][j]=Math.min(mat[i-1][j],Math.min(mat[i-1][j-1],mat[i][j-1]))+1;
            }
        }
        int mx=1;
        for(int i:divisors)
        {
            boolean got=true;
            outer:for(int j=i;j<=n;j+=i)
            {
                for(int k=i;k<=n;k+=i)
                {
                    if(mat[j][k]<i)
                    {
                        got=false;
                        break outer;
                    }
                }
            }
            if(got)
            mx=Math.max(mx,i);
        }
        pw.println(mx);
        pw.flush();
        pw.close();
    }
}