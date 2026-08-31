import java.io.*;
        import java.util.HashSet;
        import java.util.StringTokenizer;

public class codeforces_350_D{

    public static void main (String [] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() , k = sc.nextInt();
        int a = sc.nextInt()  , b = sc.nextInt() , c = sc.nextInt() , d = sc.nextInt();

        if(k < n+1 || n == 4)
            {
                System.out.println(-1); return;
            }

        int aa [] = new int[n] , cc [] = new int[n];
        aa[0] = a;
        aa[1] = c;
        aa[n-2] = d;
        aa[n-1] = b;

        cc[0] = c;
        cc[1] = a;
        cc[n-2]=b;
        cc[n-1]=d;

        HashSet<Integer> taken = new HashSet<Integer> ();
        taken.add(a);
        taken.add(b);
        taken.add(c);
        taken.add(d);

        for(int i =2 ; i<n-2 ; ++i)
            for(int j = 1 ; ; ++j)
                if(!taken.contains(j))
                {
                    taken.add(j);
                    aa[i] = j;
                    cc[i] = j;
                    break;
                }

        for(int i = 0 ; i < n ; ++i)
            if(i==0)
                System.out.print(aa[i]);
            else System.out.print(" "+aa[i]);

        System.out.println();

        for(int i = 0 ; i < n ; ++i)
            if(i==0)
                System.out.print(cc[i]);
            else System.out.print(" "+cc[i]);

    }

    static class Scanner
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public Scanner(FileReader r){	br = new BufferedReader(r);}

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