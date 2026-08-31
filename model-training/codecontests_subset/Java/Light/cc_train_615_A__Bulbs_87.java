import java.util.Scanner;
public class CF0615A
{
 static Scanner sIn = new Scanner(System.in);
 public static void main(String[] wieGesagt)
 {
  int n = sIn.nextInt();
  int m = sIn.nextInt();
  boolean[] ball = new boolean[m];
  int on = 0;
  for (; n > 0; n --)
  {
   int xi = sIn.nextInt();
   for (; xi > 0; xi --)
   {
    int c = sIn.nextInt();
    if (!ball[c - 1])
    {
     ball[c - 1] = true;
     on ++;
    }
   }
  }
  System.out.println((on == m) ? "YES" : "NO");
 }
}
