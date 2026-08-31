import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;
public class MakeMedian{
    public static void main(String[] args) {
      MyScanner sc=new MyScanner();
      int n=sc.ni(), med=sc.ni();
      int arr[]=new int[n];
      for(int i=0;i<n;i++)
        arr[i]=sc.ni();
      Arrays.sort(arr);
      int mid=n/2;
      long ans1=0, ans2=0;
      for(int i=0;i<mid;i++){
          if(arr[i]>med) ans1+=arr[i]-med;
          if(arr[n-1-i]<med) ans2+=med-arr[n-1-i];
      }
      long ans=ans1+ans2+Math.abs(arr[mid]-med);
      System.out.println(ans);
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