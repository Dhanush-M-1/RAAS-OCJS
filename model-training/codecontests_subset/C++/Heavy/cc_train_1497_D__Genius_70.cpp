#include<bits/stdc++.h>
#define ll long long
#define x first
#define y second
using namespace std;
const int maxn = 5000 + 7;
ll n,a[maxn],b[maxn],dp[maxn];
void solve() {
	scanf("%lld",&n);
	for (int i=1; i<=n; ++i) scanf("%lld",&a[i]);
	for (int i=1; i<=n; ++i) scanf("%lld",&b[i]);
	for (int i=1; i<=n; ++i) dp[i] = 0;
	for (int i=1; i<=n; ++i) {
		ll la = dp[i];
		for (int j=i-1; j>=1; --j) {
			if(a[i] != a[j]) {
				dp[i] = max(dp[i],dp[j] + abs(b[i]-b[j]));
				dp[j] = max(dp[j],la + abs(b[i]-b[j]));
			}
			la = max(la,dp[i]);
		}
	}
	ll ans = 0;
	for (int i=1; i<=n; ++i) ans = max(ans,dp[i]);
	printf("%lld\n",ans);
}
int main() {
	int t;
	scanf("%d",&t);
	while(t--) {
		solve();
	}
	return 0;
} 
