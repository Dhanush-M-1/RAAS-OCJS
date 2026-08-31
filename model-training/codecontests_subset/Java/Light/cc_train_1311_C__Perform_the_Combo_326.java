import java.util.*;
import java.io.*;
public class rc1{
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t--!=0){
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]),m = Integer.parseInt(str[1]),i;
            String s = br.readLine().trim();
            String s1[] = br.readLine().trim().split(" ");
            int arr[] = new int[m];
            for(i=0; i<m; i++)
                arr[i] = Integer.parseInt(s1[i]);
            int ans[] = new int[n];
            int a[] = new int[26];
            Arrays.fill(ans, 0);
            Arrays.fill(a, 0);
            for(i=0; i<m; i++)
                ++ans[arr[i]-1];
            for(i=n-2; i>=0; --i)
                ans[i] += ans[i+1];
            for(i=0; i<n; i++)
                ans[i]++;
            for(i=0; i<n; i++)
                a[s.charAt(i)-97] += ans[i];
            for(i=0; i<26; i++)
                System.out.print(a[i]+" ");
            System.out.println();
        }
    }
}