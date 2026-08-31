import java.util.*;
public class MyClass {
    public static void main(String args[]) {
      Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      while(t--!=0)
      {
          int i,j,f=0;
          int n=sc.nextInt();
          int m=sc.nextInt();
          int a[]=new int[n];
          int b[]=new int[m];
          for(i=0;i<n;i++)
          a[i]=sc.nextInt();
          for(i=0;i<m;i++)
          b[i]=sc.nextInt();
          aa:
          for(i=0;i<n;i++)
          {
              for(j=0;j<m;j++)
              {
                  if(a[i]==b[j])
                  {
                      f=1;
                      System.out.println("YES");
                      System.out.println("1 "+a[i]);
                      break aa;
                  }
              }
          }
          if(f==0)
          System.out.println("NO");
      }
    }
}