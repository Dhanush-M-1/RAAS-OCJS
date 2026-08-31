import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class MafiaCF {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        String st[]=br.readLine().split(" ");
        double sum=0;
        long max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st[i]);
            sum+=arr[i];
            if(arr[i]>max)
                max=arr[i];
        }
        long left=max,right= (long) (2*1e9);
        long ans=0;
        while (left<=right){
            long mid=left+(right-left)/2;
            if(helper(sum,n,mid)){
                right=mid-1;
                ans=mid;
            }else
                left=mid+1;
        }
        System.out.println(ans);
    }

    private static boolean helper(double sum, long n, long mid) {
        if(mid<=n*mid-sum) return true;
        return false;
    }
}
