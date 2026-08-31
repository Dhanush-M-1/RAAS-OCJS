import java.util.*;
public class Main{
    public static void main(String aefs[])
    {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=scan.nextInt();
            b[i]=scan.nextInt();
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i]==b[j])
                    count++;
            }
        }
        System.out.println(count);
    }
}