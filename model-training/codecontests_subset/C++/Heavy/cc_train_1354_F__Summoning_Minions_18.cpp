#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, k;
  cin >> n >> k;
  vector<int> a(n), b(n);
  for (int i = 0; i < n; ++i) {
    cin >> a[i] >> b[i];
  }
  vector<vector<long long>> dp(n + 1, vector<long long>(k + 2, 0));
  vector<vector<int>> p(n + 1, vector<int>(k + 2));
  vector<int> id(n);
  iota(id.begin(), id.end(), 0);
  sort(id.begin(), id.end(), [&](int i, int j) { return b[i] < b[j]; });
  auto rlx = [&](int i, int j, long long val, int tk) {
    if (dp[i][j] < val) {
      dp[i][j] = val;
      p[i][j] = tk;
    }
  };
  for (int i = 0; i < n; ++i) {
    int ii = id[i];
    for (int j = 0; j <= min(i, k); ++j) {
      rlx(i + 1, j, dp[i][j] + (k - 1) * b[ii], 0);
      rlx(i + 1, j + 1, dp[i][j] + a[ii] + j * b[ii], 1);
    }
  }
  vector<int> u, v;
  for (int i = n, j = k; i >= 1; j -= p[i][j], --i) {
    if (p[i][j]) {
      u.push_back(id[i - 1]);
    } else {
      v.push_back(id[i - 1]);
    }
  }
  reverse(u.begin(), u.end());
  cout << k + 2 * (n - k) << '\n';
  for (int i = 0; i < k - 1; ++i) {
    cout << u[i] + 1 << ' ';
  }
  for (int i = 0; i < n - k; ++i) {
    cout << v[i] + 1 << ' ' << -(v[i] + 1) << ' ';
  }
  cout << u[k - 1] + 1;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    solve();
    cout << '\n';
  }
  return 0;
}
