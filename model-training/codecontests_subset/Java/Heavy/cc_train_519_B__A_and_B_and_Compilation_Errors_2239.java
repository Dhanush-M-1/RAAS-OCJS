import java.io.*;
import java.util.StringTokenizer;
public class CF0519B
{
 public static void main(String[] helloWorld) throws IOException
 {
  BufferedReader sIn = new BufferedReader(new InputStreamReader(System.in));
  int n = Integer.parseInt(sIn.readLine());
  StringTokenizer sT = new StringTokenizer(sIn.readLine());
  int x1 = 0;
  for (int i = 0; i < n; i ++)
   x1 ^= Integer.parseInt(sT.nextToken());
  sT = new StringTokenizer(sIn.readLine());
  int x2 = 0;
  for (int i = 1; i < n; i ++)
  {
   int c = Integer.parseInt(sT.nextToken());
   x1 ^= c;
   x2 ^= c;
  }
  sT = new StringTokenizer(sIn.readLine());
  for (int i = 2; i < n; i ++)
   x2 ^= Integer.parseInt(sT.nextToken());
  System.out.println(x1);
  System.out.println(x2);
 }
}
