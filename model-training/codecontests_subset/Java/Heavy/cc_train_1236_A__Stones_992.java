import java.io.*;
import java.util.*;
 
 
public class cf{
static int mod = (int)(Math.pow(10, 9) + 7);
   public static void main(String[] args) {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      
      int t= sc.nextInt();
      while (t-->0 ) {
    	 int a = sc.nextInt();
    	 int b=  sc.nextInt();
    	 int c = sc.nextInt();
    	 
    	 int stones = 0;
    	 int stones2 = 0;
    	 int a1 = a;
    	 int b1 = b;
    	 int c1 = c;
    	 while (a > 0 && b > 1) {
    		 a--;
    		 b-=2;
    		 stones+=3;
    	 }
    	 while (b > 0 && c > 1) {
    		 b--;
    		 c-=2;
    		 stones+=3;
    	 }
    	 while (b1 > 0 && c1 > 1) {
    		 b1--;
    		 c1-=2;
    		 stones2+=3;
    	 }
    	 while (a1 > 0 && b1 > 1) {
    		 a1--;
    		 b1-=2;
    		 stones2+=3;
    	 }
    	
    	 out.println(Integer.max(stones, stones2));
      }
      out.close();
   }
static void mergeSort(int[] A){ // low to hi sort, single array only
      int n = A.length;
      if (n < 2) return;
      int[] l = new int[n/2];
      int[] r = new int[n - n/2];
 
      for (int i = 0; i < n/2; i++){
        l[i] = A[i];
      }
 
      for (int j = n/2; j < n; j++){
        r[j-n/2] = A[j];
      }
 
      mergeSort(l);
      mergeSort(r);
      merge(l, r, A);
    }
 
    static void merge(int[] l, int[] r, int[] a){
      int i = 0, j = 0, k = 0;
      while (i < l.length && j < r.length && k < a.length){
        if (l[i] < r[j]){
          a[k] = l[i];
          i++;
        }
        else{
          a[k] = r[j];
          j++;
        }
        k++;
      }
      while (i < l.length){
        a[k] = l[i];
        i++;
        k++;
      }
 
      while (j < r.length){
        a[k] = r[j];
        j++;
        k++;
      }
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

