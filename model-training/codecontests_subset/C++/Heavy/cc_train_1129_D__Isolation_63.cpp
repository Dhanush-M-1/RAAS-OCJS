#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void read(T &x) {
  int ch = 0, f = 0;
  x = 0;
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') f = 1;
  for (; isdigit(ch); ch = getchar()) x = x * 10 + ch - 48;
  if (f) x = -x;
}
const int M = 205, N = 100005, L = 100000, mod = 998244353;
int a[N], bel[N], tag[N], tot[N], ans[M], s[M][N << 1], pre[N], lst[N], dp[N],
    n, k, T;
inline void up(int &x, int y) { x = x + y >= mod ? x + y - mod : x + y; }
inline void gao(int i, int x) {
  up(s[bel[i]][L + tot[i]], mod - dp[i]);
  tot[i] += x;
  up(s[bel[i]][L + tot[i]], dp[i]);
  if (x == 1 && tot[i] + tag[bel[i]] == k + 1) up(ans[bel[i]], mod - dp[i]);
  if (x == -1 && tot[i] + tag[bel[i]] == k) up(ans[bel[i]], dp[i]);
}
inline void modify(int l, int r, int x) {
  if (bel[l] + 1 >= bel[r]) {
    for (int i = l; i <= r; i++) gao(i, x);
    return;
  }
  for (int i = l; i < (bel[l] + 1) * T; i++) gao(i, x);
  for (int i = bel[r] * T; i <= r; i++) gao(i, x);
  for (int i = bel[l] + 1; i < bel[r]; i++) {
    if (x == 1) up(ans[i], mod - s[i][L + k - tag[i]]);
    if (x == -1) up(ans[i], s[i][L + k - tag[i] + 1]);
    tag[i] += x;
  }
}
inline int query(int l, int r) {
  int res = 0;
  if (bel[l] + 1 >= bel[r]) {
    for (int i = l; i <= r; i++)
      if (tot[i] + tag[bel[i]] <= k) up(res, dp[i]);
    return res;
  }
  for (int i = l; i < (bel[l] + 1) * T; i++)
    if (tot[i] + tag[bel[i]] <= k) up(res, dp[i]);
  for (int i = bel[r] * T; i <= r; i++)
    if (tot[i] + tag[bel[i]] <= k) up(res, dp[i]);
  for (int i = bel[l] + 1; i < bel[r]; i++) up(res, ans[i]);
  return res;
}
int main() {
  read(n), read(k), T = 500;
  for (int i = 0; i <= n; i++) bel[i] = i / T;
  for (int i = 1; i <= n; i++) read(a[i]);
  dp[0] = 1;
  up(ans[bel[0]], dp[0]);
  up(s[bel[0]][L - tag[bel[0]]], dp[0]);
  for (int i = 1; i <= n; i++) {
    pre[i] = lst[a[i]], lst[a[i]] = i;
    modify(pre[i], i - 1, 1);
    if (pre[i]) modify(pre[pre[i]], pre[i] - 1, -1);
    dp[i] = query(0, i - 1);
    up(ans[bel[i]], dp[i]);
    up(s[bel[i]][L - tag[bel[i]]], dp[i]);
  }
  cout << dp[n];
  return 0;
}
