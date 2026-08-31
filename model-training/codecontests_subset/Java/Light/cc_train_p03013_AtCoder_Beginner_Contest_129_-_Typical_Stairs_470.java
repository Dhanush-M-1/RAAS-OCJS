import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        boolean[] navail=new boolean[n+1];
        for(int i=0;i<m;i++){
            navail[sc.nextInt()]=true;
        }
        int mod=1000000007;
        long[] ans=new long[n+1];
        ans[0]=1;
        if(!navail[1])ans[1]=1;
        for(int i=2;i<n+1;i++){
            if(navail[i])continue;
            ans[i]=ans[i-1]+ans[i-2];
            ans[i]%=mod;
        }
        System.out.println(ans[n]);
    }
}