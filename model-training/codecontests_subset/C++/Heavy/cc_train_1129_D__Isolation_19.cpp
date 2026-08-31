#include <bits/stdc++.h>
using namespace std;
const int t = 399, mod = 998244353;
inline int mo(const register int x) { return x >= mod ? x - mod : x; }
int a[100010], n, k, bl[100010], p[100010], pre[100010], sum[400][100010],
    f[400], S[400], dp[100010], lst[100010];
inline void rebuild(const register int x, const register int l,
                    const register int r, const register int y) {
  for (int i = (x - 1) * t + 1; i <= min(n, x * t); i++)
    sum[x][p[i]] = 0, p[i] += k - f[x];
  for (int i = l; i <= r; i++) p[i] += y;
  S[x] = 0;
  for (int i = (x - 1) * t + 1; i <= min(n, x * t); i++)
    sum[x][p[i]] = mo(sum[x][p[i]] + dp[i]),
    S[x] = mo(S[x] + (p[i] <= k) * dp[i]);
  f[x] = k;
}
inline void ad(const register int l, const register int r,
               const register int x) {
  if (bl[l] == bl[r]) {
    rebuild(bl[l], l, r, x);
    return;
  }
  rebuild(bl[l], l, bl[l] * t, x);
  rebuild(bl[r], (bl[r] - 1) * t + 1, r, x);
  for (int i = bl[l] + 1; i < bl[r]; i++) {
    f[i] -= x;
    if (x > 0) {
      if (f[i] + 1 >= 0 && f[i] + 1 < n)
        S[i] = mo(S[i] - sum[i][f[i] + 1] + mod);
    } else if (f[i] >= 0 && f[i] < n)
      S[i] = mo(S[i] + sum[i][f[i]]);
  }
}
int main() {
  scanf("%d%d", &n, &k);
  n++;
  for (int i = 1; i <= n; i++) bl[i] = (i - 1) / t + 1;
  for (int i = 1; i <= bl[n]; i++) f[i] = k;
  for (int i = 2; i <= n; i++) scanf("%d", &a[i]), pre[a[i]] = 1;
  dp[1] = 1;
  ad(1, 1, 0);
  for (int i = 2; i <= n; i++) {
    if (pre[a[i]] - 1) ad(lst[pre[a[i]]], pre[a[i]] - 1, -1);
    ad(pre[a[i]], i - 1, 1);
    lst[i] = pre[a[i]];
    pre[a[i]] = i;
    for (int j = 1; j <= bl[n]; j++) dp[i] = mo(dp[i] + S[j]);
    ad(i, i, 0);
  }
  cout << dp[n] << endl;
}
