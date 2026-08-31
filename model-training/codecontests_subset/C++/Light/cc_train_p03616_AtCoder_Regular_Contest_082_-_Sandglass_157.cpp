#include <bits/stdc++.h>
using namespace std;
int x,k,q,t,a,mx[100005],mn[100005],dt[100005],rv[100005],ans;
int main()
{
	scanf("%d%d",&x,&k);mx[0]=x;mn[0]=0;dt[0]=0;
	for(int i=1;i<=k;i++) scanf("%d",&rv[i]);
	for(int i=1;i<=k;i++)
	{
		mx[i]=mx[i-1];mn[i]=mn[i-1];int tmp=rv[i]-rv[i-1];
		if(i&1) mn[i]=max(mn[i],min(mx[i],tmp-dt[i-1])),dt[i]=max(mn[i-1]+dt[i-1]-tmp,0)-mn[i];
		else mx[i]=min(mx[i],max(mn[i],x-tmp-dt[i-1])),dt[i]=min(mx[i-1]+dt[i-1]+tmp,x)-mx[i];
	}
	for(scanf("%d",&q);q--;printf("%d\n",ans))
	{
		scanf("%d%d",&t,&a);int pos=upper_bound(rv+1,rv+k+1,t)-rv-1;
		if(a<=mn[pos]) a=mn[pos];else if(a>=mx[pos]) a=mx[pos];
		ans=a+dt[pos];int tmp=t-rv[pos];
		if(pos&1) ans=min(x,ans+tmp);else ans=max(0,ans-tmp);
	}
}