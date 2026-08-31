#include<cstdio>
#include<cstdlib>
#include<cstring>
#include<iostream>
using namespace std;
int X,k,q,t1=0,t2=1,f=-1,Max,Min=0,now=0,p=0,ans;
int t[100010],a[100010],r[100010];
int main()
{
	scanf("%d %d",&X,&k);
	for(int i=1;i<=k;i++) scanf("%d",&r[i]);
	scanf("%d",&q);
	for(int i=1;i<=q;i++) scanf("%d %d",&t[i],&a[i]);
	Max=X;
	while(t2<=q)
	{
		if(t[t2]>r[t1+1]&&t1<k)
		{
			t1++;
			now=f*(r[t1]-r[t1-1]);
			Max=max(0,min(X,Max+now));
			Min=max(0,min(X,Min+now));
			f*=-1;p+=now;
		}
		else
		{
			ans=max(Min,min(Max,a[t2]+p));
			ans=max(0,min(X,ans+f*(t[t2]-r[t1])));
			printf("%d\n",ans);t2++;
		}
	}
}