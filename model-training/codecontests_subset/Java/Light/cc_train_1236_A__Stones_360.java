import java.util.*;
import java.io.*;

public class HelloWorld
{

  public static void main(String[] args) throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(System.out);
    int T = Integer.parseInt(br.readLine());
    while(T-- > 0)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] A = new int[3];
      A[0] = Integer.parseInt(st.nextToken());
      A[1] = Integer.parseInt(st.nextToken());
      A[2] = Integer.parseInt(st.nextToken());

      if(A[2] >= 2*A[1]) writer.println(3*A[1]);
      else
      {
        int sum = 0;
        int temp = A[2]/2;
        sum += 3*temp;
        A[1] -= temp;
        if(A[1] >= 2*A[0]) sum += 3*A[0];
        else
        {
          temp = A[1]/2;
          sum += 3*temp;
        }
        writer.println(sum);
      }
    }
    br.close();
    writer.close();
  }

}
