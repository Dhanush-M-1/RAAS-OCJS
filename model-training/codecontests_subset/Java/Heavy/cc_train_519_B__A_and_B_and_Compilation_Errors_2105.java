import java.io.*;
import java.util.*;

public class Main {
   private void solve() {
      int n = nextInt();
      int[] compil1 = nextIntArr(n);
      int[] compil2 = nextIntArr(n - 1);
      int[] compil3 = nextIntArr(n - 2);
      Arrays.sort(compil1);
      Arrays.sort(compil2);
      Arrays.sort(compil3);
      for(int i = 0; i < n; i++) {
         if(i == n - 1) {
            out.println(compil1[i]);
            out.flush();
            break;
         }
         if(compil1[i] != compil2[i]) {
            out.println(compil1[i]);
            out.flush();
            break;
         }
      }
      
      for(int i = 0; i < n - 1; i++) {
         if(i == n - 2) {
            out.println(compil2[i]);
            out.flush();
            break;
         }
         if(compil2[i] != compil3[i]) {
            out.println(compil2[i]);
            out.flush();
            break;
         }
      }
   }

   public static void main(String[] args) {
      new Main().run();
   }

   BufferedReader br;
   StringTokenizer st;
   PrintWriter out;

   private void run() {
      try {
         br = new BufferedReader(new InputStreamReader(System.in));
         out = new PrintWriter(System.out);
         // br = new BufferedReader(new FileReader("birthday.in"));
         // out = new PrintWriter(new FileWriter("birthday.out"));
         solve();
         br.close();
         out.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private long nextLong() {
      return Long.parseLong(next());
   }
   
   private int nextInt() {
      return Integer.parseInt(next());
   }

   private String next() {
      while (st == null || !st.hasMoreTokens()) {
         try {
            st = new StringTokenizer(br.readLine());
         } catch (IOException e) {
            e.printStackTrace();
            return "END_OF_FILE";
         }
      }
      return st.nextToken();
   }

   private int[] nextIntArr(int n) {
      int[] arr = new int[n];
      for (int i = 0; i < n; i++)
         arr[i] = nextInt();
      return arr;
   }

   private String[] nextArr(int n) {
      String[] arr = new String[n];
      for (int i = 0; i < n; i++)
         arr[i] = next();
      return arr;
   }
}