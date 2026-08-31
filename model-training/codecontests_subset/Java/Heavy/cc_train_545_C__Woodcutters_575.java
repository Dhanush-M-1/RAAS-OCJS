
import java.util.*;

public class finit
{
static class p{
	int x;int h;
	p(int x,int h){
		this.x=x;this.h=h;
	}
}
static class sort implements Comparator<p>{
	public int compare(p p1,p p2) {
		return p1.x-p2.x;
	}
}
public static void main(String args[]) {
	Scanner s=new Scanner(System.in);

int n=s.nextInt();
if(n==1) {
	System.out.println(1);
	return;
}
if(n==2) {
	System.out.println(2);
	return;
}
ArrayList<p> a=new ArrayList<>();
for(int i=0;i<n;i++)
	a.add(new p(s.nextInt(),s.nextInt()));
int dp[][]=new int[n][3];
Collections.sort(a,new sort());
for(int i=0;i<n;i++)
	for(int j=0;j<=2;j++)
		dp[i][j]=-1;

int ans=2+ans(dp,n,1,0,a);
System.out.println(ans);
    
}
public static int ans(int dp[][],int n,int i,int j,ArrayList<p> a) {
	if(i==n-1)
		return 0;
	if(dp[i][j]!=-1)
		return dp[i][j];
	int max=Integer.MIN_VALUE;
	if(j==0) {
		int tt=a.get(i).x-a.get(i).h-a.get(i-1).x;
		if(tt>0)
			max=Math.max(max,ans(dp,n,i+1,0,a)+1);
		int yy=a.get(i+1).x-a.get(i).x-a.get(i).h;
		if(yy>0)
			max=Math.max(max,ans(dp,n,i+1,1,a)+1);
		max=Math.max(max,ans(dp,n,i+1,2,a));
	}
	else if(j==1){
		int tt=a.get(i).x-a.get(i).h-a.get(i-1).x-a.get(i-1).h;
		if(tt>0)
			max=Math.max(max,ans(dp,n,i+1,0,a)+1);
		int yy=a.get(i+1).x-a.get(i).x-a.get(i).h;
		if(yy>0)
			max=Math.max(max,ans(dp,n,i+1,1,a)+1);
		max=Math.max(max,ans(dp,n,i+1,2,a));
		
	}
	else {
		int tt=a.get(i).x-a.get(i).h-a.get(i-1).x;
		if(tt>0)
			max=Math.max(max,ans(dp,n,i+1,0,a)+1);
		int yy=a.get(i+1).x-a.get(i).x-a.get(i).h;
		if(yy>0)
			max=Math.max(max,ans(dp,n,i+1,1,a)+1);
		max=Math.max(max,ans(dp,n,i+1,2,a));
		
	}
	dp[i][j]=max;
	return dp[i][j];
	
}
}

