#include<iostream>
#include<cstdlib>
#include<cstdio>
#include<algorithm>
#include<cstring>
#include<random>
#include<ctime>
#include<vector>
#include<cmath>
#include<unordered_map>
using namespace std;
typedef long long ll;
typedef unsigned long long ull;
const int N=1e6+5,N2=20;
const ll INF=1e18+5;
inline ll read()
{
	ll sum=0,fh=1;
	char c=getchar();
	while(c<'0'||c>'9')
	{
		if(c=='-')fh=-1;
		c=getchar();
	}
	while(c>='0'&&c<='9')
	{
		sum=sum*10+c-'0';
		c=getchar();
	}
	return sum*fh;
}
inline int read2(int *a)
{
	int x=0;
	char c=getchar();
	while(c<'a'||c>'z')c=getchar();
	while(c>='a'&&c<='z')
	{
		a[++x]=c;
		c=getchar();
	}
	return x;
}
inline void write(ll x)
{
	if(x<0)putchar('-'),x=-x;
	if(x>9)write(x/10);
	putchar(x%10+'0');
}
inline int gcd(int x,int y)
{
	return y==0?x:gcd(y,x%y);
}
inline int ab(int x)
{
	return x<0?-x:x;
}
#define pi pair<int,int>
int fa[N];
inline int fifa(int x)
{
	return x==fa[x]?x:fa[x]=fifa(fa[x]);
}
int a[N]={0};
int ans[N],js=0;
pi c[N];
int main()
{
	//freopen("qwq.txt","r",stdin);
	int n=read(),m=read();
	for(int i=1;i<=m+1;++i)fa[i]=i;
	for(int i=1;i<=n;++i)
	{
		int k=read();
		int x=read(),y=(k==2?read():m+1);
		if(x>y)swap(x,y);
		if(!a[x])
		{
			a[x]=i;
			ans[++js]=i;
			fa[x]=y;
		}
		else
		{
			int x2=fifa(c[a[x]].first);
			if(x2!=y)
			{
				x=x2;
				if(x>y)swap(x,y);
				if(!a[x])
				{
					a[x]=i;
					ans[++js]=i;
					fa[x]=y;
				}
				else
				{
					int x2=fifa(c[a[x]].first);
					if(x2!=y)
					{
						x=x2;
						if(x>y)swap(x,y);
						if(x!=m+1&&!a[x])
						{
							a[x]=i;
							ans[++js]=i;
							fa[x]=y;
						}
					}
					
				}
			}
		}
		c[i]=pi(x,y);
	}
	int sum=1,p=1e9+7;
	for(int i=1;i<=js;++i)
	{
		sum=(sum*2)%p;
	}
	cout<<sum<<" "<<js<<endl;
	for(int i=1;i<=js;++i)
	{
		write(ans[i]),putchar(' ');
	}
}
