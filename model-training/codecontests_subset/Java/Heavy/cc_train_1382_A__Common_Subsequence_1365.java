import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        for (int i = 0; i <t ; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            HashSet<Integer> h1 = new HashSet<>();
            boolean f = true;
            for (int j = 0; j <n ; j++) {
                h1.add(sc.nextInt());
            }
            int[] arr = new int[m];
            for (int j = 0; j <m ; j++) {
               arr[j]=sc.nextInt();
            }
            for (int x: arr) {
                if (h1.contains(x)) {
                    out.println("YES");
                    out.println(1 + " " + x);
                    f=false;
                    break;
                }
            }
            if (f) out.println("NO");
        }
        out.flush();
    }
    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

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

        public boolean ready() throws IOException {return br.ready();}


    }
}