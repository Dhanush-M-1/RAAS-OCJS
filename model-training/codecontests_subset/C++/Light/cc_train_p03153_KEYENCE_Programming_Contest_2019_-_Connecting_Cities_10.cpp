#include<bits/stdc++.h>
using namespace std;
#define int long long
int n,m,val[200100],res;
signed main(){
	scanf("%lld%lld",&n,&m);
	for(int i=1;i<=n;i++)scanf("%lld",&val[i]);
	res+=accumulate(val+1,val+n+1,0ll);
	for(int i=2;i<=n;i++)val[i]=min(val[i],val[i-1]+m);
	for(int i=n-1;i;i--)val[i]=min(val[i],val[i+1]+m);
	printf("%lld\n",res+accumulate(val+1,val+n+1,0ll)-val[1]-val[n]+(n-1)*m);
	return 0;
}