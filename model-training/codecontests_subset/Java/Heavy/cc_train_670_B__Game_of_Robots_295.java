import java.util.*;
public class S {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=1;
        while(t--!=0)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++) a[i]=sc.nextInt();
            int sum=0;
            int v=0;
            for(int i=0;i<n;i++)
            {
                sum=sum+(i+1);
                v=i+1;
                if(sum>=k) break;
            }
            sum=sum-v;
            int res=0;
            for(int i=0;i<v;i++)
            {
                sum++;
                if(sum==k)
                {
                    res=a[i];
                    break;
                }
            }
            System.out.println(res);
        }
    }

}