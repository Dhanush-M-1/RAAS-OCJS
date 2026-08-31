import java.util.*;
public class App{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while(t>0)
        {
            int n=s.nextInt();
            int m=s.nextInt();
            int[] p=new int[m];
            String str=s.next();
            for(int i=0;i<m;i++)
            {
                p[i]=s.nextInt();
            }
            int[] arr=new int[n];
            for(int i=0;i<m;i++)
            {
                arr[p[i]-1]++;
            }
            for(int i=n-1;i>0;i--)
            {
                arr[i-1]+=arr[i];
            }
            int[] ans=new int[26];
            for(int i=0;i<n;i++)
            {
                ans[str.charAt(i)-'a'] +=arr[i]+1;
            }
            for(int i=0;i<26;i++)
            {
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            
            t--;
        }

    }
   

}
