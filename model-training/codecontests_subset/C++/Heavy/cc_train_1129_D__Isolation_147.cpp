#include <bits/stdc++.h>
using namespace std;
const int mod = 998244353;
const int MAXN = 100005;
const int Blocks = 405;
int n, qk, a[MAXN], pre[MAXN], lst[MAXN], dp[MAXN], f[MAXN];
int sum[Blocks][MAXN], ans[Blocks], lz[Blocks], l[Blocks], r[Blocks], bl[MAXN];
inline void add(int &x, int y) {
  x += y;
  (x >= mod) && (x -= mod);
}
inline void sub(int &x, int y) {
  x -= y;
  (x < 0) && (x += mod);
}
inline void Rebuild(int x) {
  for (int k = l[x]; k <= r[x]; ++k) sum[x][f[k]] = 0, f[k] += lz[x];
  lz[x] = ans[x] = 0;
  for (int k = l[x]; k <= r[x]; ++k) {
    add(sum[x][f[k]], dp[k]);
    if (f[k] <= qk) add(ans[x], dp[k]);
  }
}
inline void Update(int k, int val) {
  int x = bl[k];
  sub(sum[x][f[k]], dp[k]);
  if (f[k] <= qk) sub(ans[x], dp[k]);
  f[k] += val;
  add(sum[x][f[k]], dp[k]);
  if (f[k] <= qk) add(ans[x], dp[k]);
}
inline void Modify(int x, int y, int val) {
  int L = bl[x], R = bl[y];
  if (L == R) {
    Rebuild(L);
    for (int k = x; k <= y; ++k) Update(k, val);
  } else {
    Rebuild(L);
    for (int k = x; k <= r[L]; ++k) Update(k, val);
    Rebuild(R);
    for (int k = l[R]; k <= y; ++k) Update(k, val);
    for (int i = L + 1; i < R; ++i)
      if (val == 1) {
        int tmp = qk - (lz[i]++);
        sub(ans[i], sum[i][tmp]);
      } else {
        int tmp = qk - (--lz[i]);
        add(ans[i], sum[i][tmp]);
      }
  }
}
inline int Query(int x) {
  int re = 0;
  Rebuild(bl[x]);
  for (int k = l[bl[x]]; k <= x; ++k)
    if (f[k] <= qk) add(re, dp[k]);
  for (int i = 1; i < bl[x]; ++i) add(re, ans[i]);
  return re;
}
int main() {
  scanf("%d%d", &n, &qk);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
    pre[i] = lst[a[i]];
    lst[a[i]] = i;
  }
  dp[1] = 1;
  int m = sqrt(n);
  for (int i = 1; i <= n; ++i) {
    bl[i] = (i - 1) / m + 1;
    r[bl[i]] = i;
    if (!l[bl[i]]) l[bl[i]] = i;
  }
  for (int i = 1; i <= n; ++i) {
    Modify(pre[i] + 1, i, 1);
    if (pre[i]) Modify(pre[pre[i]] + 1, pre[i], -1);
    dp[i + 1] = Query(i);
  }
  printf("%d\n", dp[n + 1]);
}
