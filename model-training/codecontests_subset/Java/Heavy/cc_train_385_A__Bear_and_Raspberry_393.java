import java.text.DateFormat;
import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.Math.*;



public class solver {
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok;
    
    String readString() throws IOException{
        while (tok==null || !tok.hasMoreTokens()){
            try{
                tok=new StringTokenizer(in.readLine());             
            }
            catch(Exception e){
                return null;
            }
            
        }
        return tok.nextToken();
    }
    int readInt() throws NumberFormatException, IOException{
        return Integer.parseInt(readString());
    }
    long readLong() throws NumberFormatException, IOException{
        return Long.parseLong(readString());
    }
    double readDouble() throws NumberFormatException, IOException{
        return Double.parseDouble(readString());
    }
    
    final static boolean OJ=System.getProperty("ONLINE_JUDGE")!=null;
    
    
    void init() throws FileNotFoundException{        
        if (OJ){
            in=new BufferedReader(new InputStreamReader(System.in));
            out=new PrintWriter(System.out);             
        }else{
            in=new BufferedReader(new FileReader("input.txt"));
            out=new PrintWriter("output.txt");
        }
    }    
    int[] iMas(int n) throws NumberFormatException, IOException{
        int[] a=new int[n];
        for (int i=0;i<n;i++){
            a[i]=readInt();
        }
        return a;
    }
    
    int gcd(int a,int b){
        return (b==0)?a:gcd(b,a%b);
    }
    
    
    
    
    
        
    
    void solve() throws IOException{
        int n=readInt();
        int c=readInt();
        int[] a=iMas(n);
        int ans=0;
        for (int i=0;i<n-1;i++){
            if (a[i]>=c){
                ans=max(ans,a[i]-c-a[i+1]);
            }
        }
            
        out.println(ans);
    }
    
    
    void run() throws NumberFormatException, IOException{
        init();
        long h=System.currentTimeMillis();        
        solve();
        System.err.println(System.currentTimeMillis()-h);
        out.close();
    }
    
    
    

    
    public static void main(String[] args) throws NumberFormatException, IOException {
        new solver().run();
    }

}