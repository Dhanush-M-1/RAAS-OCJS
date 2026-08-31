#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const int SIZE = 3e5 + 10;
vector<int> e[SIZE], ev[SIZE];
int jump[20][SIZE], lv[SIZE], n;
long long dis[SIZE];
void init(int x, int lt) {
  jump[0][x] = lt;
  for (int i = 0; i < (((int)(e[x]).size())); ++i) {
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
    if ((v >> i) & 1) x = jump[i][x];
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
    if (jump[i][x] != jump[i][y]) {
      x = jump[i][x];
      y = jump[i][y];
    }
  return jump[0][x];
}
void build() {
  init(1, 1);
  for (int i = (1); i < (20); ++i) {
    for (int x = (1); x < (n + 1); ++x)
      jump[i][x] = jump[i - 1][jump[i - 1][x]];
  }
}
int num[SIZE], sum[SIZE], sum2[SIZE], all_sum[SIZE], all_sum2[SIZE];
void add(int &x, long long v) { x = (x + v) % MOD; }
void dfs0(int x, int lt) {
  num[x] = 1;
  for (int i = 0; i < (((int)(e[x]).size())); ++i) {
    int y = e[x][i];
    if (y == lt) continue;
    dfs0(y, x);
    num[x] += num[y];
    sum[x] = (sum[x] + sum[y] + (long long)num[y] * ev[x][i]) % MOD;
    sum2[x] = (sum2[x] + sum2[y] + (long long)sum[y] * 2 * ev[x][i] +
               (long long)ev[x][i] * ev[x][i] % MOD * num[y]) %
              MOD;
  }
}
void dfs1(int x, int lt, long long v1, long long v2) {
  v1 %= MOD;
  v2 %= MOD;
  if (v1 < 0) v1 += MOD;
  if (v2 < 0) v2 += MOD;
  all_sum[x] = sum[x];
  all_sum2[x] = sum2[x];
  add(all_sum[x], v1);
  add(all_sum2[x], v2);
  for (int i = 0; i < (((int)(e[x]).size())); ++i) {
    int y = e[x][i];
    if (y == lt) continue;
    dfs1(y, x,
         v1 + (long long)(n - num[y]) * ev[x][i] % MOD + sum[x] - sum[y] -
             (long long)num[y] * ev[x][i] % MOD,
         all_sum2[x] - sum2[y] - sum[y] * 2LL * ev[x][i] % MOD -
             (long long)ev[x][i] * ev[x][i] % MOD * num[y] +
             (long long)(n - num[y]) * ev[x][i] % MOD * ev[x][i] % MOD +
             2LL * ev[x][i] *
                 (v1 + sum[x] - sum[y] - (long long)num[y] * ev[x][i] % MOD) %
                 MOD);
  }
}
int main() {
  scanf("%d", &(n));
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
  int(Q);
  scanf("%d", &Q);
  while (Q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    int me = lca(u, v);
    int an = 0;
    long long dd = dis[u] + dis[v] - 2 * dis[me];
    dd %= MOD;
    if (me != v) {
      an = -all_sum2[u] % MOD;
      add(an,
          (sum2[v] + dd * dd % MOD * num[v] % MOD + dd * 2LL * sum[v] % MOD) *
              2);
    } else {
      an = all_sum2[u];
      add(an, (all_sum2[v] - sum2[v] + dd * dd % MOD * (n - num[v]) % MOD +
               dd * 2LL * (all_sum[v] - sum[v]) % MOD) *
                  -2);
    }
    if (an < 0) an += MOD;
    printf("%d\n", an);
  }
  return 0;
}
