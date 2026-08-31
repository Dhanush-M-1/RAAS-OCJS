#include <bits/stdc++.h>
using namespace std;
const int MX = 80;
int n, k;
array<int, 3> m[MX];
long long dp[MX][MX];
int dpb[MX][MX];
void solve() {
  cin >> n >> k;
  for (int i = (0); i < (n); ++i) {
    cin >> m[i][1] >> m[i][0];
    m[i][2] = i + 1;
  }
  sort(m, m + n);
  for (int i = (0); i < (n + 1); ++i) {
    memset((dp[i]), -1, (k + 1) * sizeof(dp[i][0]));
    memset((dpb[i]), -1, (k + 1) * sizeof(dpb[i][0]));
  }
  dp[0][0] = 0;
  for (int i = (0); i < (n); ++i)
    for (int j = (0); j < (k + 1); ++j) {
      if (dp[i][j] == -1) continue;
      auto [b, a, _id] = m[i];
      if (dp[i + 1][j] < dp[i][j] + (k - 1) * b) {
        dp[i + 1][j] = dp[i][j] + (k - 1) * b;
        dpb[i + 1][j] = 0;
      }
      if (j < k && dp[i + 1][j + 1] < dp[i][j] + a + j * b) {
        dp[i + 1][j + 1] = dp[i][j] + a + j * b;
        dpb[i + 1][j + 1] = 1;
      }
    }
  vector<int> mf = vector<int>(k);
  vector<int> rit = vector<int>();
  rit.reserve(n - k);
  int cp = k;
  for (int i = (n)-1; i >= (0); --i) {
    auto [b, a, id] = m[i];
    if (dpb[i + 1][cp])
      mf[--cp] = id;
    else
      rit.push_back(id);
  }
  cout << 2 * n - k << '\n';
  for (int i = (0); i < (k - 1); ++i) cout << mf[i] << ' ';
  for (int i = (0); i < (n - k); ++i) cout << rit[i] << ' ' << -rit[i] << ' ';
  cout << mf[k - 1] << '\n';
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
