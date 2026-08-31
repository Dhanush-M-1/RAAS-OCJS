import java.util.*;
import java.io.*;
public class B {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
   	
      int n = sc.nextInt();
      long m = sc.nextLong();
      
      long[] a = new long[n];
      for(int i = 0; i < n; i++) {
         a[i] = sc.nextLong();
      }
      
      long[] b = new long[n];
      for(int i = 0; i < n; i++) {
         b[i] = sc.nextLong();
      }
      
      Arrays.sort(a);
      Arrays.sort(b);
      
      TreeSet<Long> mod = new TreeSet<Long>();
      for(int i = 0; i < n; i++) {
         mod.add((((b[0] - a[i]) % m) + m) % m);
      }
      
      for(long x : mod) {
         if(same(a, b, x, m)) {
            System.out.println(x);
            return;
         }
      }
      System.out.println(-1);
   }
   
   public static boolean same(long[] a, long[] b, long x, long m) {
      long[] at = new long[a.length];
      for(int i = 0; i < a.length; i++) {
         at[i] = (a[i] + x) % m;
      }
      Arrays.sort(at);
      for(int i = 0; i < at.length; i++) {
         if(at[i] != b[i]) {
            return false;
         }
      }
      return true;
   }
}