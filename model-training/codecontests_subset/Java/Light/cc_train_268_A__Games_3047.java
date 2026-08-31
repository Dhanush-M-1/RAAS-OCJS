import java.util.Scanner;
public class Football
{
    public static void main(String arg[]) {
       Scanner in=new Scanner(System.in);
       int n,j=0;
        n=in.nextInt();
       int[] a=new int[n];
       int[] h=new int[n];
      
     
           for(int i=0;i<n;i++)
       {
           a[i]=in.nextInt();
           h[i]=in.nextInt();
       }
           j=0;
       for(int i=0;i<n;i++)
       {
           for(int k=0;k<n;k++)
           {
               if(h[i]==a[k]) {
                   j++;
               }
           }
       }
       System.out.print(j);
    }
}
