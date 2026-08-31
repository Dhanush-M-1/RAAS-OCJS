#include <bits/stdc++.h>
using namespace std;
const int N = 300005;
int n, m, q;
vector<int> g[N];
int par[N], siz[N], val[N];
bitset<N> vis;
pair<int, int> dfs(int v, int p) {
  vis[v] = 1;
  pair<int, int> mx = {0, v};
  for (auto x : g[v]) {
    if (x == p) continue;
    auto xx = dfs(x, v);
    if (xx.first + 1 > mx.first) mx = {xx.first + 1, xx.second};
  }
  return mx;
}
long long get1(int v) { return par[v] == v ? v : par[v] = get1(par[v]); }
void merge1(int x, int y) {
  x = get1(x);
  y = get1(y);
  if (x == y) return;
  if (siz[x] < siz[y]) swap(x, y);
  par[y] = par[x];
  siz[x] += siz[y];
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> m >> q;
  for (int i = 0; i < N; i++) par[i] = i, siz[i] = 1;
  ;
  int x, y;
  for (int i = 0; i < m; i++) {
    cin >> x >> y;
    g[x].push_back(y);
    g[y].push_back(x);
    merge1(x, y);
  }
  for (int i = 1; i <= n; i++) {
    if (vis[i]) continue;
    auto x = dfs(i, i);
    x = dfs(x.second, x.second);
    int xx = get1(x.second);
    val[xx] = x.first;
  }
  int ch;
  for (int i = 0; i < q; i++) {
    cin >> ch;
    if (ch == 1) {
      cin >> x;
      x = get1(x);
      cout << val[x] << endl;
      continue;
    }
    cin >> x >> y;
    x = get1(x), y = get1(y);
    if (x == y) continue;
    int mxx = max(max(val[x], val[y]),
                  (val[x] / 2 + val[x] % 2 + val[y] / 2 + val[y] % 2 + 1));
    merge1(x, y);
    x = par[x];
    val[x] = mxx;
  }
}
