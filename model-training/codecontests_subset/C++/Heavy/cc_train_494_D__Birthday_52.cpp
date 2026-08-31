#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int> > E[100010];
int down[100010], vis[100010];
int n;
const int MOD = 1e9 + 7;
pair<int, int> S[100010];
pair<int, int> PP[100010];
void get_dfs(int x, int fa, int L, pair<int, int> &A) {
  down[x] = 1;
  A.first = (A.first + L) % MOD;
  A.second = (A.second + (long long)L * L) % MOD;
  for (auto e : E[x])
    if (e.second != fa && vis[e.second] == 0) {
      get_dfs(e.second, x, (L + e.first) % MOD, A);
      down[x] += down[e.second];
    }
}
void down_dfs(int x, int fa) {
  down[x] = 1;
  for (auto e : E[x])
    if (e.second != fa && vis[e.second] == 0) {
      down_dfs(e.second, x);
      down[x] += down[e.second];
    }
}
void put_dfs(int x, int fa, int L, pair<int, int> &A, int L0) {
  PP[x].second = (PP[x].second + A.second + A.first * 2LL * L +
                  ((long long)L * L) % MOD * L0) %
                 MOD;
  PP[x].first = (PP[x].first + A.first + (long long)L0 * L) % MOD;
  for (auto e : E[x])
    if (e.second != fa && vis[e.second] == 0) {
      put_dfs(e.second, x, (L + e.first) % MOD, A, L0);
    }
}
void Do(int x) {
  down_dfs(x, -1);
  int c = x, h = down[x] / 2;
  while (1) {
    int f = 0;
    for (auto e : E[c])
      if (vis[e.second] == 0 && down[e.second] < down[c] &&
          down[e.second] > h) {
        c = e.second;
        f = 1;
        break;
      }
    if (f == 0) break;
  }
  vector<int> near;
  vector<pair<int, int> > G;
  vector<int> lu;
  pair<int, int> tot = pair<int, int>(0, 0);
  int L0 = 1;
  for (auto e : E[c])
    if (!vis[e.second]) {
      near.push_back(e.second);
      pair<int, int> A = pair<int, int>(0, 0);
      get_dfs(e.second, c, e.first, A);
      G.push_back(A);
      lu.push_back(e.first);
      tot.first = (tot.first + A.first) % MOD;
      tot.second = (tot.second + A.second) % MOD;
      L0 += down[e.second];
    }
  for (int i = 0; i < (int)near.size(); i++) {
    int u = near[i];
    pair<int, int> A =
        pair<int, int>(tot.first - G[i].first, tot.second - G[i].second);
    if (A.first < 0) A.first += MOD;
    if (A.second < 0) A.second += MOD;
    put_dfs(u, c, lu[i], A, L0 - down[u]);
  }
  PP[c].second = (PP[c].second + tot.second) % MOD;
  PP[c].first = (PP[c].first + tot.first) % MOD;
  vis[c] = 1;
  for (int e : near) {
    Do(e);
  }
}
int dep[100010], ST[100010], EN[100010], ce;
int up[100010][20];
int Ldep[100010];
tuple<int, int, int> DP[100010];
void DFS(int x, int fa) {
  get<0>(DP[x]) = 1;
  ST[x] = ++ce;
  for (auto e : E[x])
    if (e.second != fa) {
      dep[e.second] = dep[x] + 1;
      Ldep[e.second] = (Ldep[x] + e.first) % MOD;
      up[e.second][0] = x;
      for (int i = 1; i < 20; i++)
        up[e.second][i] = up[up[e.second][i - 1]][i - 1];
      DFS(e.second, x);
      int L = e.first;
      int a0 = get<0>(DP[e.second]);
      int a1 = get<1>(DP[e.second]);
      int a2 = get<2>(DP[e.second]);
      get<0>(DP[x]) += a0;
      get<1>(DP[x]) = (a1 + get<1>(DP[x]) + (long long)L * a0) % MOD;
      get<2>(DP[x]) = (get<2>(DP[x]) + ((long long)L * L) % MOD * a0 +
                       (long long)2 * L * a1 + a2) %
                      MOD;
    }
  EN[x] = ce;
}
int lca(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  for (int i = 0; i < 20; i++)
    if (1 << i & (dep[x] - dep[y])) x = up[x][i];
  for (int i = 19; i >= 0; i--)
    if (up[x][i] != up[y][i]) x = up[x][i], y = up[y][i];
  return x == y ? x : up[x][0];
}
void solve() {
  scanf("%d", &n);
  for (int i = 0; i < n - 1; i++) {
    int x, y, z;
    scanf("%d%d%d", &x, &y, &z);
    E[x].push_back(pair<int, int>(z, y));
    E[y].push_back(pair<int, int>(z, x));
  }
  Do(1);
  DFS(1, -1);
  int q;
  scanf("%d", &q);
  while (q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    if (ST[v] <= ST[u] && ST[u] <= EN[v]) {
      long long ans = PP[u].second;
      long long C = 0;
      long long a0 = n;
      long long a1 = PP[v].first;
      long long a2 = PP[v].second;
      a0 -= get<0>(DP[v]);
      a1 -= get<1>(DP[v]);
      a2 -= get<2>(DP[v]);
      long long L = Ldep[u] - Ldep[v];
      if (L < 0) L += MOD;
      C += (L * L) % MOD * a0;
      C += 2LL * L * a1;
      C += a2;
      ans -= 2 * C;
      ans %= MOD;
      if (ans < 0) ans += MOD;
      printf("%lld\n", ans);
    } else {
      long long ans = -PP[u].second;
      int a0 = get<0>(DP[v]);
      int a1 = get<1>(DP[v]);
      int a2 = get<2>(DP[v]);
      int lc = lca(u, v);
      long long L = Ldep[u] + Ldep[v] - 2LL * Ldep[lc];
      if (L < 0) L += MOD;
      ans += 2LL * (L * L) % MOD * a0;
      ans += 4LL * L * a1;
      ans += 2LL * a2;
      ans %= MOD;
      if (ans < 0) ans += MOD;
      printf("%lld\n", ans);
    }
  }
}
int main() {
  int Tc = 1;
  for (int tc = 1; tc <= Tc; tc++) {
    solve();
  }
  return 0;
}
