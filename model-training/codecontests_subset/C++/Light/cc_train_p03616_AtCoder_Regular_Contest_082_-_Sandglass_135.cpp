#include<iostream>
#include<cstdio>
#include<cstring>
#include<algorithm>
using namespace std;
const int maxn=100100;
int x,k,q,r[maxn],mx[maxn],mi[maxn],c[maxn];
int main()
{
	scanf("%d%d",&x,&k);
	for(int i=1;i<=k;i++)
		scanf("%d",&r[i]);
	mx[0]=x;
	r[0]=mi[0]=c[0]=0;
	for(int i=1;i<=k;i++)
	{
		mx[i]=mx[i-1];mi[i]=mi[i-1];
		if(i&1)
		{
			mi[i]=max(mi[i],min(r[i]-r[i-1]-c[i-1],mx[i]));
			c[i]=max(c[i-1]+mi[i-1]-r[i]+r[i-1],0)-mi[i];
		}
		else
		{
			mx[i]=min(mx[i],max(x-r[i]+r[i-1]-c[i-1],mi[i]));
			c[i]=min(c[i-1]+mx[i-1]+r[i]-r[i-1],x)-mx[i];
		}
		//cout<<mi[i]<<' '<<mx[i]<<' '<<c[i]<<endl;	
	}		
	
	scanf("%d",&q);
	for(int i=1;i<=q;i++)	
	{
		int t,a;
		scanf("%d%d",&t,&a);
		int pl=upper_bound(r+1,r+k+1,t)-r-1,ans=c[pl];
		//cout<<"pl:"<<pl<<endl;
		if(a<=mi[pl]) ans+=mi[pl];
		else if(a>=mx[pl]) ans+=mx[pl];
		else ans+=a;
		if(pl&1) ans=min(x,ans+t-r[pl]);
		else ans=max(0,ans-t+r[pl]);
		printf("%d\n",ans);		
	}	
	return 0;
} 