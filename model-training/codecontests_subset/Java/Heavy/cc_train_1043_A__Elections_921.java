import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        int i,j;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int b[]=new int[n];
        int sum=0;
        int sum2=0;
        for(i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            sum+=a[i];
        }
        int max=a[0];
        for(i=0;i<n;i++)
        {
            
            if(a[i]>max)
            max=a[i];
        }
        for(j=max;j>=max;j++)
        {
            sum2=0;
            for(i=0;i<n;i++)
            {
                b[i]=a[i];
            }
            for(i=0;i<n;i++)
            {
                b[i]=j-b[i];
                sum2+=b[i];
            }
            if(sum2>sum)
            {
            break;
            }
            else
            {
                continue;
            }
        }
        System.out.println(j);
    }
}
