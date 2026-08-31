import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class Compilation {
    public static void main(String[] args) throws IOException {
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         String brr[]=br.readLine().trim().split(" ");
         int n=Integer.parseInt(brr[0]);
         int arr[]=new int[n];
         int crr[]=new int[n-1];
         int drr[]=new int[n-2];
         int i,ans1=-1,ans2=-1;
         brr=br.readLine().trim().split(" ");
         for(i=0;i<n;i++)
             arr[i]=Integer.parseInt(brr[i]);
         Arrays.sort(arr);
         brr=br.readLine().trim().split(" ");
         for(i=0;i<n-1;i++)
             crr[i]=Integer.parseInt(brr[i]);
         Arrays.sort(crr);
         for(i=0;i<n-1;i++)
         {
             if(crr[i]!=arr[i])
             {
                 ans1=arr[i];
                 break;
         }
         }
         if(ans1==-1)
             ans1=arr[n-1];
             
         System.out.println(ans1);
         brr=br.readLine().trim().split(" ");
         for(i=0;i<n-2;i++)
             drr[i]=Integer.parseInt(brr[i]);
         Arrays.sort(drr);
         for(i=0;i<n-2;i++)
         {
             if(crr[i]!=drr[i])
             {
                 ans2=crr[i];
                 break;
         }
             
             
         }
         if(ans2==-1)
             ans2=crr[n-2];
         System.out.println(ans2);
         
         
         
         
    }
}