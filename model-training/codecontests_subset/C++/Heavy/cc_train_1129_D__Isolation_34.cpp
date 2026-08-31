#include <bits/stdc++.h>
using namespace std;
const long long mod = 998244353;
const int maxn = 1e5 + 79, s = 350, ns = maxn / s + 5;
int n, k;
vector<int> f(maxn, 0), a(maxn), dp(maxn, 0), myval(ns, 0);
vector<vector<int> > oc(maxn), sum(ns, vector<int>(s * 2 + 2, 0));
void add(int& a, const int& b) {
  a += b;
  if (a >= mod) a -= mod;
}
void recalculate_block(int i, int val) {
  f[i] = val;
  int b = i / s, l = b * s, r = min(n - 1, (b + 1) * s - 1);
  myval[b] = 0;
  for (int i = 0; i < sum[b].size(); i++) sum[b][i] = 0;
  for (int i = r; i >= l; i--) {
    myval[b] += f[i];
    add(sum[b][myval[b] + s], dp[i]);
  }
  for (int i = 1; i < sum[b].size(); i++) add(sum[b][i], sum[b][i - 1]);
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n >> k;
  for (int i = 0; i < n; i++) cin >> a[i];
  int ans = 0;
  dp[0] = 1;
  for (int r = 0; r < n; r++) {
    if (oc[a[r]].size()) {
      recalculate_block(oc[a[r]].back(), -1);
    }
    if (oc[a[r]].size() > 1) {
      recalculate_block(oc[a[r]][oc[a[r]].size() - 2], 0);
    }
    int c = 1;
    for (int l = r; l >= 0; l--) {
      c += f[l];
      if (c <= k) add(dp[r + 1], dp[l]);
      if (l % s == 0) break;
    }
    for (int b = (r / s) - 1; b >= 0; b--) {
      if (k - c >= -s) {
        add(dp[r + 1], sum[b][min((int)sum[b].size() - 1, s + k - c)]);
      }
      add(c, myval[b]);
    }
    oc[a[r]].push_back(r);
    add(ans, dp[r + 1]);
    recalculate_block(r, 1);
  }
  cout << dp[n] << "\n";
  return 0;
}
