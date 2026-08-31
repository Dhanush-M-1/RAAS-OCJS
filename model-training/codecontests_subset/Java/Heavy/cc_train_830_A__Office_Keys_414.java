import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D831 
{
    static class Scanner
    {
        BufferedReader br;
        StringTokenizer tk=new StringTokenizer("");
        public Scanner(InputStream is) 
        {
            br=new BufferedReader(new InputStreamReader(is));
        }
        public int nextInt() throws IOException
        {
            if(tk.hasMoreTokens())
                return Integer.parseInt(tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return Integer.parseInt(tk.nextToken());
        }
        public long nextLong() throws IOException
        {
            if(tk.hasMoreTokens())
                return Long.parseLong(tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return Long.parseLong(tk.nextToken());
        }
        public String next() throws IOException
        {
            if(tk.hasMoreTokens())
                return (tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return (tk.nextToken());
        }
        public String nextLine() throws IOException
        {
            tk=new StringTokenizer("");
            return br.readLine();
        }
        public double nextDouble() throws IOException
        {
            if(tk.hasMoreTokens())
                return Double.parseDouble(tk.nextToken());
            tk=new StringTokenizer(br.readLine());
            return Double.parseDouble(tk.nextToken());
        }
        public char nextChar() throws IOException
        {
            if(tk.hasMoreTokens())
                return (tk.nextToken().charAt(0));
            tk=new StringTokenizer(br.readLine());
            return (tk.nextToken().charAt(0));
        }
    
    
    
    }
    
    public static void main(String args[]) throws IOException
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int p=in.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=in.nextInt();
        Arrays.sort(a);
        int b[]=new int[k];
        for(int i=0;i<k;i++)
            b[i]=in.nextInt();
        Arrays.sort(b);
        int ans=Integer.MAX_VALUE;
        int l=k-n;
        for(int i=0;i<=l;i++)
        {
            int an=0;
            for(int j=0;j<n;j++)
            {
                an=Math.max(an, Math.abs(a[j]-b[j+i])+Math.abs(p-b[j+i]));
            }
            ans=Math.min(ans, an);
        }
        System.out.println(ans);
    }

}
