import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF{public static void main(String[]args)throws IOException{S s=new S();s.s();s.output();}}class S{
    void s() throws IOException {
        int n = NI();
        int x = NI();
        int y = NI();
        int res = (int)Math.ceil(y * n / 100.0) - x;
        sout(res < 0 ? 0 : res);
    }

    BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));StringTokenizer st=new StringTokenizer("");long LINF=Long.MAX_VALUE;
    StringBuilder output=new StringBuilder();final int INF=Integer.MAX_VALUE;void sout(Object x){output.append(x.toString()).append('\n');}
    void inLong(long[]a,int n){for(int i=0;i<n;i++)a[i]=NL();}int min(int i1,int i2){return i1<i2?i1:i2;}double ND(){return Double.parseDouble(NS());}
    long min(long i1,long i2){return i1<i2?i1:i2;}int max(int i1,int i2){return i1>i2?i1:i2;}long max(long i1,long i2){return i1>i2?i1:i2;}
    String NS(){while(!st.hasMoreTokens())try{st=new StringTokenizer(stdin.readLine());}catch(IOException ignored){}return st.nextToken();}
    int NI(){return Integer.parseInt(NS());}long NL(){return Long.parseLong(NS());}String NLn()throws IOException{return stdin.readLine();}
    int abs(int x){return x<0?-x:x;}long abs(long x){return x<0?-x:x;}void sout(){output.append('\n');}void out(Object x){output.append(x.toString());}
    int mod(int x,int mod){return(x+mod)%mod;}void output(){System.out.print(output);}void inInt(int[]a,int n){for(int i=0;i<n;i++)a[i]=NI();}
}