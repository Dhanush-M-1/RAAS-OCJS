import java.util.*;
import java.io.*;
public class Solution
{
    FastScanner in;
    public Solution()
    {
        in=new FastScanner(System.in);
    }

    public static void main(String[] args)
    {
        new Solution().start();
    }

    public void start()
    {
        int n=in.nextInt();
        String str=in.next();
        for(int i=1;i<=n/4;i++)
        {
            for(int j=0;((j+i*4)<n?true:false);j++)
            {
                if(str.charAt(j)=='*' && str.charAt(j+i)=='*' && str.charAt(j+2*i)=='*' && str.charAt(j+3*i)=='*' && str.charAt(j+4*i)=='*')
                {
                    System.out.println("yes");
                    System.exit(0);
                }
            }
        }
        System.out.println("no");
    }
    
  
   
    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
