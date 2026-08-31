#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 7;
const int inf = INT_MAX;
const long long inff = 1e18;
const long long mod = 1e9 + 7;
int dp[77][77];
int a[77], b[77];
int used[77];
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, k;
    cin >> n >> k;
    for (int i = 1; i <= n; i++) cin >> a[i] >> b[i];
    if (k == 1) {
      int att = 0, mx = 0;
      for (int i = 1; i <= n; i++)
        if (a[i] > mx) mx = a[i], att = i;
      cout << 1 << '\n' << att << '\n';
    } else {
      memset(dp, 0, sizeof(dp));
      memset(used, 0, sizeof(used));
      for (int i = 0; i <= n; i++)
        for (int j = 1; j <= k; j++) dp[i][j] = -inf;
      dp[0][0] = 0;
      vector<int> v;
      for (int i = 1; i <= n; i++) v.push_back(i);
      sort((v).begin(), (v).end(), [&](int x, int y) { return b[x] < b[y]; });
      for (int i = 1; i <= n; i++)
        for (int j = 1; j <= min(i, k); j++) {
          if (j - 1 <= i) dp[i][j] = dp[i - 1][j];
          dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] +
                                       (a[v[i - 1]] - (k - j) * b[v[i - 1]]));
        }
      vector<int> vv;
      int nowk = k;
      for (int i = n; i >= 1; i--) {
        if (nowk > 0 &&
            dp[i - 1][nowk - 1] + (a[v[i - 1]] - (k - nowk) * b[v[i - 1]]) ==
                dp[i][nowk]) {
          used[v[i - 1]] = 1;
          vv.push_back(v[i - 1]);
          nowk--;
        }
      }
      reverse((vv).begin(), (vv).end());
      cout << 2 * n - k << '\n';
      for (int i = 0; i < k - 1; i++) cout << vv[i] << ' ';
      for (int i = 1; i <= n; i++)
        if (!used[i]) cout << i << ' ' << -i << ' ';
      cout << vv[k - 1] << '\n';
    }
  }
}
