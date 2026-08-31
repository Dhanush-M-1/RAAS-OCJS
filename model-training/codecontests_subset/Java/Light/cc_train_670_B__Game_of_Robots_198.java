import java.util.*;
public class Main
{
public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int k = in.nextInt();
      int a[] = new int[n];
      for(int i=0 ; i<n ; i++) a[i]=in.nextInt();
      int p=1 , flag=0 , ans=-1;
      int i=1;
      while(p+i<=k)
      {
          p+=i;
          i++;
      }
     // System.out.println(p);
      for(i=0 ; i<n ; i++)
      {
          if(p==k)
          {
              ans=i;
              break;
          }
          p++;
      }
      System.out.println(a[ans]);
    }
}