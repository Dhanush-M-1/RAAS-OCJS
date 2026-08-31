#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
struct DSU {
  int par[MAXN], siz[MAXN];
  ;
  void init(int n) {
    for (int i = 0; i <= n; ++i) {
      par[i] = i;
      siz[i] = 1;
    }
  }
  int Find(int x) {
    if (par[x] != x) {
      par[x] = Find(par[x]);
    }
    return par[x];
  }
  void Union(int x, int y) {
    int xRt = Find(x), yRt = Find(y);
    if (xRt == yRt) {
      return;
    }
    if (siz[xRt] > siz[yRt]) {
      swap(xRt, yRt);
    }
    par[xRt] = yRt;
    siz[yRt] += siz[xRt];
  }
};
int n, m;
DSU dsu;
int a, b;
unordered_map<int, int> bit;
vector<int> ver[3];
int vis[MAXN];
void init() {
  dsu.init(n);
  ver[1].clear();
  ver[2].clear();
  bit.clear();
  bit[a] = 1;
  bit[b] = 2;
  memset(vis, 0, sizeof(int) * (n + 5));
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int T;
  cin >> T;
  while (T--) {
    cin >> n >> m >> a >> b;
    init();
    while (m--) {
      int u, v;
      cin >> u >> v;
      if (u == a && v == b || u == b && v == a) {
        continue;
      }
      if (u == a || u == b) {
        ver[bit[u]].push_back(v);
      } else if (v == a || v == b) {
        ver[bit[v]].push_back(u);
      } else {
        dsu.Union(u, v);
      }
    }
    for (int i = 1; i <= 2; ++i) {
      for (auto it : ver[i]) {
        vis[dsu.Find(it)] |= i;
      }
    }
    int ans[4] = {};
    for (int i = 1; i <= n; i++) {
      if (vis[dsu.Find(i)] != -1) {
        ans[vis[dsu.Find(i)]] += dsu.siz[dsu.Find(i)];
        vis[dsu.Find(i)] = -1;
      }
    }
    cout << 1LL * ans[1] * ans[2] << '\n';
  }
  return 0;
}
