import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.util.*;
import java.util.Map.Entry;
public class Contest1 {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////                                                                                                               /////////
////////                                                                                                               /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMM          MMMM         OOOOOO             SSSSSSS      EEEEEEEEEEEEE  /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMMMM      MMMMMM      OOO      OOO        SSSS   SSS     EEEEEEEEEEEEE  /////////
////////   HHHH        HHHH  EEEEE           MMMM MMM  MMM MMMM    OOO          OOO    SSSS       SSS   EEEEE          /////////
////////   HHHH        HHHH  EEEEE           MMMM  MMMMMM  MMMM   OOO            OOO   SSSS             EEEEE          /////////
////////   HHHH        HHHH  EEEEE           MMMM          MMMM  OOO              OOO   SSSSSSS         EEEEE          /////////
////////   HHHHHHHHHHHHHHHH  EEEEEEEEEEE     MMMM          MMMM  OOO              OOO      SSSSSS       EEEEEEEEEEE    /////////
////////   HHHHHHHHHHHHHHHH  EEEEEEEEEEE     MMMM          MMMM  OOO              OOO         SSSSSSS   EEEEEEEEEEE    /////////
////////   HHHH        HHHH  EEEEE           MMMM          MMMM   OOO            OOO              SSSS  EEEEE          /////////
////////   HHHH        HHHH  EEEEE           MMMM          MMMM    OOO          OOO     SSS       SSSS  EEEEE          /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMM          MMMM      OOO      OOO        SSS    SSSS    EEEEEEEEEEEEE  /////////
////////   HHHH        HHHH  EEEEEEEEEEEEE   MMMM          MMMM         OOOOOO             SSSSSSS      EEEEEEEEEEEEE  /////////
////////                                                                                                               /////////
////////                                                                                                               /////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static boolean isvalid(String s){
        int c=0;
        boolean is =true;
        for (int i =0;i<s.length();i++){
            if (s.charAt(i)==')')c--;
            else c++;
            if (c<0){
                is=false;
                break;
            }
        }
        return is&&c==0;
    }
    static int getopen(String s){
        int c=0;
        boolean is =true;
        for (int i =0;i<s.length();i++){
            if (s.charAt(i)==')')c--;
            else c++;
            if (c<0){
                is=false;
                break;
            }
        }
        if (is){
            return c;
        }
        else return 0;
    }
    static int getclosed(String s){
        int c=0;
        boolean is =true;
        for (int i =s.length()-1;i>=0;i--){
            if (s.charAt(i)==')')c++;
            else c--;
            if (c<0){
                is=false;
                break;
            }
        }
        if (is){
            return c;
        }
        else return 0;
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        boolean [] ava= new boolean[n+1];
        int[]a = new int[m];
        TreeSet<Integer>points = new TreeSet<>();
        for (int i =0;i<=n;i++)points.add(i);
        for (int i =0;i<m;i++){
            a[i]=sc.nextInt();
            ava[a[i]]=false;
            points.remove(a[i]);
        }
        int[]preava= new int[n+1];
        for (int i =0;i<=n;i++){
            Integer x= points.floor(i);
            preava[i]=x==null?-1:x;
        }
        int max=0;
        int[] costs = new int[k];
        for (int i =0;i<k;i++)costs[i]=sc.nextInt();
        long ans=(long)1e18;
        for (int i =0;i<k;i++){
            int start=0;
            int count=0;
            while (start<n){
                count++;
                int x =preava[Math.min(start+i+1,n)];
                if (x<=start){
                    count=-1;
                    break;
                }
                start=x;
            }
            if (count==-1)continue;
//            pw.println(count);
            ans=Math.min(ans,1l*count*costs[i]);
        }
        if (points.contains(0))
        pw.println(ans==1e18?-1:ans);
        else pw.println(-1);
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