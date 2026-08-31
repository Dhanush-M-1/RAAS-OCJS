import java.util.*;
public class Main{

     public static void main(String []args){
        int n;
        int[] a= new int[105];
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        int sum=0,mx=-1;
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            sum+=a[i];
            mx= Math.max(mx,a[i]);
        }
        int ans=1;
        while(ans*n-sum <=sum)
        {
            ans++;
        }
        System.out.println(Math.max(ans,mx));
     }
    
}