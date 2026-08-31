import java.util.Scanner;
public class Cf
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    int[] a = new int[m];
    for(int i = 1; i<=n; i++)
    {
      int l = scan.nextInt();
      a[l-1]++;
    }
    int result = 0;
    for(int i = 1; i <= m; i++)
    {
      for(int j = i+1; j<=m; j++)
        result = result + a[i-1]*a[j-1];
    }
    System.out.print(result);
  }
  
}