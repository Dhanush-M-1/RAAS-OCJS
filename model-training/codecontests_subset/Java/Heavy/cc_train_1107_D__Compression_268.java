import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main implements Runnable {

    int maxn = (int)5200+11;
    int inf = (int)1e9;
    long mod = (long)1e9+7;
    int n,m,k;
    boolean a[][] = new boolean[maxn][maxn];
    int prefSum[][] = new int[maxn][maxn];

    void solve() throws Exception {
        n = in.iInt();
        for (int i=0; i<n; i++) {
            String s = in.sString();
            char binary[] = hexToBin(s);
            for (int j=0; j<n; j++) {
                a[i+1][j+1] = (binary[j]-'0')==1?true:false;
            }
        }


        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                prefSum[i][j] = prefSum[i-1][j] + prefSum[i][j-1] + (a[i][j]?1:0) - prefSum[i-1][j-1];
            }
        }

        ArrayList<Integer> divs = new ArrayList<>();
        for (int i=2; i*i<=n; i++) {
            if (n%i==0) {
                divs.add(i);
                if (i!=n/i) {
                    divs.add(n/i);
                }
            }
        }
        divs.add(n);
        Collections.sort(divs);
        int x = 1;
        for (int jump : divs) {
            boolean isPossible = true;
            outer:
            for (int i = 1; i <= n; i+=jump) {
                for (int j = 1; j <= n; j+=jump) {
                    int sum = getSquareSum(i,j,jump-1);
                    isPossible &= (sum==jump*jump || sum==0);
                    if (!isPossible) {
                        break outer;
                    }
                }
            }
            if (isPossible) {
                x = jump;
            }
        }

        out.println(x);
    }

    private int getSquareSum(int i, int j, int jump) {
        int sum = prefSum[i+jump][j+jump] - prefSum[i+jump][j-1] - prefSum[i-1][j+jump] + prefSum[i-1][j-1];
        return sum;
    }

    private char[] hexToBin(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            String temp = Integer.toBinaryString(Integer.parseInt(Character.toString(s.charAt(i)), 16));
            for (int j=1; j<=4-temp.length(); j++) {
                sb.append("0");
            }
            sb.append(temp);
        }
        return sb.toString().toCharArray();
    }

    class Pair {
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    String fileInName = "";

    static Throwable throwable;
    public static void main (String [] args) throws Throwable {
        Thread thread = new Thread(null, new Main(), "", (1 << 26));
        thread.start();
        thread.join();
        thread.run();
        if (throwable != null)
            throw throwable;
    }

    FastReader in;
    PrintWriter out;

    public void run() {

        try {
            if (!fileInName.isEmpty()) {
                in = new FastReader(new BufferedReader(new FileReader(fileInName+".in")));
                out = new PrintWriter(new BufferedWriter(new FileWriter(fileInName+".out")));
            } else {
                in = new FastReader(new BufferedReader(new InputStreamReader(System.in)));
                out = new PrintWriter(System.out);
            }

            solve();
        } catch(Exception e) {
            throwable = e;
        } finally {
            out.close();
        }

    }

    class FastReader {
        BufferedReader bf;
        StringTokenizer tk = null;

        public FastReader(BufferedReader bf) {
            this.bf = bf;
        }

        public Integer iInt() throws Exception {
            return Integer.parseInt(sString());
        }

        public Long lLong() throws Exception {
            return Long.parseLong(sString());
        }

        public Double dDouble() throws Exception {
            return Double.parseDouble(sString());
        }

        public String sString () throws Exception {
            if (tk==null || !tk.hasMoreTokens()) {
                tk = new StringTokenizer(bf.readLine());
            }
            if (!tk.hasMoreTokens()) return sString();
            else
                return tk.nextToken();
        }
    }
}