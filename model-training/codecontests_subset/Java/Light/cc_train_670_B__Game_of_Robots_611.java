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
      
      int i=1;
      while(k-i>0)
      {
          k=k-i;
          i++;
      }
    
      System.out.println(a[k-1]);
    }
}