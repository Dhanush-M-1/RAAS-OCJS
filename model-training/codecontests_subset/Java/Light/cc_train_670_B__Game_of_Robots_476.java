import java.util.*;
public class gameofrobots
{
  public static void main(String args[])
  {
     Scanner in=new Scanner(System.in);
     int n=in.nextInt();
     long k=in.nextLong();
     int i,p=1,d=0;long k1=0;
     int a[]=new int[n];
     for(i=0;i<n;i++)
        a[i]=in.nextInt();
     if(k==1)
     {
         System.out.println(a[0]);
         System.exit(0);
        }
     do
     {
         k1=k1+p;
         p=p+1;
     }while(k1<k);
     if(k1==k)
       System.out.println(a[p-2]);
     else
     {
         k1=k1-(p-1);
         d=(int)(k-k1);
         System.out.println(a[d-1]);
        }
    }
}