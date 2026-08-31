import java.util.*;
public class MyClass 
{
    public static void main(String args[]) 
    {
      int i,j,a,b,n,T,c=0;
      Scanner ob=new Scanner(System.in);
      T=ob.nextInt();
      for(i=0;i<T;i++)
      {
          a=ob.nextInt();
          b=ob.nextInt();
          n=ob.nextInt();
          if(n==0)
            c=a;
          else if(n==1)
            c=b;
          else
          {n=n%3;
            
            if(n==0)
            c=a;
          else if(n==1)
            c=b;
            else
             c=a^b;
          }
          System.out.println(c);
      }
    }
}