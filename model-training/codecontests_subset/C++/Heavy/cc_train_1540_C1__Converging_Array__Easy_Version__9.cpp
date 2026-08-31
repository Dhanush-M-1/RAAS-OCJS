#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef unsigned long long ull;
#define y1 y114514
#define pb push_back
#define mkp make_pair
#define fi first
#define se second
#define all(a) a.begin(), a.end()
const int M = 1000000007;

const int maxn = 105;
int n;
int c[maxn];
int b[maxn];
int sum[maxn];
int ss[maxn];
int tot[maxn];
int dp[maxn][maxn * 100];
int q, x;

int main() {
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) scanf("%d", c + i), tot[i] = tot[i - 1] + c[i];
    for (int i = 1; i < n; ++i) {
        scanf("%d", b + i);
        sum[i + 1] = sum[i] + b[i];
        ss[i + 1] = ss[i] + sum[i + 1];
    }
    scanf("%d%d", &q, &x);
    dp[0][0] = 1;
    for (int i = 1; i <= n; ++i) {
        for (int j = 0; j <= tot[i]; ++j)
            if (dp[i - 1][j]) {
                int limit = x * i + ss[i] - j;
                // printf("i:%d j:%d limit:%d\n", i, j, limit);
                for (int k = max(0, limit); k <= c[i]; ++k) {
                    dp[i][j + k] = dp[i][j + k] + dp[i - 1][j];
                    if (dp[i][j + k] >= M) dp[i][j + k] -= M;
                    // printf("dp[%d][%d]->%d->dp[%d][%d], cur: %d\n", i - 1, j, k, i, j + k, dp[i][j + k]);
                }
            }
    }

    // for (int i = 1; i <= n; ++i)
    //     for (int j = 0; j <= tot[i]; ++j) printf("dp[%d][%d]: %d\n", i, j, dp[i][j]);

    int ans = 0;
    for (int i = 0; i <= tot[n]; ++i) (ans += dp[n][i]) %= M;
    printf("%d\n", ans);
    return 0;
}