import java.util.*;
import java.io.*;
import java.math.*;
public class SerialKiller{
    public static void main(String[] args) {
        MyScanner sc=new MyScanner();
        String s1=sc.next();
        String s2=sc.next();
        System.out.println(s1+" "+s2);
        int n=sc.nextInt();
        while(n-->0){
            String dead=sc.next();
            String replace=sc.next();
            if(dead.equals(s1))s1=replace;
            else s2=replace;
            System.out.println(s1+" "+s2);
        }
    }
    public static int gcd(int a,int b){
        if(a==1||b==1)return 1;
        if(a%b==0)return b;
        return gcd(b,a%b);
    }
    public static int[] intArrayUtil(int n){
        int arr[]=new int[n];
        MyScanner sc=new MyScanner();
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        return arr;
    }
    private static class MyScanner {
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
}