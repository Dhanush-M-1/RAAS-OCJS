import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Dubstep
{
    public static void main(String[] args) throws IOException
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int i,j=0;
        StringTokenizer dates;
        int[] vec1=new int[100];
        int[] vec2=new int[100];
        int cont=0;
        for(i=0;i<n;i++)
        {
            dates=new StringTokenizer(scan.nextLine());
            int a=Integer.parseInt(dates.nextToken());
            int b=Integer.parseInt(dates.nextToken());
            vec1[a-1]++;
            vec2[b-1]++;
        }
        for(i=0;i<100;i++)
        {
            if(vec1[i]!=0&&vec2[i]!=0)
                cont+=vec1[i]*vec2[i];
        }
        System.out.println(cont);
    }
    static class Scanner 
    {
        StringTokenizer st;
        BufferedReader br;
        public Scanner(InputStream s)
        {
            br = new BufferedReader(new InputStreamReader(s));
        }
        public Scanner(FileReader r)
        {
            br = new BufferedReader(r);
        }
        public String next() throws IOException 
        {
            while (st == null || !st.hasMoreTokens()) 
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public int nextInt() throws IOException 
        {
            return Integer.parseInt(next());
        }
        public long nextLong() throws IOException 
        {
            return Long.parseLong(next());
        }
        public String nextLine() throws IOException 
        {
            return br.readLine();
        }
        public double nextDouble() throws IOException
        {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if(x.charAt(0) == '-')
            {
                neg = true;
                start++;
            }
            for(int i = start; i < x.length(); i++)
                if(x.charAt(i) == '.')
                {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                }
                else
                {
                    sb.append(x.charAt(i));
                    if(dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg?-1:1);
        }
        public boolean ready() throws IOException 
        {
            return br.ready();
        }
    }
}