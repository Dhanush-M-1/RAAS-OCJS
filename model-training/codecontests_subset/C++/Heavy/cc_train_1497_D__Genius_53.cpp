#include <cstdio>
#include <algorithm>

using namespace std;

#define int long long

int n, tag[5005], s[5005];
int dp[5005];

signed main() {
//    freopen("in", "r", stdin), freopen("out", "w", stdout);
    int Test;
    scanf("%lld", &Test);
    while (Test--) {
        scanf("%lld", &n);
        for (int i = 1; i <= n; i++)scanf("%lld", &tag[i]);
        for (int i = 1; i <= n; i++)scanf("%lld", &s[i]);
        for (int i = 1; i <= n; i++)dp[i] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (tag[i] == tag[j])continue;
                int dpi = dp[i], dpj = dp[j];
                dp[i] = max(dp[i], dpj + abs(s[i] - s[j]));
                dp[j] = max(dp[j], dpi + abs(s[i] - s[j]));
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++)ans = max(ans, dp[i]);
        printf("%lld\n", ans);
    }
    return 0;
}