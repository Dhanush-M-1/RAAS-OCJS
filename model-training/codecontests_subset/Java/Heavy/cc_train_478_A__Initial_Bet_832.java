
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        ModScanner ms=new ModScanner();
          long a=ms.nextLong();
          long b=ms.nextLong();
          long c=ms.nextLong();
          long d=ms.nextLong();
          long e=ms.nextLong();
          long sum=a+b+c+d+e;
          if(sum%5!=0||sum==0)
              System.out.println("-1");
          else
              System.out.println((sum/5));
    }  
}
class ModScanner {
    BufferedReader br;
    StringTokenizer st;
 
    public ModScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
 
    String nextToken() throws Exception {
        while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            
        }
        return st.nextToken();
    }
 
    int nextInt() throws Exception, Exception {
        return Integer.parseInt(nextToken());
    }
 
    long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }
 
    double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}

