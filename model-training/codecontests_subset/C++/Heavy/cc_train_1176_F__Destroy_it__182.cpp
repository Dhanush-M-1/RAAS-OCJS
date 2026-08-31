#include <bits/stdc++.h>
using namespace std;
void fast() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
}
const long long INFll = 1ll * 1000000000 * 1000000000;
const long double PI =
    3.141592653589793238462643383279502884197169399375105820974944;
int mul(int a, int b, int mod = 1000000007) { return int(a * 1ll * b % mod); }
int norm(int a, int mod = 1000000007) {
  while (a >= mod) a -= mod;
  while (a < 0) a += mod;
  return a;
}
int powmod(int x, int y, int mod = 1000000007) {
  int res = 1;
  while (y > 0) {
    if (y & 1) res = mul(res, x, mod);
    x = mul(x, x, mod);
    y = y >> 1;
  }
  return res;
}
int inv(int a, int mod = 1000000007) { return powmod(a, mod - 2); }
long long dp[200005][11];
int main() {
  fast();
  int n;
  cin >> n;
  vector<vector<pair<long long, long long>>> mpr(
      n + 1, vector<pair<long long, long long>>(4, {0, 0}));
  for (int i = 0; i <= n; i++)
    for (int j = 1; j <= 10; j++) dp[i][j] = (LLONG_MIN + 2 * 1000000000);
  for (int i = 1; i <= n; i++) {
    int k;
    cin >> k;
    vector<long long> v[4];
    for (int j = 0; j < k; j++) {
      int c, d;
      cin >> c >> d;
      v[c].push_back(d);
    }
    for (int j = 1; j < 4; j++) sort(v[j].rbegin(), v[j].rend());
    if (v[1].size() >= 1) {
      mpr[i][1].first = v[1][0];
      mpr[i][1].second = 2 * v[1][0];
    }
    if (v[2].size() >= 1) {
      mpr[i][1].first = max(mpr[i][1].first, v[2][0]);
      mpr[i][1].second = max(mpr[i][1].second, 2 * v[2][0]);
    }
    if (v[3].size() >= 1) {
      mpr[i][1].first = max(mpr[i][1].first, v[3][0]);
      mpr[i][1].second = max(mpr[i][1].second, 2 * v[3][0]);
    }
    if (v[1].size() >= 2) {
      mpr[i][2].first = v[1][0] + v[1][1];
      mpr[i][2].second = 2 * v[1][0] + v[1][1];
    }
    if (v[2].size() >= 1 && v[1].size() >= 1) {
      mpr[i][2].first = max(mpr[i][2].first, v[2][0] + v[1][0]);
      mpr[i][2].second = max(mpr[i][2].second,
                             max(2 * v[2][0] + v[1][0], v[2][0] + 2 * v[1][0]));
    }
    if (v[1].size() >= 3) {
      mpr[i][3].first = v[1][0] + v[1][1] + v[1][2];
      mpr[i][3].second = 2 * v[1][0] + v[1][1] + v[1][2];
    }
  }
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= 10; j++) dp[i][j] = dp[i - 1][j];
    for (int j = 1; j <= 10; j++) {
      for (int k = 1; k <= 3; k++) {
        if (mpr[i][k].first != 0) {
          if (j == 10) {
            if (dp[i - 1][j - k] >= 0)
              dp[i][j] = max(dp[i][j], dp[i - 1][j - k] + mpr[i][k].second);
          } else if (j - k == 0) {
            if (dp[i - 1][10] < 0) {
              dp[i][j] = max(dp[i][j], dp[i - 1][0] + mpr[i][k].first);
            } else {
              dp[i][j] = max(dp[i][j], dp[i - 1][10] + mpr[i][k].first);
            }
          } else if ((j - k) < 0) {
            if (dp[i - 1][10 + (j - k)] >= 0)
              dp[i][j] =
                  max(dp[i][j], dp[i - 1][10 + (j - k)] + mpr[i][k].second);
          } else if ((j - k) > 0) {
            if (dp[i - 1][j - k] >= 0)
              dp[i][j] = max(dp[i][j], dp[i - 1][j - k] + mpr[i][k].first);
          }
        }
      }
    }
  }
  long long ans = 0;
  for (int i = 1; i <= 10; i++) ans = max(ans, dp[n][i]);
  cout << ans;
  return 0;
}
