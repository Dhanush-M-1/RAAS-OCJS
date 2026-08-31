import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) {
       MyScanner sk = new MyScanner();
       out = new PrintWriter(new BufferedOutputStream(System.out));
       int totalNumOfCases = sk.nextInt();
        for (int i = 0; i < totalNumOfCases; i++){
            Vector<Integer> storage = new Vector<>();
           int m = sk.nextInt();
           int index = 0;
           while (index < m) {
               storage.add(sk.nextInt());
               index ++;
           }
           boolean boo = false;
            for (int j = 2; j < m; j++) {
                int sum = storage.get(0), sum1 = storage.get(1);
                if (sum + sum1 <= storage.get(j)){
                    int p = j+1;
                    out.println(1 + " " + 2 + " " + p);
                    boo = true;
                    break;
                }
            }
            if (!boo) out.println(-1);

       // Stop writing your solution here. -------------------------------------
        }
        out.close();
    }
 
      
 
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
       
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
       BufferedReader br;
       StringTokenizer st;
  
       public MyScanner() {
          br = new BufferedReader(new InputStreamReader(System.in));
       }
  
       String next() {
           while (st == null || !st.hasMoreElements()) {
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
           return Long.parseLong(next());
       }
  
       double nextDouble() {
           return Double.parseDouble(next());
       }
  
       String nextLine(){
           String str = "";
       try {
          str = br.readLine();
       } catch (IOException e) {
          e.printStackTrace();
       }
       return str;
       }
 
    }
    //--------------------------------------------------------
 }