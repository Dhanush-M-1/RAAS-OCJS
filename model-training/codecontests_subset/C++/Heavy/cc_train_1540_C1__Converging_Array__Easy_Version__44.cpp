#include <bits/stdc++.h>

#define all(a) begin(a), end(a)
#define forn(i, n) for (int i = 0; i < n; ++i)

using namespace std;
using ll = long long;

const int MOD = 1e9 + 7;
const int N = 103;
const int SUM = 101 * 101;

int dp[N][SUM];
int n, a[N], b[N];
int pb[N];

void solve() {
    // for all i sum - ((i-1)*b_1 + .. +b_{i-1}) >= x * i
    cin >> n;

    forn(i, n) {
        cin >> a[i];
    }

    pb[0] = 0;
    forn(i, n - 1) {
        cin >> b[i];
        pb[i + 1] = pb[i] + b[i];
    }

    for (int i = 1; i < n; ++i) {
        pb[i] += pb[i - 1];
    }

    int x;
    cin >> x >> x;

    forn(i, a[0] + 1) {
        dp[0][i] = 1;
    }

    forn(i, n - 1) {
        ll val = 1ll * (i + 1) * x + pb[i];
        val = max(val, 0ll);
        for (int j = val; j < SUM; ++j) {
            if (dp[i][j] == 0) continue;
            for (int nxt = 0; nxt <= a[i + 1]; ++nxt) {
                dp[i + 1][j + nxt] = (dp[i + 1][j + nxt] + dp[i][j]) % MOD;
            }
        }
    }

    int res = 0;
    ll lower = 1ll * n * x + pb[n - 1];
    lower = max(lower, 0ll);

    for (int i = lower; i < SUM; ++i) res = (res + dp[n - 1][i]) % MOD;
    cout << res << "\n";
}

signed main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    solve();

    return 0;
}