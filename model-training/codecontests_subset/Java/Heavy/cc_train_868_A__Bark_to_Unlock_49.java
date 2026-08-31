import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class A{
    public static void main(String arg[]) {
        FastScanner sc = new FastScanner(System.in);
      String x = sc.next();
      char xx[] = x.toCharArray();
      int n = sc.nextInt();
      boolean t1 = false , t2 = false;
      for(int i =0;i<n;++i){
          String jj = sc.next();
          char ttt [] = jj.toCharArray();
         if(jj.equals(x)){
          t1 = true;
             t2 = true;
          }
          if(ttt[0]==xx[1]){
              t1 = true;
               
          }
          if(ttt[1]==xx[0]){
              t2 = true;

          }
           
          if(t1&&t2){
              System.out.println("YES");
              return;
          }

      }
      
        System.out.println("NO");


    }

    public int bi(long []x,int str,int end,long looking){
        int o = (str+end)/2;
        if(x[o]>looking){
            for(int i =str;i<o;++i){
                if(x[i]>=looking){
                    return i;
                }
            }
        }
        else if (x[o]<looking){
            for(int i =o;i<end;++i){
                if(x[i]>=looking){
                    return i;
                }
            }
        }
        return o;
    }




    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.valueOf(next());
        }
        double nextd() {
            return Double.valueOf(next());
        }
    }
}