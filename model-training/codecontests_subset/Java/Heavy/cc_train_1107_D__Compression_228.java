import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        try {
            new Main().solve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    int gcd;
    private void solve() throws Exception{
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n=in.nextInt();
        gcd=0;
        String s=in.next();
        parse(s);
        int cnt=1;
        for(int i=1;i<n;i++){
            String tmp=in.next();
            if(tmp.equals(s)){
                cnt++;
            }else {
                gcd=gcd(cnt,gcd);
                parse(tmp);
                s=tmp;
                cnt=1;
            }
        }
        gcd=gcd(cnt,gcd);
        out.println(gcd);
        out.flush();
    }
    private void parse(String s){
        int cnt=0;
        int last=-1;
        for(int i=0;i<s.length();i++){
            int x=toInt(s.charAt(i));
            for(int j=3;j>=0;j--){
                int cur=(x&(1<<j))>0?1:0;
                if(last==cur){
                    cnt++;
                }else {
                    gcd=gcd(cnt,gcd);
                    cnt=1;
                }
                last=cur;
            }
        }
        gcd=gcd(cnt,gcd);
    }
    private static int toInt(char c){
        if('0'<=c&&c<='9')return c-'0';
        else return c-'A'+10;
    }
    private static int gcd(int a,int b){
        while(b!=0){
            int tmp=b;
            b=a%b;
            a=tmp;
        }
        return a;
    }
}
class InputReader{
    StreamTokenizer tokenizer;
    public InputReader(InputStream stream){
        tokenizer=new StreamTokenizer(new BufferedReader(new InputStreamReader(stream)));
        tokenizer.ordinaryChars(33,126);
        tokenizer.wordChars(33,126);
    }
    public String next() throws IOException {
        tokenizer.nextToken();
        return tokenizer.sval;
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    public boolean hasNext() throws IOException {
        int res=tokenizer.nextToken();
        tokenizer.pushBack();
        return res!=tokenizer.TT_EOF;
    }
}