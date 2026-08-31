import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main {
    public static PrintWriter out = new PrintWriter(System.out);
    public static FastScanner enter = new FastScanner(System.in);

    public static void main(String[] args) throws IOException {
        solve();
        out.close();
    }

    private static void solve() throws IOException {
        String s=enter.nextLine();
        s=s.trim();
        String left=s.split("=")[0], right=s.split("=")[1];
        right=right.trim();
        int n=Integer.parseInt(right);
        int all=0;
        int neg=0;
        int pos=0;
        for(int i=0;i<left.length();i++){
            if(left.charAt(i)=='?') all++;
            else if(left.charAt(i)=='-') neg++;
        }
        pos=all-neg;
        if(Math.max(pos, n+neg)>Math.min(n*(neg+1), pos*n)){
            out.println("Impossible");
            return;

        }
        out.println("Possible");
        ArrayList<Integer> posArr=new ArrayList<>(pos);
        ArrayList<Integer> negArr=new ArrayList<>(neg);
        int need=Math.max(pos, n+neg);
        need-=pos;
        for (int i = 0; i <pos ; i++) {
            posArr.add(i,Math.min(need, n-1)+1);
            need-=Math.min(need, n-1);
        }
        need=Math.max(pos, n+neg)-n;
        need-=neg;
        for (int i = 0; i <neg ; i++) {
            negArr.add(i, Math.min(need, n-1)+1);
            need-=Math.min(need, n-1);
        }
        int l=0;
        int r=0;
        int prev=1;
        //1  +
        //0 -
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='-'){
                prev=0;
            }
            else if(s.charAt(i)=='+'){
                prev=1;
            }
            else if(s.charAt(i)=='?'){
                if(prev==0) {
                    out.print(negArr.get(r));
                    r++;
                }
                else {
                    out.print(posArr.get(l));
                    l++;
                }
            }
            if(s.charAt(i)!='?') out.print(s.charAt(i));
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer stok;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() throws IOException {
            while (stok == null || !stok.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return null;
                }
                stok = new StringTokenizer(s);
            }
            return stok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        char nextChar() throws IOException {
            return (char) (br.read());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }
    }


}
