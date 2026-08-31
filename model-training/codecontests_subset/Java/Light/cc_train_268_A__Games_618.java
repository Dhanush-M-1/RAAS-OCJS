import java.util.Scanner;
public class cf268A
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(), res = 0;
    int[] hi = new int[n], ai = new int[n];
    for(int i = 0; i < n; i ++)
    {
      hi[i] = sc.nextInt();
      ai[i] = sc.nextInt();
    } // for
    for(int i = 0; i < n; i ++)
      for(int j = 0; j < n; j ++)
      {
        if(i != j && hi[i] == ai[j])
          res ++;
      } // for
    System.out.println(res);
  } // main  
} // class cf268A 