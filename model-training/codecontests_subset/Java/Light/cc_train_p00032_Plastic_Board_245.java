import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

  public static void main(String[] args) throws IOException
  {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    int rectanglesCount = 0;
    int lozengesCount = 0;
    while (input.ready())
    {
      String[] INPUT_STR = input.readLine().split(",");
      int a = Integer.valueOf(INPUT_STR[0]);
      int b = Integer.valueOf(INPUT_STR[1]);
      int c = Integer.valueOf(INPUT_STR[2]);

      if (isLozenges(a, b, c))
      {
        lozengesCount++;
      }
      else if (isRectangle(a, b, c))
      {
        rectanglesCount++;
      }

    }
    System.out.println(rectanglesCount);
    System.out.println(lozengesCount);

  }

  private static boolean isRectangle(int a, int b, int c)
  {
    if (a != b && Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))
    {
      return true;
    }
    return false;
  }

  private static boolean isLozenges(int a, int b, int c)
  {
    if (a == b)
    {
      return true;
    }
    return false;
  }

}