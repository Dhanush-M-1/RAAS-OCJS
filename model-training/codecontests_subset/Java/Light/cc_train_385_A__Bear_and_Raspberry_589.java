import java.util.*;
public class bearandraspberry
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        int i,max=0;
        for(i=0;i<n;i++)
         a[i]=in.nextInt();
        for(i=0;i<n-1;i++)
        { 
            b[i]=a[i]-a[i+1]-m;
            if(b[i]>max)
              max=b[i];
        }
        System.out.println(max);
    }
}