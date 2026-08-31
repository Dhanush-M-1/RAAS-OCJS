#include <bits/stdc++.h>
using namespace std;
const int max_n = 200005;
int n;
long long dp[2][11];
vector<int> v[4];
vector<int> opt[4];
int nf = 0;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= 9; i++) dp[0][i] = -1;
  dp[0][0] = 0;
  nf = 0;
  while (n--) {
    int k;
    scanf("%d", &k);
    for (int i = 1; i <= 3; i++) v[i].clear(), opt[i].clear();
    while (k--) {
      int c, d;
      scanf("%d%d", &c, &d);
      v[c].push_back(d);
    }
    for (int i = 1; i <= 3; i++) sort(v[i].begin(), v[i].end(), greater<int>());
    if (v[1].size() >= 3)
      for (int i = 0; i < 3; i++) opt[3].push_back(v[1][i]);
    vector<int> t;
    for (int i = 0; i < min(2, (int)v[1].size()); i++) t.push_back(v[1][i]);
    for (int i = 0; i < min(1, (int)v[2].size()); i++) t.push_back(v[2][i]);
    sort(t.begin(), t.end(), greater<int>());
    if (t.size() >= 2)
      for (int i = 0; i < 2; i++) opt[2].push_back(t[i]);
    int mx = 0;
    for (int i = 1; i <= 3; i++)
      if (!v[i].empty()) mx = max(mx, v[i][0]);
    opt[1].push_back(mx);
    nf ^= 1;
    for (int i = 0; i <= 10; i++) dp[nf][i] = dp[nf ^ 1][i];
    for (int i = 0; i <= 9; i++) {
      if (dp[nf ^ 1][i] == -1) continue;
      for (int j = 1; j <= 3; j++) {
        if (opt[j].empty()) continue;
        int b = (i + 1) % 10, e = (i + j) % 10;
        long long x = 0;
        for (auto y : opt[j]) x += y;
        if (i + 1 <= 10 && i + j >= 10) x += opt[j][0];
        dp[nf][e] = max(dp[nf][e], dp[nf ^ 1][i] + x);
      }
    }
  }
  long long ans = 0;
  for (int i = 0; i <= 10; i++) ans = max(ans, dp[nf][i]);
  printf("%lld\n", ans);
  return 0;
}
