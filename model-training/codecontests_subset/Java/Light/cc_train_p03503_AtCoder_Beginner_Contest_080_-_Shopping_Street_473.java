
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

  public static void main(String[] args) throws IOException
  {
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in), 1);
    int n = Integer.parseInt(r.readLine());

    boolean[][] f = new boolean[101][11];
    int[][] p = new int[101][11];

    for (int i = 0; i < n; i++)
    {
      String[] ls = r.readLine().split("[\\s]+");
      for (int j = 0; j < 10; j++)
      {
        f[i][j] = (Integer.parseInt(ls[j]) == 1);
      }
    }

    for (int i = 0; i < n; i++)
    {
      String[] ls = r.readLine().split("[\\s]+");
      for (int j = 0; j < 10; j++)
      {
        p[i][j] = Integer.parseInt(ls[j]);
      }
    }

    int max = Integer.MIN_VALUE;

    for (int s = 1; s <= 1023; s++)
    {
      int[] de = new int[101];
      for (int i = 0; i < n; i++)
      {
        de[i] = 0;
        for (int j = 0; j < 10; j++)
        {
          if (f[i][j] && (((s >> j) & 1) == 1))
          {
            de[i]++;
          }
        }
      }

      int pro = 0;
      for (int i = 0; i < n; i++)
      {
        pro += p[i][de[i]];
      }
      max = Integer.max(max, pro);
    }

    System.out.println(max);
  }

}
