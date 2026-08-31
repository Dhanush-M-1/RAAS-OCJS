import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CF260B{
    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String nextLine() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class SuffixArray {
        public Integer[] sa;
        public int[] rank;
        public int[] height;
        public int n;
        public String str;
        SACmp cmp;

        public SuffixArray(String str){
            this.str = str;
            this.n = str.length();
            sa = new Integer[n+1];
            rank = new int[n+1];
            height = new int[n+1];
            cmp = new SACmp();
            constructSA();
            constructH();
        }

        private void constructSA(){
            for (int i=0; i<=n; i++) {
                rank[i] = i<n?str.charAt(i):-1;
                sa[i] = i;
            }
           Arrays.sort(sa, cmp);
            int[] tmp = new int[n+1];
            for (int k=1; k<n; k*=2){
                cmp.k = k;
                Arrays.sort(sa, cmp);
                tmp[sa[0]] = 0;
                for (int i=1; i<=n; i++){
                    tmp[sa[i]] = tmp[sa[i-1]]+Math.min(1, cmp.compare(sa[i], sa[i-1]));
                }
                for (int i=0; i<=n; i++) {
                    rank[i] = tmp[i];
                }
            }
            for (int i=0; i<=n; i++){
                rank[sa[i]] = i;
            }
        }

        private void constructH(){
            int h = 0;
            for (int i=0; i<n; i++){
                int j = sa[rank[i]-1];
                if (h>0) h--;
                while (i+h<n&&j+h<n&&str.charAt(i+h)==str.charAt(j+h)){
                    h++;
                }
                height[rank[i]] = h;
            }
        }

        private class SACmp implements Comparator<Integer> {
            public int k;

            @Override
            public int compare(Integer x, Integer y){
                if (rank[x]!=rank[y]) return rank[x]-rank[y];
                else {
                    int rx = x+k<n?rank[x+k]:-1;
                    int ry = y+k<n?rank[y+k]:-1;
                    return rx-ry;
                }
            }
        }
    }

    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static boolean isDate(String str){
        String[] num = str.split("-");
        if (num.length!=3){
            return false;
        }
        int[] numint = new int[3];
        try{
            for (int i=0; i<3; i++){
                if (i<2&&num[i].length()!=2){
                    return false;
                }
                numint[i] = Integer.valueOf(num[i]);
            }
        } catch (NumberFormatException e){
            return false;
        }
        return numint[1]>=1&&numint[1]<=12
            && numint[0]>=1&&numint[0]<=days[numint[1]]
            && numint[2]>=2013&&numint[2]<=2015;
    }

    public static void main(String[] args){
        InputReader scn = new InputReader(System.in);
        String str = scn.nextLine();
        SuffixArray sa = new SuffixArray(str);
        int cnt = 0;
        int max = 0;
        String ans = "", pre = "";
        int n = str.length();
        boolean hasDate = false;
        for (int i=1; i<=n; i++){
            if (sa.sa[i]+10<=n){
                String now = str.substring(sa.sa[i], sa.sa[i]+10);
                if (hasDate&&sa.height[i]>=10){
                    cnt ++;
                } else{
                    if (cnt>max){
                        ans = pre;
                        max = cnt;
                    }
                    if (isDate(now)){
                        cnt = 1;
                        pre = now;
                        hasDate = true;
                    } else {
                        hasDate = false;
                    }
                }
            }
        }
        if (cnt>max){
            ans = pre;
            max = cnt;
        }
        System.out.println(ans);
    }
}