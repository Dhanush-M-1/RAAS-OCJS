import java.util.*;
public class A
{
      public static void main(String ar[])
      {
            Scanner s=new Scanner(System.in);  int j=0;  int k=0;
            int n=s.nextInt();   int odd=0;
            int a[]=new int[n];
            for(int i=0;i<n;i++)
             a[i]=s.nextInt();
            Arrays.sort(a);
            for(int i=0;i<n;i++)
             if(a[i]%2==1)
                odd++;
             
             int b[]=new int[odd];
             int c[]=new int[n-odd];
             for(int i=0;i<n;i++)
              if(a[i]%2==0)
              { c[k]=a[i];  k++; }
              else
              { b[j]=a[i];  j++; }
              
              int even=n-odd;
              
             if(odd==even)
              System.out.println("0");
             else if(odd>even)
             {
                   int S=0;
                   for(int i=0;i<odd-even-1;i++)
                    S+=b[i];
                  System.out.println(S);
             }
             else
             {
                  int S=0;
                   for(int i=0;i<even-odd-1;i++)
                    S+=c[i];
                  System.out.println(S); 
             }
      }
} 