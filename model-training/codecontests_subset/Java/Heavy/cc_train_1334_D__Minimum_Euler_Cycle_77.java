import java.io.*;
import java.util.*;
import java.util.zip.Adler32;

public class Contest1 {
    static long[]memo;
    static long[]cc;
    static long[][]a;
    static long dp(int idx){
        if (idx>=a.length)
            return 0;
        if (memo[idx]!=-1)
            return memo[idx];
        long ans = Math.max(0,a[idx][0]-a[idx-1][1])+dp(idx+1);
        return memo[idx]=ans;
    }
    static void clac(){
        cc[0]=a[0][0];
        for (int j =1;j<a.length;j++){
            cc[j]=Math.max(0,a[j][0]-a[j-1][1])+cc[j-1];
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            long l = sc.nextLong();
            long r = sc.nextLong();
            long ss=-1;
            long ee=-1;
            ArrayList<Integer>gen = new ArrayList<>();
            long here=0;
            for (int i =1;i<n;i++){
                long cur = 2*(n-i);
                if (cur+here>=l){
                    if (ss==-1) {
                        ss = here + 1;
                        here += cur;
                        ee = here;
                        for (int f = i + 1; f <= n; f++) {
                            gen.add(i);
                            gen.add(f);
                        }
                    }
                    else if (here<r){
                        here += cur;
                        ee = here;
                        for (int f = i + 1; f <= n; f++) {
                            gen.add(i);
                            gen.add(f);
                        }
                    }
                    else here+=cur;
                }
                else {
                    here += cur;
                }
            }
            if (ee<r){
                if (ss==-1) {
                    ss = here + 1;
                    ee=here;
                }
                ee++;
                gen.add(1);
            }
//            System.err.println(ss+" "+ee);
            int start= (int)(l-ss);
            int end = (int) (start+(r-l+1));
            for (;start<end;start++)
                pw.print(gen.get(start)+" ");
            pw.println();
        }
        pw.flush();
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }

}