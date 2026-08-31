import java.io.*;
import java.util.*;

public class modulo_equality {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String inp[] = in.readLine().split("\\s+");
        int n = Integer.parseInt(inp[0]);
        long m = Long.parseLong(inp[1]);
        String[] a_arr = in.readLine().split("\\s+");
        String[] b_arr = in.readLine().split("\\s+");
        int[] a=new int [n];
        int[] b=new int [n];
        for (int i=0;i<n;i++)
            a[i]=Integer.parseInt(a_arr[i]);
        for (int i=0;i<n;i++)
            b[i]=Integer.parseInt(b_arr[i]);
        Arrays.sort(b);
        Arrays.sort(a);
        long min=m+1,ans=0;
        for(int i=0;i<n;i++){
            ans=(b[0]-a[i]+m)%m;
            int f = 1;
            for(int j=1;j<n;j++){
                if ((a[(i+j)%n]+ans)%m!=b[j])
                    f = 0;
            }
            if(f==1)
                min=Math.min(ans,min);
        }
        System.out.println(min);
    }
}


