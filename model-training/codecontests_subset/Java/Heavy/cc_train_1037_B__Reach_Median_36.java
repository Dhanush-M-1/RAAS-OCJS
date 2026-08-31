import java.util.*;

public class test
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = sc.nextLong();
        long arr[] = new long[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        int mid;
        long sum=0;
        int left=0;
        int k=0;
        int right=n-1;

        if(s<arr[0])
        {
            for(int i=0;i<=n/2;i++)
            {
                sum+=Math.abs(s-arr[i]);
            }
            System.out.println(sum);
            return;
        }


        while(left<=right)
        {
            
            mid = (left+right)/2;
            if(arr[mid]==s)
            {
                k=mid;
                break;
            }
            else if(arr[mid]>s)
            {
                right = mid-1;
            }
            else if(arr[mid]<s)
            {
                k=mid;
                left = mid+1;
            }
        }
        // System.out.println("k: "+k);
       
        if(arr[k]==s)
        {
            if(k>=n/2)
            {
                for(int i=n/2;i<=k;i++)
                {
                    sum+=Math.abs(s-arr[i]);
                }
            }
            else
            {
                for(int i=k+1;i<=n/2;i++)
                {
                    sum+=Math.abs(s-arr[i]);
                }
            }
        }
        else
        {
            if(k>=n/2)
            {
                for(int i=n/2;i<=k;i++)
                {
                    sum+=Math.abs(s-arr[i]);
                }
            }
            else
            {
                for(int i=k+1;i<=n/2;i++)
                {
                    sum+=Math.abs(s-arr[i]);
                }
            }
        }
        System.out.println(sum);
    }
}