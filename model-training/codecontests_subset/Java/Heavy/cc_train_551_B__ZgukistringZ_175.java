import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Юля on 18.09.2015.
 */
public class Solver551B {
    public static void main(String[] args) throws IOException {
        new Solver551B().run();
    }

    BufferedReader br;
    PrintWriter pw;
    StringTokenizer tokenizer;

    public String nextToken() throws IOException {
        if (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(br.readLine());
        }
        return tokenizer.nextToken();
    }

    public int nextInt() throws IOException, NumberFormatException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws IOException, NumberFormatException {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws IOException, NumberFormatException {
        return Double.parseDouble(nextToken());
    }

    public void run() throws IOException {
//        br = new BufferedReader(new FileReader("input.txt"));
//        pw = new PrintWriter("output.txt");
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new OutputStreamWriter(System.out));

        solve();

        pw.flush();
        pw.close();
    }

    private void solve() throws IOException {
        String s1 = nextToken();
        String b = nextToken();
        String c = nextToken();
        int[] kol1=new int[26];
        int[] kolb=new int[26];
        int[] kolc=new int[26];
        int result = 0;
        int resb=0;
        int resc=0;
        for (int i=0; i<s1.length(); i++) {
            kol1[(int)s1.charAt(i)-'a']++;
        }
        for (int i=0; i<b.length(); i++) {
            kolb[(int)b.charAt(i)-'a']++;
        }
        for (int i=0; i<c.length(); i++) {
            kolc[(int)c.charAt(i)-'a']++;
        }
        int maxB=Integer.MAX_VALUE;
        for (int i=0; i<26; i++) {
            if (kolb[i]>0) {
                maxB=Math.min(maxB, kol1[i]/kolb[i]);
            }
        }
        for (int i=0; i<=maxB; i++) {
            int maxC=Integer.MAX_VALUE;
            for (int j=0; j<26; j++) {
                if (kolc[j]>0) {
                    maxC=Math.min(maxC, (kol1[j]-i*kolb[j])/kolc[j]);
                }
            }
            if (i+maxC>result) {
                result=i+maxC;
                resb=i;
                resc=maxC;
            }
        }
        for (int i=0; i<resb; i++) {
            pw.print(b);
        }
        for (int i=0; i<resc; i++) {
            pw.print(c);
        }
        for (int i=0; i<26; i++) {
            for (int j=0; j<kol1[i]-kolb[i]*resb-kolc[i]*resc; j++) {
                pw.print((char)(i+(int)'a'));
            }
        }
        pw.println();
    }
}
