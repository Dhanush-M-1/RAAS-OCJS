import java.util.*;
import java.io.*;
import java.math.BigInteger;


public class solver {
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok;
    
    String readString() throws IOException{
        while (tok==null || !tok.hasMoreTokens()){
            tok=new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }
    int readInt() throws NumberFormatException, IOException{
        return Integer.parseInt(readString());
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
    
  
    
    
   
    
    
    void solve() throws NumberFormatException, IOException{
        
        
        int a=readInt();
        int b=readInt();
        int answer=0;
        
        int iz=0;
        
        while (a>0){
            answer++;
            a--;
            iz++;
            if (iz==b) {
                iz=0;
                a++;
            }
        }
        out.println(answer);
        
        
        
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