import java.util.*;
public class b609 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        long a[]=new long[m+1];
        for(int i=1;i<=n;i++)
            a[sc.nextInt()]++;
         long sum=0;
        for(int i=1;i<m;i++)
            for(int j=i+1;j<m+1;j++)
                sum+=a[i]*a[j];
        System.out.println(sum);
    }
}
