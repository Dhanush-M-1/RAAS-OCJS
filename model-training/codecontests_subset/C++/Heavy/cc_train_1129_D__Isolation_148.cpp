#include <bits/stdc++.h>
const int maxn = 100005, mod = 998244353, maxt = 325;
int n, k, t;
int a[maxn], l[maxt], r[maxt], pos[maxn], lst[maxn], pre[maxn], f[maxn],
    sum[maxt][maxn], tot[maxn], tag[maxt], cnt[maxn];
void BF(int x, int y, int v) {
  for (int i = x; i <= y; i++) {
    if (v == 1)
      cnt[i]++, sum[pos[i]][cnt[i]] = (sum[pos[i]][cnt[i]] + f[i]) % mod;
    else
      sum[pos[i]][cnt[i]] = (sum[pos[i]][cnt[i]] - f[i] + mod) % mod, cnt[i]--;
  }
}
void update(int x, int y, int v) {
  if (x > y) return;
  int p = pos[x], q = pos[y];
  if (p == q) {
    BF(x, y, v);
    return;
  }
  BF(x, r[p], v), BF(l[q], y, v);
  for (int i = p + 1; i <= q - 1; i++) tag[i] += v;
}
int query() {
  int res = 0;
  for (int i = 1; i <= t; i++)
    if (k - tag[i] + 1 >= 0)
      res = (res + tot[i] - sum[i][k - tag[i] + 1]) % mod;
  return (res + mod) % mod;
}
int main() {
  scanf("%d%d", &n, &k);
  t = sqrt(n + 1);
  r[0] = -1;
  for (int i = 1; i <= t; i++) l[i] = r[i - 1] + 1, r[i] = l[i] + t - 1;
  if (r[t] < n) t++, l[t] = r[t - 1] + 1, r[t] = n;
  for (int i = 1; i <= t; i++)
    for (int j = l[i]; j <= r[i]; j++) pos[j] = i;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    pre[i] = lst[a[i]], lst[a[i]] = i;
  }
  f[0] = 1, sum[1][0] = 1, tot[1] = 1;
  for (int i = 1; i <= n; i++) {
    update(pre[pre[i]], pre[i] - 1, -1), update(pre[i], i - 1, 1);
    f[i] = query(), sum[pos[i]][0] = (sum[pos[i]][0] + f[i]) % mod,
    tot[pos[i]] = (tot[pos[i]] + f[i]) % mod;
  }
  printf("%d\n", f[n]);
  return 0;
}
