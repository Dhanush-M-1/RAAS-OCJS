import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Zep1 {

    void solve() throws IOException {
        int n=nextInt();
        char[] c=reader.readLine().toCharArray();
        boolean ch=false;
        for(int j=0;j<c.length;j++){
            if(c[j]=='*'){
                for(int i=1;i<c.length;i++){
                    if(j+4*i>=c.length){
                        break;
                    }else{
                        if(c[j]=='*'&&c[j+i]=='*'&&c[j+2*i]=='*'&&c[j+3*i]=='*'&&c[j+4*i]=='*'){
                            ch=true;
                            break;
                        }
                    }
                }
            }
        }
        if(ch){
            out.print("yes");
        }else{
            out.print("no");
        }
    }



    public static void main(String[] args) throws IOException {
        new Zep1().run();
    }

    void run() throws IOException {
    	reader = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(System.out));
//        reader = new BufferedReader(new FileReader("input.txt"));
//        out = new PrintWriter(new FileWriter("output.txt"));
        tokenizer = null;
        solve();
        reader.close();
        out.flush();

    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}