import java.io.*;
import java.math.BigInteger;

public class Main
{
   public static void main(String[] args) throws IOException
   {
      new Main().run();
   }
   
   BufferedReader in;
   StreamTokenizer st;
   PrintWriter out;

   double nextDouble() throws IOException
   {
       st.nextToken();
       return (double)st.nval;
   }
   
   String nextString() throws IOException
   {
      st.nextToken();
      return (String)st.sval;
   }

   int nextInt() throws IOException
   {
      st.nextToken();
      return (int)st.nval;
   }
   
   long nextLong() throws IOException
   {
       st.nextToken();
       return (long)st.nval;
   }


   void run() throws IOException
   {
      in = new BufferedReader(new InputStreamReader(System.in));
      st = new StreamTokenizer(in);
      out = new PrintWriter(new OutputStreamWriter(System.out));
      
      solve();
      out.flush();
   }

   void solve() throws IOException {
       int n = nextInt();
       int c = nextInt() - 1;
       int[] mas = new int[n];
       boolean[] isLast = new boolean[n];
       for (int i=0; i<n; i++){
           isLast[i] = true;
       }
       for (int i=0; i<n; i++){
           mas[i] = nextInt() - 1;
           if (mas[i] >= 0){
               isLast[mas[i]] = false;
           }
       }
       int q = 1;
       int cc = c;
       while (mas[cc] >= 0){
           q++;
           cc = mas[cc];
       }
       int l = 0;
       int[] len = new int[n];
       boolean[][] possible = new boolean[2 * n][n+1];
       possible[q][0] = true;
       for (int i=0; i<n; i++){
           if (isLast[i]){
               boolean hasUB = false;
               int qq= 1;
               int ccc = i;
               while (mas[ccc] >= 0){
                   if (ccc == c){
                       hasUB = true;
                   }
                   qq++;
                   ccc = mas[ccc];
               }
               if (ccc == c){
                   hasUB = true;
               }
               if (!hasUB){
                   len[l] = qq;
                   l++;
               }
           }
       }
       for (int i=1; i<=l; i++){
           for (int j=0; j<=n; j++){
               if (possible[j][i-1]){
                   possible[j + len[i - 1]][i] = true;
               }
           }
           for (int j=0; j<=n; j++){
               possible[j][i] = possible[j][i] || possible[j][i-1];
           }
       }
       for (int i=1; i<=n; i++){
           for (int j=1; j<=l; j++){
               possible[i][0] = possible[i][0] || possible[i][j];
           }
       }
       for (int i=1; i<=n; i++){
           if (possible[i][0]){
               out.println(i);
           }
       }
   }
   
}