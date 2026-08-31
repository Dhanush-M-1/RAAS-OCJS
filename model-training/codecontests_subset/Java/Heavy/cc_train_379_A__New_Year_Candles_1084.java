import java.io.*;
import java.util.*;

public class NewYearCandles{
    public static int b;
    public static int algorithm(int a){
        if (a >= b){
            return b + algorithm(a - (b - 1));
        }else{
            return a;
        }
    }
    public static void main(String[] args) {
       MyScanner sc = new MyScanner();
       out = new PrintWriter(new BufferedOutputStream(System.out));
       int a = sc.nextInt();
       b = sc.nextInt();
       out.println(algorithm(a));
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