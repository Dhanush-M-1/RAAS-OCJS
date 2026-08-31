import java.awt.*;
import java.io.*;
import java.util.*;

public class Abc {
    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();
        String a = sc.next(), b = sc.next(), c = sc.next();
        int cnta[] = new int[26], cntb[] = new int[26], cntc[] = new int[26];
        for (int i = 0; i < a.length(); i++) {
            cnta[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            cntb[b.charAt(i) - 'a']++;
        }
        for (int i = 0; i < c.length(); i++) {
            cntc[c.charAt(i) - 'a']++;
        }
        int maxb=Integer.MAX_VALUE;
        for (int i=0;i<26;i++){
            if (cntb[i]==0)continue;
            maxb=Math.min(cnta[i]/cntb[i],maxb);
        }
        int ansb=0,ansc=0;
        for (int i=0;i<=maxb;i++){
            int cc=Integer.MAX_VALUE;
            for (int j=0;j<26;j++){
                if (cntc[j]>0){
                    cc=Math.min(cc,(cnta[j]-i*cntb[j])/cntc[j]);
                }
            }
            if (ansb+ansc<i+cc){
                ansb=i;
                ansc=cc;
            }
        }
        StringBuilder sb=new StringBuilder();
//        System.out.println(a.length());
//        System.out.println(ansb+" "+ansc);
        for (int i=0;i<ansb;i++)sb.append(b);
        for (int i=0;i<ansc;i++)sb.append(c);
        for (int i=0;i<sb.length();i++)cnta[sb.charAt(i)-'a']--;
        for (int i=0;i<26;i++){
            for (int j=0;j<cnta[i];j++){
                sb.append((char) (i+'a'));
            }
        }
        System.out.println(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}