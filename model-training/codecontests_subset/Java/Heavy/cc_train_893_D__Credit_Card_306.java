import java.util.HashMap;
import java.util.*;
import java.util.Map;
public class App {

    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
       int n=in.nextInt();
       long arr[]=new long[100005],mx=0,mn=0,ans=0, d = in.nextLong();
       boolean b=false;
       for(int i=0;i<n;i++)
       {
           arr[i]=in.nextInt();
           if(arr[i]!=0)
           {
               mn+=arr[i]; mx+=arr[i];
               if(mn>d)
                   b=true;
               mx=Math.min(mx,d);
           }
           else
           {
               if(mx>=0)
               {
                   mn=Math.max(mn,0);
               }
               else
               {
                   ans++;
                   mn=0;
                   mx=d;
               }
           }
       }

        if(b==true)
       {
           System.out.println(-1);
       }
       else
           System.out.println(ans);
    }
}
