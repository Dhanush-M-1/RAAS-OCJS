import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;
public class Div3{
    public static void main(String[] args) {
      MyScanner sc=new MyScanner();
      int n=sc.ni();
      int ans=0;
      String best="";
      char ch[]=(sc.next()).toCharArray();
      for(int i=0;i<n-2+1;i++){
        String s=""+ch[i]+""+ch[i+1];
        int c=0;
        for(int j=0;j<n-2+1;j++){
          String f=""+ch[j]+""+ch[j+1];
          if(s.equals(f)) c++;
        }
        if(c>ans){ans=c;best=s;}
      }
      System.out.println(best);
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

      int ni() {
          return Integer.parseInt(next());
      }
      float nf() {
        return Float.parseFloat(next());
      }
      long nl() {
          return Long.parseLong(next());
      }

      double nd() {
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