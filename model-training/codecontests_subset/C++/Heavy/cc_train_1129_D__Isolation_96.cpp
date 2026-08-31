#include <bits/stdc++.h>
using namespace std;
const int M = 100005, K = 316, mod = 998244353;
int n, k, a[M], b[M], dp[M], sum[K + 5][2 * K + 5], in[M], tot[K + 5];
vector<int> v[M];
void pl(int &a, int b) {
  a += b;
  if (a >= mod) a -= mod;
}
void update(int i, int x) {
  b[i] = x;
  memset(sum[in[i]], 0, sizeof(sum[in[i]]));
  tot[in[i]] = 0;
  for (int j = min(n, K * (in[i] + 1) - 1); j && in[i] == in[j]; j--) {
    tot[in[i]] += b[j];
    pl(sum[in[i]][tot[in[i]] + K], dp[j - 1]);
  }
  for (int j = 1; j <= 2 * K; j++) pl(sum[in[i]][j], sum[in[i]][j - 1]);
  assert(abs(tot[in[i]]) <= K);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  dp[0] = 1;
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    in[i] = i / K;
  }
  for (int i = 1; i <= n; i++) {
    update(i, 1);
    if (v[a[i]].size()) update(v[a[i]].back(), -1);
    if (v[a[i]].size() > 1) update(*(v[a[i]].end() - 2), 0);
    v[a[i]].push_back(i);
    int s = 0;
    for (int j = i; j && in[i] == in[j]; j--) {
      s += b[j];
      if (s <= k) pl(dp[i], dp[j - 1]);
    }
    for (int j = in[i] - 1; j + 1; j--) {
      int t = k - s;
      if (t + K >= 0) pl(dp[i], sum[j][min(2 * K, t + K)]);
      s += tot[j];
    }
  }
  cout << dp[n] << '\n';
  return 0;
}
