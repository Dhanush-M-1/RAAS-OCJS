#include <bits/stdc++.h>
using namespace std;
int father[20][300005], lv[300005], n;
long long dis[300005];
vector<int> e[300005], ev[300005];
void init(int x, int lt) {
  father[0][x] = lt;
  for (int i = 0; i < ((int)(e[x]).size()); ++i) {
    int y = e[x][i];
    if (y != lt) {
      dis[y] = dis[x] + ev[x][i];
      lv[y] = lv[x] + 1;
      init(y, x);
    }
  }
}
int adv(int x, int v) {
  for (int i = 0; (1 << i) <= v; i++) {
    if ((v >> i) & 1) x = father[i][x];
  }
  return x;
}
int lca(int x, int y) {
  if (lv[x] > lv[y])
    x = adv(x, lv[x] - lv[y]);
  else
    y = adv(y, lv[y] - lv[x]);
  if (x == y) return x;
  for (int i = 19; i >= 0; i--)
    if (father[i][x] != father[i][y]) {
      x = father[i][x];
      y = father[i][y];
    }
  return father[0][x];
}
void build() {
  init(1, 1);
  for (int i = (1); i < (20); ++i) {
    for (int x = (1); x < (n + 1); ++x)
      father[i][x] = father[i - 1][father[i - 1][x]];
  }
}
int num[300005], sum[300005], sum2[300005], all_sum[300005], all_sum2[300005];
void add(int &x, long long v) { x = (x + v) % 1000000007; }
void dfs0(int x, int lt) {
  num[x] = 1;
  for (int i = 0; i < ((int)(e[x]).size()); ++i) {
    int y = e[x][i];
    if (y == lt) continue;
    dfs0(y, x);
    num[x] += num[y];
    sum[x] = (sum[x] + sum[y] + (long long)num[y] * ev[x][i]) % 1000000007;
    sum2[x] = (sum2[x] + sum2[y] + (long long)sum[y] * 2 * ev[x][i] +
               (long long)ev[x][i] * ev[x][i] % 1000000007 * num[y]) %
              1000000007;
  }
}
void dfs1(int x, int lt, long long v1, long long v2) {
  v1 %= 1000000007;
  v2 %= 1000000007;
  if (v1 < 0) v1 += 1000000007;
  if (v2 < 0) v2 += 1000000007;
  all_sum[x] = sum[x];
  all_sum2[x] = sum2[x];
  add(all_sum[x], v1);
  add(all_sum2[x], v2);
  for (int i = 0; i < ((int)(e[x]).size()); ++i) {
    int y = e[x][i];
    if (y == lt) continue;
    dfs1(y, x,
         v1 + (long long)(n - num[y]) * ev[x][i] % 1000000007 + sum[x] -
             sum[y] - (long long)num[y] * ev[x][i] % 1000000007,
         all_sum2[x] - sum2[y] - sum[y] * 2LL * ev[x][i] % 1000000007 -
             (long long)ev[x][i] * ev[x][i] % 1000000007 * num[y] +
             (long long)(n - num[y]) * ev[x][i] % 1000000007 * ev[x][i] %
                 1000000007 +
             2LL * ev[x][i] *
                 (v1 + sum[x] - sum[y] -
                  (long long)num[y] * ev[x][i] % 1000000007) %
                 1000000007);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = (1); i < (n); ++i) {
    int x, y, v;
    scanf("%d%d%d", &x, &y, &v);
    e[x].push_back(y);
    ev[x].push_back(v);
    e[y].push_back(x);
    ev[y].push_back(v);
  }
  build();
  dfs0(1, 1);
  dfs1(1, 1, 0, 0);
  int Q;
  scanf("%d", &Q);
  while (Q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    int me = lca(u, v);
    int an = 0;
    long long dd = dis[u] + dis[v] - 2 * dis[me];
    dd %= 1000000007;
    if (me != v) {
      an = -all_sum2[u] % 1000000007;
      add(an, (sum2[v] + dd * dd % 1000000007 * num[v] % 1000000007 +
               dd * 2LL * sum[v] % 1000000007) *
                  2);
    } else {
      an = all_sum2[u];
      add(an, (all_sum2[v] - sum2[v] +
               dd * dd % 1000000007 * (n - num[v]) % 1000000007 +
               dd * 2LL * (all_sum[v] - sum[v]) % 1000000007) *
                  -2);
    }
    if (an < 0) an += 1000000007;
    printf("%d\n", an);
  }
}
