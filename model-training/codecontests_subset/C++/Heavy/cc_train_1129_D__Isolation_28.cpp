#include <bits/stdc++.h>
using namespace std;
int n, m, Siz, num[100010], pos[100010], bel[100010], lst[100010], f[100010],
    cnt[100010], delta[100010], ans[100010], sum[440][100010];
void update(int u, int v) {
  int t = bel[u];
  sum[t][cnt[u]] = (sum[t][cnt[u]] - f[u] + 998244353) % 998244353;
  if (cnt[u] + delta[t] <= m) ans[t] = (ans[t] - f[u] + 998244353) % 998244353;
  cnt[u] += v, sum[t][cnt[u]] = (sum[t][cnt[u]] + f[u]) % 998244353;
  if (cnt[u] + delta[t] <= m) ans[t] = (ans[t] + f[u]) % 998244353;
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
        ans[i] = (ans[i] - sum[i][m - delta[i]] + 998244353) % 998244353;
    delta[i] += w;
    if (w < 0)
      if (m - delta[i] >= 0)
        ans[i] = (ans[i] + sum[i][m - delta[i]]) % 998244353;
  }
}
int main() {
  scanf("%d%d", &n, &m), Siz = sqrt(n);
  for (int i = 0; i <= n; i++) bel[i] = i / Siz + 1;
  for (int i = 1; i <= n; i++) scanf("%d", &num[i]);
  f[0] = sum[1][0] = ans[1] = 1;
  for (int i = 1; i <= n; i++) {
    lst[i] = pos[num[i]], add(lst[lst[i]], lst[i] - 1, -1),
    add(lst[i], i - 1, 1);
    for (int j = i - 1; (~j) && bel[j] == bel[i]; j--)
      if (cnt[j] + delta[bel[i]] <= m) (f[i] += f[j]) %= 998244353;
    for (int j = bel[i] - 1; j; j--) (f[i] += ans[j]) %= 998244353;
    sum[bel[i]][0] = (sum[bel[i]][0] + f[i]) % 998244353;
    if (delta[bel[i]] <= m) ans[bel[i]] = (ans[bel[i]] + f[i]) % 998244353;
    pos[num[i]] = i;
  }
  printf("%d\n", f[n]);
}
