import java.io.*;
import java.util.StringTokenizer;

public class main {
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
    static void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.nextInt();
        int d=in.nextInt();
        int low=0;
        int high=0;
        int ai=0;
        int count=0;
        boolean judge=true;
        for(int i=0;i<n;i++){
            ai=in.nextInt();
            if(ai==0){
                if(high<0){
                    high=d;
                    count=count+1;
                }
                low=Math.max(0,low);
            }else{
                low=low+ai;
                high=high+ai;
                high=Math.min(high,d);
                if(low>d){
                    judge=false;
                    i=n;
                }
            }
        }
        if(!judge){
            out.println(-1);
        }else{
            out.println(count);
        }
    }
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(1,in,out);
        out.close();
    }
}
