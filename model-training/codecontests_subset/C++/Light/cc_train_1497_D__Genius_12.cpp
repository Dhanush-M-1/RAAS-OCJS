#include <cstdio>
#include <algorithm>

using namespace std;
typedef long long ll;
const int MAXN = 5005;

int n, tag[MAXN], s[MAXN];
ll dp[MAXN];

void solve(){
	scanf("%d",&n);
	for(int i = 1 ; i <= n ; ++i) scanf("%d",&tag[i]);
	for(int i = 1 ; i <= n ; ++i) scanf("%d",&s[i]);
	for(int i = 1 ; i <= n ; ++i) dp[i] = 0;
	for(int i = 2 ; i <= n ; ++i){
		for(int j = i - 1 ; j ; --j){
			if(tag[i]==tag[j]) continue;
			ll dpi = dp[i], dpj = dp[j], p = abs(s[i]-s[j]);
			dp[i] = max(dp[i],dpj+p);
			dp[j] = max(dp[j],dpi+p);
		}
	}
	printf("%lld\n",*max_element(dp+1,dp+1+n));
}

int main(){
	int t;
	scanf("%d",&t);
	while(t--) solve();
}