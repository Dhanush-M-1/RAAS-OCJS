import java.io.*;
import java.util.*;
public class Main
{
    public static void main(String[] args) throws IOException
    {

    	BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int burned = 0;
      int count = 0;
      while(a > 0)
      {
         burned += a;
         count += a;
         a = 0;
         a += burned / b;
         burned -= (burned / b) * b;
      }
      System.out.println(count);
   }
}