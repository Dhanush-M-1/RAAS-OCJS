import java.util.*;
public class Main
{
     public static void main(String args[])
     {
          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          long m = sc.nextLong();
          long a[] = new long[n];
          long b[] = new long[n];
          for(int i=0;i<n;i++)
          {
               a[i] = sc.nextLong();
          }
          for(int i=0;i<n;i++)
          {
               b[i] = sc.nextLong();
          }
          Arrays.sort(a);
          Arrays.sort(b);
          long min = Long.MAX_VALUE;
          for(int i=0;i<n;i++)
          {
              long diff = (b[0]-a[i]+m)%m;
              long temp[] = new long[n];
              for(int j=0;j<n;j++)
              {
                  temp[j] = (a[j]+diff)%m;
              }
              Arrays.sort(temp);
              if(Arrays.equals(b,temp))
              {
                  min = Math.min(min,diff);
              }
          }
          System.out.println(min);
     }
}