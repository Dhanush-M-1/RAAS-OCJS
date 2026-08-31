import java.util.*;
public class gift{
    public static void main(String agr[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count100=0,count200=0;
        int ar[]=new int[n];
        for(int i=0;i<n;i++)
        {
            ar[i]=sc.nextInt();
            if(ar[i]==100)
            count100++;
            else
            count200++;
        }
        if(n==1)
        System.out.println("NO");
        else
        {
                if(count100==0)
                {
                    if(count200%2==0)
                    System.out.println("YES");
                    else
                    System.out.println("NO");

                }
                else if(count200==0)
                {
                    if(count100%2==0)
                    System.out.println("YES");
                    else
                    System.out.println("NO");
   
                }
                else{
                    if(count100%2==0)
                    System.out.println("YES");
                    else
                     System.out.println("NO");
                }
        }
    }
}