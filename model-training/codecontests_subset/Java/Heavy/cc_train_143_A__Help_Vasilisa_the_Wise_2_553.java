import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A implements Runnable{
    
    BufferedReader in;
    PrintWriter out;
    StringTokenizer Tokenizer;
    
    private void solve() throws IOException{
        int r1,r2,c1,c2,d1,d2;
        r1=NextInt();r2=NextInt();
        c1=NextInt();c2=NextInt();
        d1=NextInt();d2=NextInt();
        boolean ok = true;
        int x=0,y=0,z=0,t=0;
        if((c1+r1-d2)%2!=0) ok=false;
        else x = (c1+r1-d2)/2;
        if((c1-r1+d2)%2!=0) ok=false;
        else z = (c1-r1+d2)/2;
        
        y = r1-x;
        t = r2-z;
        
        if(x<1 || y<1 || z<1 || t<1) ok = false;
        if(x>9 || y>9 || z>9 || t>9) ok = false;
        if (x==y || x==z|| x==t || y == z|| y==t || z==t) ok = false;
        if (x+z!=c1 || y+t!=c2 || x+y !=r1 || z+t!=r2 || x+t!=d1 || y+z!=d2) ok = false;
        if (!ok) out.println("-1");
        else{
            out.println(str(x)+" "+str(y));
            out.println(str(z)+" "+str(t));
        }
    }
    
    public static String removeCharAt(String s, int pos) {
           StringBuffer buf = new StringBuffer( s.length() - 1 );
           buf.append( s.substring(0,pos) ).append( s.substring(pos+1) );
           return buf.toString();
        }
    
    public void run(){
        try{
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            in.close();
            out.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    int NextInt() throws IOException{
        return Integer.parseInt(NextToken());
    }
    
    long NextLong() throws IOException{
        return Long.parseLong(NextToken());
    }
    
    double NextDouble() throws IOException{
        return Double.parseDouble(NextToken());
    }
    String str(int x){
        return Integer.toString(x);
    }
    
    String NextToken() throws IOException{
        while(Tokenizer == null || !Tokenizer.hasMoreTokens()){
            Tokenizer = new StringTokenizer(in.readLine());
        }
        return Tokenizer.nextToken();
    }
    
    public static void main(String[] args){
        new A().run();
    }
}
