#include<bits/stdc++.h>
using namespace std;
inline long long getnum()
{
		long long now=0;long long fh=1;char ch=getchar();
		while(ch<'0' || ch>'9'){if(ch=='-')fh=-1;ch=getchar();}
		while(ch>='0' && ch<='9'){now=(now<<3)+(now<<1)+ch-'0';ch=getchar();}
		return now*fh;
}
int r[100003],mx[100003],mn[100003],ans,n,q,k,x,ans0[100003],ansx[100003],f,t;
int ai,ti;
int qz[100003];
int find(int t)//correct
{
	int bl=0;
	int br=k+1;
	int mid;
	while (br-bl>1)
	{
		mid=(bl+br)>>1;
		if (r[mid]>t)	br=mid;else bl=mid;

	}
	return bl;
}
int main()
{
	x=getnum();
	k=getnum();
	for (int i=1;i<=k;i++)
	{
		r[i]=getnum();
	}
	q=getnum();
	f=-1;
	ansx[0]=x;
	mx[0]=x;
	for (int i=1;i<=k;i++)
	{
		ans0[i]=ans0[i-1]+f*(r[i]-r[i-1]);
		ans0[i]=max(ans0[i],0);
		ans0[i]=min(ans0[i],x);

		ansx[i]=ansx[i-1]+f*(r[i]-r[i-1]);
		ansx[i]=max(ansx[i],0);
		ansx[i]=min(ansx[i],x);

		qz[i]=qz[i-1]+f*(r[i]-r[i-1]);

		f=-f;
	}
	f=-1;
	for (int i=1;i<=k;i++)
	{
		t+=f*(r[i]-r[i-1]);
		mn[i]=max(mn[i-1],-t);
		mx[i]=min(mx[i-1],x-t);
		f=-f;
		//printf("%d  %d %d\n",t,mn[i],mx[i]);
	}
	while(q--)
	{
	  ti=getnum();
	  ai=getnum();
	  int la=find(ti);
	  int ans;
	  if (mn[la]<=ai&&mx[la]>=ai)
	  	ans=ai+qz[la]+((la%2)*2-1)*(ti-r[la]);//la%2==1:+  ==0:-
	  else
	  	if (mn[la]>ai)
	  		ans=ans0[la]+((la%2)*2-1)*(ti-r[la]);
	  	else
	  		ans=ansx[la]+((la%2)*2-1)*(ti-r[la]);
	  ans=max(ans,0);
		ans=min(ans,x);
	  printf("%d\n", ans);
	}

}
