import java.io.*;
import java.util.*;


public class Main {

    static PrintWriter pw;
    public static void main(String[] args) throws Exception{
        Scanner scan  = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        int iter = scan.nextInt();
        for (int i = 0; i < iter; i++) {
            int n = scan.nextInt();
            char arr[] = new char[4];
            for (int j = 0; j < n; j++) {
                String nxt =scan.next();
                if(j == 0 ){
                    arr[0] = nxt.charAt(1);
                }
                else if(j == 1){
                    arr[1] = nxt.charAt(0);
                }
                if( j == n -2 ){
                    arr[2] = nxt.charAt(n-1);
                }else if(j == n - 1){
                    arr[3] = nxt.charAt(n-2);
                }
            }
            if(arr[0] == arr[1] && arr[2] == arr[3] && arr[0] != arr[2])
                pw.println(0);
            else if(arr[0] == arr[1] && arr[2] == arr[3] && arr[0] == arr[2]){
                pw.println(2);
                pw.printf("%d %d", 2, 1);
                pw.println();
                pw.printf("%d %d", 1, 2);
                pw.println();
            }

            else if(arr[0] == arr[1]){

                pw.println(1);
                if(arr[0] == arr[2]){
                    pw.printf("%d %d", n-1 ,n);
                    pw.println();
                }
                else{
                    pw.printf("%d %d", n ,n - 1);
                    pw.println();
                }

            }
            else if(arr[2] == arr[3]){
                pw.println(1);
                if(arr[2] == arr[0]){
                    pw.printf("%d %d", 1 ,2);
                    pw.println();
                }
                else{
                    pw.printf("%d %d", 2 ,1);
                    pw.println();
                }
            }
            else{
                char c1 = arr[0];
                pw.println(2);
                pw.printf("%d %d", 1 ,2);
                pw.println();
                if(arr[2] != c1)
                    pw.printf("%d %d", n-1 ,n);
                else
                    pw.printf("%d %d", n ,n-1);
                pw.println();

            }
        }
        pw.flush();
        pw.close();
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
