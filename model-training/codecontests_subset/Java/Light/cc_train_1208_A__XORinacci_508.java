import java.util.*;
import java.io.*;

public class HelloWorld
{
  public static void main(String[] args) throws Exception
  {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    while(T-- > 0)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long a = Long.parseLong(st.nextToken());
      long b = Long.parseLong(st.nextToken());
      long n = Long.parseLong(st.nextToken());
      if(n%3 == 0) System.out.println(a);
      else if(n%3 == 1) System.out.println(b);
      else if(n%3 == 2) System.out.println(a^b);
    }
  }
}
