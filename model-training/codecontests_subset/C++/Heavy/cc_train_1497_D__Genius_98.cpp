#include <bits/stdc++.h>
#pragma GCC optimize(3)
#define int long long
#define ri register
#define mk make_pair
#define fi first
#define se second
#define pb push_back
#define eb emplace_back
#define is insert
#define es erase
#define vi vector<int>
#define vpi vector<pair<int,int>>
using namespace std; const int N=5010;
inline int read()
{
	int s=0, w=1; ri char ch=getchar();
	while(ch<'0'||ch>'9') { if(ch=='-') w=-1; ch=getchar(); }
	while(ch>='0'&&ch<='9') s=(s<<3)+(s<<1)+(ch^48), ch=getchar();
	return s*w;
}
int n,t[N],s[N],F[N];
signed main()
{
	for(ri int T=read();T;T--)
	{
		n=read();
		for(ri int i=1;i<=n;i++) t[i]=read();
		for(ri int i=1;i<=n;i++) s[i]=read();
		memset(F,0,sizeof(F));
		for(ri int i=1;i<=n;i++)
		{
			for(ri int j=i-1;j;j--)
			{
				if(t[i]==t[j]) continue;
				int x=F[i], y=F[j];
				F[i]=max(F[i],y+abs(s[i]-s[j]));
				F[j]=max(F[j],x+abs(s[i]-s[j]));
			}
		}
		int ans=0;
		for(ri int i=1;i<=n;i++) ans=max(ans,F[i]);
		printf("%lld\n",ans);
	}
	return 0;
}