import java.util.*;

public class sol
{
         public static void main(String args[])
         {
                  Scanner sc=new Scanner(System.in);
                  int n=sc.nextInt();
                  int p1=1,p2=2,sp=3;
                  boolean flag=true;
                  for(int i=0;i<n;i++)
                  {
                           int k=sc.nextInt();
                           if(k==sp)
                           {
                                    flag=false;
                           }
                           if(flag)
                           {
                                    if(p1==k)
                                    {
                                             int temp=sp;
                                             sp=p2;
                                             p2=temp;
                                    }
                                    else
                                    {
                                             int temp=sp;
                                             sp=p1;
                                             p1=temp;
                                    }
                           }
                  }
                  if(flag)
                  {
                           System.out.println("YES");
                  }
                  else
                  {
                           System.out.println("NO");
                  }
         }
}