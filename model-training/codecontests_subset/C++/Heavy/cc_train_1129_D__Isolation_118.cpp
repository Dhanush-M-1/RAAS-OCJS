#include <bits/stdc++.h>
using namespace std;
const int M = 205;
const int N = 100005;
const int L = 100000;
const int mod = 998244353;
int n, k, len, a[N], bel[N], pre[N], las[N], dp[N], fl[N], tot[N], ans[M],
    s[M][N << 1];
void ad(int i, int x) {
  (s[bel[i]][L + tot[i]] += mod - dp[i]) %= mod;
  tot[i] += x;
  (s[bel[i]][L + tot[i]] += dp[i]) %= mod;
  if (x == 1 && tot[i] + fl[bel[i]] == k + 1) {
    (ans[bel[i]] += mod - dp[i]) %= mod;
  }
  if (x == -1 && tot[i] + fl[bel[i]] == k) {
    (ans[bel[i]] += dp[i]) %= mod;
  }
}
void add(int l, int r, int x) {
  if (bel[l] + 1 >= bel[r]) {
    for (int i = l; i <= r; i++) {
      ad(i, x);
    }
    return;
  }
  for (int i = l; i < (bel[l] + 1) * len; i++) {
    ad(i, x);
  }
  for (int i = bel[r] * len; i <= r; i++) {
    ad(i, x);
  }
  for (int i = bel[l] + 1; i < bel[r]; i++) {
    if (x == 1) {
      (ans[i] += mod - s[i][L + k - fl[i]]) %= mod;
    }
    if (x == -1) {
      (ans[i] += s[i][L + k - fl[i] + 1]) %= mod;
    }
    fl[i] += x;
  }
}
int query(int l, int r) {
  int sum = 0;
  if (bel[l] + 1 >= bel[r]) {
    for (int i = l; i <= r; i++) {
      if (tot[i] + fl[bel[i]] <= k) {
        (sum += dp[i]) %= mod;
      }
    }
    return sum;
  }
  for (int i = l; i < (bel[l] + 1) * len; i++) {
    if (tot[i] + fl[bel[i]] <= k) {
      (sum += dp[i]) %= mod;
    }
  }
  for (int i = bel[r] * len; i <= r; i++) {
    if (tot[i] + fl[bel[i]] <= k) {
      (sum += dp[i]) %= mod;
    }
  }
  for (int i = bel[l] + 1; i < bel[r]; i++) {
    (sum += ans[i]) %= mod;
  }
  return sum;
}
signed main() {
  scanf("%d%d", &n, &k);
  len = 500;
  for (int i = 0; i <= n; i++) {
    bel[i] = i / len;
  }
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  dp[0] = 1;
  ans[0] += dp[0];
  s[0][L] += dp[0];
  for (int i = 1; i <= n; i++) {
    pre[i] = las[a[i]];
    las[a[i]] = i;
    add(pre[i], i - 1, 1);
    if (pre[i]) add(pre[pre[i]], pre[i] - 1, -1);
    dp[i] = query(0, i - 1);
    (ans[bel[i]] += dp[i]) %= mod;
    (s[bel[i]][L - fl[bel[i]]] += dp[i]) %= mod;
  }
  cout << dp[n];
}
