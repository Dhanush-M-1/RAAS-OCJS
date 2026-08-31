#include<cstdio>
#include<algorithm>
#include<cstdlib>
using namespace std;
int X,n,r[100010],Q,delta[100010],num0[100010],numx[100010],t[100010],a[100010];
int main()
{
	scanf("%d%d",&X,&n);
	for(int i=1;i<=n;i++)scanf("%d",&r[i]);
	scanf("%d",&Q);
	for(int i=1;i<=Q;i++)scanf("%d%d",&t[i],&a[i]);
	delta[0]=0;
	num0[0]=0;
	numx[0]=X;
	for(int i=1;i<=n;i++)
	{
		num0[i]=num0[i-1];
		numx[i]=numx[i-1];
		if(i&1)
		{
//			delta[i]=delta[i-1]-r[i]+r[i-1];
			num0[i]=max(num0[i],min(r[i]-r[i-1]-delta[i-1],numx[i]));
			delta[i]=max(delta[i-1]+num0[i-1]-r[i]+r[i-1],0)-num0[i];
		}
		else
		{
//			delta[i]=delta[i-1]+r[i]-r[i-1];
			numx[i]=min(numx[i],max(X-r[i]+r[i-1]-delta[i-1],num0[i]));
			delta[i]=min(delta[i-1]+numx[i-1]+r[i]-r[i-1],X)-numx[i];
		}
	}
	for(int i=1;i<=Q;i++)
	{
		int place=upper_bound(r+1,r+n+1,t[i])-r-1,ans=delta[place];
		if(a[i]<=num0[place])ans+=num0[place];
		else if(a[i]>=numx[place])ans+=numx[place];
		else ans+=a[i];
		if(place&1) ans=min(X,ans+t[i]-r[place]);
        else ans=max(0,ans-t[i]+r[place]);
        printf("%d\n",ans);
	}
	return 0;
}