#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 100;
const int LOG = 20;
const int MOD = 1e9 + 7;
int s_time[MAXN], f_time[MAXN];
int from[MAXN], to[MAXN], we[MAXN];
int n, q;
int v, u, w;
long long num;
long long sum_up[3][MAXN], sum_down[3][MAXN];
long long sum_total[MAXN];
int par[LOG + 5][MAXN];
int row[MAXN];
vector<int> adj[MAXN];
bool is_child(int u, int v) {
  return (s_time[v] <= s_time[u] && f_time[u] <= f_time[v]);
}
int get_par(int k, int v) {
  for (int i = 0; i < 20; i++)
    if (k & (1 << i)) v = par[i][v];
  return v;
}
int lca(int u, int v) {
  if (row[u] > row[v]) swap(u, v);
  v = get_par(row[v] - row[u], v);
  if (u == v) return u;
  for (int i = LOG; i >= 0; i--)
    if (par[i][v] != par[i][u]) {
      u = par[i][u];
      v = par[i][v];
    }
  return par[0][v];
}
void dfs_down(int p, int v) {
  s_time[v] = num++;
  sum_down[0][v]++;
  par[0][v] = p;
  for (int i = 1; i < LOG; i++) par[i][v] = par[i - 1][par[i - 1][v]];
  for (int i = 0; i < ((int)adj[v].size()); i++) {
    int id = adj[v][i];
    long long w = we[id];
    int u = from[id] + to[id] - v;
    if (u == p) continue;
    row[u] = row[v] + 1;
    dfs_down(v, u);
    sum_down[0][v] += sum_down[0][u];
    sum_down[1][v] += sum_down[1][u] + (w * sum_down[0][u]);
    sum_down[2][v] += (w * w % MOD * sum_down[0][u]) + sum_down[2][u] +
                      (2 * w * sum_down[1][u]);
    sum_down[0][v] %= MOD;
    sum_down[1][v] %= MOD;
    sum_down[2][v] %= MOD;
  }
  f_time[v] = num;
}
void dfs_up(int p, int v) {
  for (int i = 0; i < ((int)adj[v].size()); i++) {
    int id = adj[v][i];
    long long w = we[id];
    int u = from[id] + to[id] - v;
    if (u == p) continue;
    sum_total[u] = (sum_total[v] + w) % MOD;
    sum_up[0][u] = n - sum_down[0][u];
    sum_up[1][u] = sum_up[1][v] + sum_down[1][v] - sum_down[1][u] -
                   (w * sum_down[0][u]) % MOD + (sum_up[0][u] * w) % MOD;
    sum_up[2][u] = (sum_up[0][u] * w % MOD * w) % MOD + sum_up[2][v] +
                   sum_down[2][v] - sum_down[2][u] -
                   2 * w % MOD * sum_down[1][u] -
                   w * w % MOD * sum_down[0][u] % MOD +
                   (2 * w % MOD *
                    ((sum_up[1][v] + sum_down[1][v] - sum_down[1][u] -
                      sum_down[0][u] * w) %
                     MOD));
    sum_up[0][u] %= MOD;
    sum_up[1][u] %= MOD;
    sum_up[2][u] %= MOD;
    dfs_up(v, u);
  }
}
long long calc_1(int u, int v) {
  long long y = (sum_total[u] + sum_total[v] - 2 * sum_total[lca(u, v)]) % MOD;
  long long s =
      (sum_up[2][v] + 2 * y % MOD * sum_up[1][v] + y * y % MOD * sum_up[0][v]) %
      MOD;
  long long tot = (sum_down[2][u] + sum_up[2][u]) % MOD;
  return ((tot - 2 * s) % MOD + MOD) % MOD;
}
long long calc_2(int u, int v) {
  long long y = sum_total[u] + sum_total[v] - 2 * sum_total[lca(u, v)];
  long long s = sum_down[2][v] + 2 * y % MOD * sum_down[1][v] % MOD +
                y * y % MOD * sum_down[0][v] % MOD;
  long long tot = sum_down[2][u] + sum_up[2][u];
  return ((s - (tot - s)) % MOD + MOD) % MOD;
}
int main() {
  ios::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    cin >> u >> v >> w;
    u--, v--;
    adj[u].push_back(i);
    adj[v].push_back(i);
    from[i] = u;
    to[i] = v;
    we[i] = w;
  }
  dfs_down(0, 0);
  dfs_up(0, 0);
  cin >> q;
  while (q--) {
    cin >> u >> v;
    u--;
    v--;
    if (is_child(u, v))
      cout << calc_1(u, v);
    else
      cout << calc_2(u, v);
    cout << "\n";
  }
  return 0;
}
