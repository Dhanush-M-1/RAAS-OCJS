import java.util.*;

public class Main 
{
  public static void main(String args[])
  {
    Scanner s=new Scanner(System.in);
    int n=s.nextInt();
    int a=s.nextInt();
    int b=s.nextInt();
    int c=s.nextInt();
    int i,j,k;
    int res=0;
    for (i = 0; i <= c; i++) {
        for (j = 0; j <= b; j++) {
            k = 2*n - 4*i - 2*j;
            if (0 <= k && k <= a) res++;
        }
        }
    System.out.println(res);
    }
}