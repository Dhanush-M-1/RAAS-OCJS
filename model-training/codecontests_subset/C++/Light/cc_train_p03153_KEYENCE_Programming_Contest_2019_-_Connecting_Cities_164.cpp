#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef unsigned long long ull;
typedef pair<int,int> ii;
typedef pair<ll,ll> pll;
#define F first
#define S second
#define RE register
#define random(x) (rand()%x)
#define LOG(a,b) (log(a)/log(b))
#define N 200005
#define mod 998244353
#define INF 0x3f3f3f3f
#define LINF 0x3f3f3f3f3f3f3f3fll
int n;
ll d,a[N],ans=0,dpl[N],dpr[N];
int main(){
	scanf("%d%lld",&n,&d);
	for(int i=1;i<=n;++i){
		scanf("%lld",a+i);
		ans+=a[i];
	}
	ans+=d*(n-1);
	dpl[1]=a[1];
	for(int i=2;i<=n;++i) dpl[i]=min(dpl[i-1]+d,a[i]);
	dpr[n]=a[n];
	for(int i=n-1;i;--i) dpr[i]=min(dpr[i+1]+d,a[i]);
	for(int i=2;i<n;++i) ans+=min(dpl[i],dpr[i]);
	printf("%lld\n",ans);
	return 0;
}