#include <bits/stdc++.h>
using namespace std;
const int MX = 100005, LG = 18, mod = 1000000007;
int n, p[MX][LG], lvl[MX], q;
long long d[MX], d2[MX], sz[MX], sd[MX], sd2[MX], tor[MX];
vector<pair<int, long long> > adj[MX];
int LCA(int u, int v) {
  if (lvl[u] < lvl[v]) swap(u, v);
  for (int j = 0; j < LG; j++)
    if (lvl[u] - lvl[v] & (1 << j)) u = p[u][j];
  if (u == v) return u;
  for (int j = LG - 1; j >= 0; j--)
    if (p[u][j] != p[v][j]) {
      u = p[u][j];
      v = p[v][j];
    }
  return p[u][0];
}
void pre(int u) {
  sz[u] = 1;
  for (pair<int, long long> &v : adj[u])
    if (v.first != p[u][0]) {
      lvl[v.first] = lvl[u] + 1;
      p[v.first][0] = u;
      tor[v.first] = (tor[u] + v.second) % mod;
      pre(v.first);
      sz[u] += sz[v.first];
      (sd[u] += (sd[v.first] + sz[v.first] * v.second)) %= mod;
      (sd2[u] += (sd2[v.first] + 2 * sd[v.first] * v.second +
                  v.second * v.second % mod * sz[v.first])) %= mod;
    }
}
void dfs(int u) {
  for (pair<int, long long> &v : adj[u])
    if (v.first != p[u][0]) {
      d[v.first] = (d[u] + v.second * (n - 2 * sz[v.first])) % mod;
      d2[v.first] =
          (d2[u] +
           2 * v.second *
               (d[u] - 2 * (sd[v.first] + v.second * sz[v.first]) % mod) % mod +
           v.second * v.second % mod * n) %
          mod;
      dfs(v.first);
    }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 0; i < n - 1; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    adj[a].emplace_back(b, c);
    adj[b].emplace_back(a, c);
  }
  p[1][0] = 1;
  pre(1);
  for (int j = 1; j < LG; j++)
    for (int i = 1; i <= n; i++) p[i][j] = p[p[i][j - 1]][j - 1];
  d[1] = sd[1];
  d2[1] = sd2[1];
  dfs(1);
  cin >> q;
  while (q--) {
    int u, v;
    cin >> u >> v;
    int lca = LCA(u, v);
    long long res = lca == v ? d2[u] : -d2[u];
    long long dis = (tor[u] + tor[v] - 2 * tor[lca]) % mod;
    if (lca == v) {
      (res -= 2 * (((d2[v] - sd2[v]) + 2 * (d[v] - sd[v]) * dis +
                    dis * dis % mod * (n - sz[v])) %
                   mod)) %= mod;
    } else {
      (res +=
       2 * ((sd2[v] + 2 * sd[v] * dis + dis * dis % mod * sz[v]) % mod)) %= mod;
    }
    cout << ((((res) % (mod)) + (mod)) % (mod)) << '\n';
  }
  return 0;
}
