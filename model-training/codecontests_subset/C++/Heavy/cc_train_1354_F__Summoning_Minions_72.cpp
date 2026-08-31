#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
int n, k, dp[76][76];
array<int, 3> a[75];
bool last[76][76];
void solve() {
  cin >> n >> k;
  for (int i = 0; i < n; ++i) cin >> a[i][1] >> a[i][0], a[i][2] = i;
  sort(a, a + n);
  for (int i = 1; i <= n; ++i) {
    for (int j = 0; j <= i; ++j) {
      dp[i][j] = (j < i ? dp[i - 1][j] : -INF) + (k - 1) * a[i - 1][0];
      last[i][j] = 0;
      if (j) {
        int c = dp[i - 1][j - 1] + (j - 1) * a[i - 1][0] + a[i - 1][1];
        if (c > dp[i][j]) {
          dp[i][j] = c;
          last[i][j] = 1;
        }
      }
    }
  }
  vector<int> t, nt;
  for (int i = n, j = k; i; --i) {
    if (last[i][j]) {
      t.push_back(a[i - 1][2]);
      --j;
    } else
      nt.push_back(a[i - 1][2]);
  }
  assert(t.size() == k);
  reverse(t.begin(), t.end());
  cout << 2 * n - k << "\n";
  for (int i = 0; i < k - 1; ++i) cout << t[i] + 1 << " ";
  for (int i : nt) cout << i + 1 << " " << -(i + 1) << " ";
  cout << t[k - 1] + 1 << "\n";
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
