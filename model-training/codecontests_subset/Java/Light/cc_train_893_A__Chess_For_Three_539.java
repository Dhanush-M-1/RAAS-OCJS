import java.util.*;
public class Main
{
          public static void main(String[] args)
          {
                    Scanner sc = new Scanner(System.in);
                    int n = sc.nextInt();
                    int first = 1, second = 2;
                    boolean flag = false;
                    for(int i = 0 ; i<n ; i++)
                    {
                              int x = sc.nextInt();
                              if(x==first)
                              {
                                        second = first^second;
                              }
                              else if (x == second)
                              {
                                        first  = first^second; 
                              }
                              else
                                        flag = true;
                    }
                    if(flag) System.out.println("NO");
                    else      System.out.println("YES");
          }
}