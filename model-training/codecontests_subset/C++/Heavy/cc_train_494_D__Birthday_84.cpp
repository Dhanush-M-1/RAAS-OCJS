#include <bits/stdc++.h>
using namespace std;
const int md = 1000000007;
int n, a[200009], b[200009], c[200009], used[100009], cnt[100009], s1[100009],
    s1c[100009], s2[100009], s2c[100009], par[19][100009];
int val[19][100009], q, dep[100009];
vector<int> adj[100009];
inline void Dfs1(int x) {
  used[x] = 1;
  cnt[x] = 1;
  for (int i = 0; i < adj[x].size(); i++) {
    int id = adj[x][i];
    if (!used[b[id]]) {
      par[0][b[id]] = x;
      val[0][b[id]] = c[id];
      dep[b[id]] = dep[x] + 1;
      Dfs1(b[id]);
      cnt[x] += cnt[b[id]];
      s1c[x] = (s1c[x] + s1c[b[id]] + (long long)c[id] * cnt[b[id]]) % md;
      s2c[x] =
          (s2c[x] + s2c[b[id]] + (long long)c[id] * c[id] % md * cnt[b[id]] +
           2ll * c[id] * s1c[b[id]]) %
          md;
    }
  }
  used[x] = 0;
}
inline void Dfs2(int x) {
  used[x] = 1;
  for (int i = 0; i < adj[x].size(); i++) {
    int id = adj[x][i];
    if (!used[b[id]]) {
      int tmpcnt = n - cnt[b[id]];
      int tmp1 = (s1[x] - s1c[b[id]] - (long long)c[id] * cnt[b[id]]) % md;
      int tmp2 =
          (s2[x] - s2c[b[id]] - (long long)c[id] * c[id] % md * cnt[b[id]] -
           2ll * c[id] * s1c[b[id]]) %
          md;
      s1[b[id]] = (s1c[b[id]] + tmp1 + (long long)c[id] * tmpcnt) % md;
      s2[b[id]] = (s2c[b[id]] + tmp2 + (long long)c[id] * c[id] % md * tmpcnt +
                   2ll * c[id] * tmp1) %
                  md;
      Dfs2(b[id]);
    }
  }
  used[x] = 0;
}
pair<int, int> Lca(int x, int y) {
  if (dep[x] < dep[y]) {
    swap(x, y);
  }
  int sum = 0;
  for (int i = 17; i >= 0; i--) {
    if (dep[par[i][x]] >= dep[y]) {
      sum = (sum + val[i][x]) % md;
      x = par[i][x];
    }
  }
  if (x == y) {
    return make_pair(x, sum);
  }
  for (int i = 17; i >= 0; i--) {
    if (par[i][x] != par[i][y]) {
      sum = (sum + val[i][x]) % md;
      sum = (sum + val[i][y]) % md;
      x = par[i][x];
      y = par[i][y];
    }
  }
  sum = (sum + val[0][x]) % md;
  sum = (sum + val[0][y]) % md;
  return make_pair(par[0][x], sum);
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cin >> n;
  for (int i = 1; i < n; i++) {
    cin >> a[i] >> b[i] >> c[i];
    a[i + n - 1] = b[i];
    b[i + n - 1] = a[i];
    c[i + n - 1] = c[i];
    adj[a[i]].push_back(i);
    adj[b[i]].push_back(i + n - 1);
  }
  dep[1] = 1;
  Dfs1(1);
  s1[1] = s1c[1];
  s2[1] = s2c[1];
  Dfs2(1);
  for (int i = 1; i <= 17; i++) {
    for (int j = 1; j <= n; j++) {
      par[i][j] = par[i - 1][par[i - 1][j]];
      val[i][j] = (val[i - 1][j] + val[i - 1][par[i - 1][j]]) % md;
    }
  }
  cin >> q;
  for (int iQ = 1; iQ <= q; iQ++) {
    int x, y;
    cin >> x >> y;
    pair<int, int> l = Lca(x, y);
    if (l.first == y) {
      cout << ((s2[x] - 2ll * l.second * l.second % md * (n - cnt[y]) -
                2ll * (s2[y] - s2c[y]) - 4ll * l.second * (s1[y] - s1c[y])) %
                   md +
               md) %
                  md
           << "\n";
    } else {
      cout << ((-s2[x] + 2ll * l.second * l.second % md * cnt[y] +
                2ll * s2c[y] + 4ll * l.second * s1c[y]) %
                   md +
               md) %
                  md
           << "\n";
    }
  }
  return 0;
}
