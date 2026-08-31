import java.util.*;

public class pro
{
    public static void main(String args[])
    {
      Scanner sc = new Scanner(System.in);
      int a = sc.nextInt();
      int b= sc.nextInt();
      int buc[] = new int [a];
      for(int i=0;i<a;i++)
      {
          buc[i] = sc.nextInt();
      }
      Arrays.sort(buc);
      for(int i=a-1;i>=0;i--)
      {
          if(b%buc[i]==0)
          {
              System.out.println(b/buc[i]);
              break;
          }
      }
    }
}