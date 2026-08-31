#include<algorithm>
#include<cstring>
#include<cstdio>
#include<cctype>
#include<vector>
#define rep(i,x,y) for(int i=x; i<=y; ++i)
#define repd(i,x,y) for(int i=x; i>=y; --i)
#define mid (l+r>>1)
#define lch (rt<<1)
#define rch (rt<<1|1)
#define pb push_back

using namespace std;
const int N=200005;
typedef long long LL;
int n;
LL a[N],f[N],g[N],D,ans;

int getint()
{
	char ch;
	while(!isdigit(ch=getchar()));
	int x=ch-48;
	while(isdigit(ch=getchar())) x=x*10+ch-48;
	return x;
}

signed main()
{
	n=getint(),D=getint();
	rep(i,1,n) a[i]=getint(),ans+=a[i];
	ans+=D*(n-1);
	f[1]=a[1];
	rep(i,2,n) f[i]=min(a[i],f[i-1]+D);
	g[n]=a[n];
	repd(i,n-1,1) g[i]=min(a[i],g[i+1]+D);
	rep(i,2,n-1) ans+=min(f[i],g[i]);
	printf("%lld\n",ans);
	return 0;
}