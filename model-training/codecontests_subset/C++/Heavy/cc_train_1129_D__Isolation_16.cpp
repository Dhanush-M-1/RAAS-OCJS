#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 7, mod = 998244353;
int n, m, B, a[N], pos[N], bel[N], lst[N], f[N], cnt[N], delta[440], ans[440],
    sum[440][N];
void update(int u, int v) {
  int t = bel[u];
  sum[t][cnt[u]] = (sum[t][cnt[u]] - f[u] + mod) % mod;
  if (cnt[u] + delta[t] <= m) ans[t] = (ans[t] - f[u] + mod) % mod;
  cnt[u] += v;
  sum[t][cnt[u]] = (sum[t][cnt[u]] + f[u]) % mod;
  if (cnt[u] + delta[t] <= m) ans[t] = (ans[t] + f[u]) % mod;
}
void add(int u, int v, int w) {
  if (u > v) return;
  int p = bel[u], q = bel[v];
  if (p + 1 >= q) {
    for (int i = u; i <= v; i++) update(i, w);
    return;
  }
  for (int i = u; bel[i] == p; i++) update(i, w);
  for (int i = v; bel[i] == q; i--) update(i, w);
  for (int i = p + 1; i < q; i++) {
    if (w > 0)
      if (m - delta[i] >= 0)
        ans[i] = (ans[i] - sum[i][m - delta[i]] + mod) % mod;
    delta[i] += w;
    if (w < 0)
      if (m - delta[i] >= 0) ans[i] = (ans[i] + sum[i][m - delta[i]]) % mod;
  }
}
int main() {
  scanf("%d%d", &n, &m);
  B = sqrt(n);
  bel[0] = 1;
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]), bel[i] = i / B + 1;
  f[0] = sum[1][0] = ans[1] = 1;
  for (int i = 1; i <= n; i++) {
    lst[i] = pos[a[i]];
    add(lst[lst[i]], lst[i] - 1, -1);
    add(lst[i], i - 1, 1);
    int j = i - 1;
    for (int j = i - 1; j >= 0 && bel[i] == bel[j]; j--)
      if (cnt[j] + delta[bel[i]] <= m) f[i] = (f[i] + f[j]) % mod;
    for (int j = bel[i] - 1; j; j--) f[i] = (f[i] + ans[j]) % mod;
    sum[bel[i]][0] = (sum[bel[i]][0] + f[i]) % mod;
    if (delta[bel[i]] <= m) ans[bel[i]] = (ans[bel[i]] + f[i]) % mod;
    pos[a[i]] = i;
  }
  printf("%d", f[n]);
}
