import java.util.*;
import java.io.*;

public class c {
   public static void main(String[] Args) 
      throws Exception
   {
      FS sc = new FS(System.in);
      long t = sc.nextLong();
      long ans = 1;
      while(ans * ans < t)
         ans++;
      while (true){
         if (t % ans == 0 && gcd(t/ans, ans) == 1)
         {
            System.out.println(ans +" " +(t/ans));
            return;
         }
         ans--;
      }
   }

   public static long gcd(long a, long b) {
      return (b == 0) ? a : gcd(b, a % b);
   }

   public static class FS {
      StringTokenizer st;
      BufferedReader br;

      FS(InputStream in)
         throws Exception
      {
         br = new BufferedReader(new InputStreamReader(in));
         st = new StringTokenizer(br.readLine());
      }

      String next()
         throws Exception
      {
         if (st.hasMoreTokens())
            return st.nextToken();
         st = new StringTokenizer(br.readLine());
         return next();
      }

      int nextInt()
         throws Exception
      {
         return Integer.parseInt(next());
      }
      long nextLong()
         throws Exception
      {
         return Long.parseLong(next());
      }
   }
}
