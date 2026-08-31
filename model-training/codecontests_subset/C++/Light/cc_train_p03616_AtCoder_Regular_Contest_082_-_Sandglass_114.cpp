#include<bits/stdc++.h>
#define L long long
#define pb push_back
#define pi pair<int,int>
#define pii pair<pair<int,int>,int>
#define aa first
#define bb second
#define mp make_pair
#define mpp(a,b,c) mp(mp(a,b),c)
using namespace std;
int n,m,q,x[100010],a,b,c,t;
inline void orz(int t,int k)
{
	if(k==1)
	  {
	   c+=t;
	   if(b+c>m)
	     b=m-c;
	   if(a>b)
	     a=b=0,c=m;
	  }
	else
	  {
	   c-=t;
	   if(a+c<0)
	     a=-c;
	   if(a>b)
		 a=b=c=0;
	  }
}
int main()
{
	//freopen(".in","r",stdin);
	//freopen(".out","w",stdout);
	int i,j,k,l;
	scanf("%d%d",&m,&n);
	for(i=1;i<=n;i++)
	  scanf("%d",&x[i]);
	b=m;
	k=1;
	l=-1;
	scanf("%d",&q);
	while(q--)
	  {
	   scanf("%d%d",&i,&j);
	   while(k<=n && i>=x[k])
	     {
		  orz(x[k]-t,l);
		  t=x[k];
		  l*=-1;
		  k++;
		 }
	   orz(i-t,l);
	   t=i;
	   if(j<=a)
	     printf("%d\n",a+c);
	   else if(j<=b)
	     printf("%d\n",j+c);
	   else
	     printf("%d\n",b+c);
	  }
	return 0;
}
