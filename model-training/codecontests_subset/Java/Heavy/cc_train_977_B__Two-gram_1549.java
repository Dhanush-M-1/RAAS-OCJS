import java.util.*;
import java.io.*;
public class codeforces {
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader fileReader) {
            br = new BufferedReader(fileReader);
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

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc  =new Scanner(System.in);PrintWriter pw=new PrintWriter(System.out);
        int n=sc.nextInt();String s=  sc.next();HashMap<String,Integer> h = new HashMap<>();
        String ans="";int m=0;
        for (int i=0;i<s.length()-1;i++){
            String c=  s.substring(i,i+2);if (h.containsKey(c))h.put(c,h.get(c)+1);else h.put(c,1);
            if (m<h.get(c)) {m=h.get(c);ans=c;}
        }
        System.out.print(ans);
    }
}