#include <bits/stdc++.h>
using namespace std;
const int N = 77;
int t, n, k, inv[N];
long long a[N], b[N], a2[N], b2[N], dp[N][N];
bool summon[N][N], s[N], ans[N][N];
long long solve() {
  dp[0][0] = 0;
  for (int i = (1); i < (n + 1); i++) {
    for (int j = (0); j < (min(k, i) + 1); j++) {
      dp[i][j] = -1;
      summon[i][j] = true;
      if (j > 0) {
        dp[i][j] = dp[i - 1][j - 1] + a[i] + (j - 1) * b[i];
      }
      if (j < i && dp[i - 1][j] + b[i] * (k - 1) > dp[i][j]) {
        summon[i][j] = false;
        dp[i][j] = dp[i - 1][j] + b[i] * (k - 1);
      }
    }
  }
  return dp[n][k];
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> t;
  while (t--) {
    cin >> n >> k;
    vector<tuple<int, int, int>> ve;
    for (int i = (1); i < (n + 1); i++) {
      cin >> a[i] >> b[i];
      ve.emplace_back(b[i], a[i], i);
    }
    sort((ve).begin(), (ve).end());
    for (int i = (1); i < (n + 1); i++) {
      tie(b[i], a[i], inv[i]) = ve[i - 1];
    }
    solve();
    int i = n, j = k;
    while (i > 0) {
      if (summon[i][j]) {
        j--;
        s[i] = true;
      } else {
        s[i] = false;
      }
      i--;
    }
    int cnt = 0;
    vector<int> v;
    int last = 0;
    for (int i = (1); i < (n + 1); i++) {
      if (s[i]) {
        if (cnt < k - 1) {
          v.push_back(inv[i]);
          cnt++;
        } else {
          last = inv[i];
        }
      }
    }
    for (int i = (1); i < (n + 1); i++) {
      if (!s[i]) {
        v.push_back(inv[i]);
        v.push_back(-inv[i]);
      }
    }
    v.push_back(last);
    cout << ((int)(v).size()) << '\n';
    for (int x : v) {
      cout << x << ' ';
    }
    cout << '\n';
  }
}
