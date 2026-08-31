#include <bits/stdc++.h>
using namespace std;
int n, m, B, a[100005], pos[100005], bel[100005], lst[100005], f[100005],
    cnt[100005];
int delta[450], ans[450], sum[450][100005];
void Update(int u, int v) {
  int t = bel[u];
  sum[t][cnt[u]] = (sum[t][cnt[u]] - f[u] + 998244353) % 998244353;
  if (cnt[u] + delta[t] <= m) ans[t] = (ans[t] - f[u] + 998244353) % 998244353;
  cnt[u] += v;
  sum[t][cnt[u]] = (sum[t][cnt[u]] + f[u]) % 998244353;
  if (cnt[u] + delta[t] <= m) ans[t] = (ans[t] + f[u]) % 998244353;
}
void Add(int u, int v, int w) {
  if (u > v) return;
  int p = bel[u], q = bel[v];
  if (p + 1 >= q) {
    for (int i = u; i <= v; i++) Update(i, w);
    return;
  }
  for (int i = u; bel[i] == p; i++) Update(i, w);
  for (int i = v; bel[i] == q; i--) Update(i, w);
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
  scanf("%d%d", &n, &m);
  B = sqrt(n);
  bel[0] = 1;
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]), bel[i] = i / B + 1;
  f[0] = sum[1][0] = ans[1] = 1;
  for (int i = 1; i <= n; i++) {
    lst[i] = pos[a[i]];
    Add(lst[lst[i]], lst[i] - 1, -1);
    Add(lst[i], i - 1, 1);
    int j = i - 1;
    for (int j = i - 1; j >= 0 && bel[i] == bel[j]; j--)
      if (cnt[j] + delta[bel[i]] <= m) f[i] = (f[i] + f[j]) % 998244353;
    for (int j = bel[i] - 1; j; j--) f[i] = (f[i] + ans[j]) % 998244353;
    sum[bel[i]][0] = (sum[bel[i]][0] + f[i]) % 998244353;
    if (delta[bel[i]] <= m) ans[bel[i]] = (ans[bel[i]] + f[i]) % 998244353;
    pos[a[i]] = i;
  }
  printf("%d", f[n]);
}
