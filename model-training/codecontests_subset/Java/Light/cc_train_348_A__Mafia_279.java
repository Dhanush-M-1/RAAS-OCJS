import java.util.*;
import java.lang.Math;
public class A348{
    public static int n;
    public static long[] a;
    public static long dp(int x,int k,long u){
	long ans=0;
	if (x<n-1 && a[x]==a[x+1])ans=dp(x+1,k+1,u);else
	    if (k==1)ans=a[x+1]-a[x]+dp(x+1,k+1,a[x+1]-a[x]);else
	    {
		long xx;
		long y = ((a[x]-u)*k)/(k-1);
		if(((a[x]-u)*k)%(k-1)!=0)y++;
		if (x<n-1)xx = k*(a[x+1]-a[x]);else xx=y+1;
		if (xx<y)ans=xx+dp(x+1,k+1,u+xx);else ans=y+Math.max(a[n-1]-u-y,0);
	    }
	return ans;
    }
    public static void main(String[] agrs){
	Scanner f = new Scanner(System.in);
	n=f.nextInt();
	a= new long[n];
	for(int i=0;i<n;i++)a[i]=f.nextInt();
	Arrays.sort(a);
	long res=0;
	res=dp(0,1,0);
	System.out.println(res);
    }
}
