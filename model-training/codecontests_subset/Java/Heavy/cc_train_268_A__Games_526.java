import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Solution {
   BufferedReader in;
   StringTokenizer str;
   PrintWriter out;
   String SK;
   String next() throws IOException {
      while ((str == null) || (!str.hasMoreTokens())) {
      SK = in.readLine();
      if (SK == null)
      return null;
      str = new StringTokenizer(SK);
      }
      return str.nextToken();
   }
   int nextInt() throws IOException {
      return Integer.parseInt(next());
   }
   double nextDouble() throws IOException {
      return Double.parseDouble(next());
   }
   long nextLong() throws IOException {
      return Long.parseLong(next());
   }
   void run() throws IOException {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(System.out);
      //in = new BufferedReader(new FileReader("input.txt"));
      //out = new PrintWriter("output.txt");
      solve();
      out.close();
   }
   public static void main(String[] args) throws IOException {
      new Solution().run();
   }

   void solve() throws IOException {
      int n=nextInt();
      int num[][]=new int[n][2];
      for(int i=0;i<n;i++){
         num[i][0]=nextInt();
         num[i][1]=nextInt();
      }
      int tot=0;
      for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
            if(i==j)continue;
            if(num[i][0]==num[j][1])
               tot++;
         }
      }
      out.println(tot);
   }

}
