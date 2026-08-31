#include<bits/stdc++.h>
#define int long long
using namespace std;
const int NR=5005;
void Min(int& x,int y){x=min(x,y);}
void Max(int& x,int y){x=max(x,y);}
int read()
{
	int x=0,f=1;char ch=getchar();
	while(ch>'9'||ch<'0'){if(ch=='-')f=-1;ch=getchar();}
	while(ch<='9'&&ch>='0'){x=(x<<3)+(x<<1)+(ch^48);ch=getchar();}
	return x*f;
}
int n;
int tag[NR],s[NR];
int dp[NR];
void work()
{
	memset(dp,0,sizeof(dp));
	n=read();
	for(int i=1;i<=n;i++)tag[i]=read();
	for(int i=1;i<=n;i++)s[i]=read();
	for(int i=1;i<=n;i++)for(int j=i-1;j>=1;j--){
		if(tag[i]!=tag[j]){
			int tmp=dp[i];
			Max(dp[i],dp[j]+abs(s[i]-s[j]));
			Max(dp[j],tmp+abs(s[i]-s[j]));
		}
	}int ans=0;
	for(int i=1;i<=n;i++)Max(ans,dp[i]);
	printf("%lld\n",ans);
}
signed main()
{
//	freopen("1.in","r",stdin);
//	freopen("1.out","w",stdout);
	int T=read();while(T--)work();
	return 0;
}
