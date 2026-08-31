//created by Whiplash99
import java.io.*;
import java.util.*;
public class B
{
    private static void shuffleArray(int[] arr)
    {
        int n = arr.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i)
        {
            int tmp = arr[i];
            int randomPos = i + rnd.nextInt(n-i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }
    private static int bSearch(int a[], int N, int K, int i)
    {
        int l=i+1,r=N-1,mid,ans=0;
        while (l<=r)
        {
            mid=(l+r)/2;
            if(a[mid]==a[i]) l=mid+1;
            else if(a[i]+K>=a[mid])
            {
                ans=1;
                break;
            }
            else r=mid-1;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int i,N;

        String s[]=br.readLine().trim().split(" ");
        N=Integer.parseInt(s[0]);
        int K=Integer.parseInt(s[1]);

        s=br.readLine().trim().split(" ");
        int a[]=new int[N];
        for(i=0;i<N;i++) a[i]=Integer.parseInt(s[i]);

        shuffleArray(a);
        Arrays.sort(a);

        int count=N;
        for(i=0;i<N;i++)
            count-=bSearch(a,N,K,i);
        System.out.println(count);
    }
}