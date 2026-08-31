#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<int, int> pii;
const int INF = 0x3f3f3f3f;
const ll LINF = 0x3f3f3f3f3f3f3f3fLL;
const double PI = acos(-1.0);
const double EPS = 1e-9;
//const int MOD = 1000000007;
const int MOD = 998244353;

/* begin */

int n;
int tag[5005];
int s[5005];
ll dp[5005];

void solve() {
    for (int i = 1; i <= n; ++i)
        scanf("%d", &tag[i]);
    for (int i = 1; i <= n; ++i)
        scanf("%d", &s[i]);
    for (int i = 1; i <= n; ++i)
        dp[i] = 0;
    for (int i = 2; i <= n; ++i) {
        for (int j = i - 1; j >= 1; --j) {
            if (tag[i] == tag[j])
                continue;
            int P = abs(s[i] - s[j]);
            ll dpi = dp[i], dpj = dp[j];
            dp[i] = max(dpi, dpj + P);
            dp[j] = max(dpj, dpi + P);
        }
    }
    ll ans = *max_element(dp + 1, dp + 1 + n);
    printf("%lld\n", ans);
    return;
}

/* end */

int main() {
#ifdef LOCAL
    freopen("A.in", "r", stdin);
#endif // LOCAL
    int t;
    scanf("%d", &t);
    while (~scanf("%d", &n))
        solve();
    return 0;
}
