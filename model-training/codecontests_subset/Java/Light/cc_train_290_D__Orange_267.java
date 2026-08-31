import java.io.*;
import java.util.*;

public class SolutionC {
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
   char[] charArray() throws IOException{
      return next().toCharArray();
   }
   public static void main(String[] args) throws IOException {
      new SolutionC().run();
   }
   void run() throws IOException {
       in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(System.out);
      //in = new BufferedReader(new FileReader("input.txt"));
      //out = new PrintWriter("output.txt");
      solve();
      out.close();
   }
   void solve() throws IOException {
      char st[]=next().toLowerCase().toCharArray();
      int n=nextInt();
      for(int i=0;i<st.length;i++){
         char c=st[i];
         if(c<n+97){
            st[i]=Character.toUpperCase(c);
         }
         else{
           st[i]=Character.toLowerCase(c);
         }
      }
      out.println(String.valueOf(st));
   }

}
