#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
int h[N], e[N], ne[N], idx;
void add(int a, int b) { e[idx] = b, ne[idx] = h[a], h[a] = idx++; }
int n, m;
bool vis[N];
bool nvis[N];
int dep[N];
int sz;
int check(int u) {
  vis[u] = true;
  nvis[u] = true;
  sz++;
  for (int i = h[u]; i != -1; i = ne[i]) {
    int j = e[i];
    if (vis[j] && !nvis[j]) return -1;
    if (vis[j]) continue;
    if (check(j) == -1) return -1;
  }
  nvis[u] = false;
  return sz;
}
int dfn[N], cnt[N];
bool bad[N];
int dfs1(int u) {
  vis[u] = 1;
  dfn[u] = u;
  for (int i = h[u]; i != -1; i = ne[i]) {
    int j = e[i];
    if (!vis[j]) {
      dep[j] = dep[u] + 1;
      int siz = dfs1(j);
      cnt[u] += siz;
      if (dep[dfn[u]] > dep[dfn[j]]) dfn[u] = dfn[j];
    } else {
      cnt[u]++;
      cnt[j]--;
      if (dep[dfn[u]] > dep[j]) dfn[u] = j;
    }
  }
  if (cnt[u] > 1) bad[u] = true;
  return cnt[u];
}
vector<int> ans;
void dfs2(int u) {
  vis[u] = true;
  if (!bad[u] && bad[dfn[u]]) bad[u] = true;
  for (int i = h[u]; i != -1; i = ne[i]) {
    int j = e[i];
    if (!vis[j]) dfs2(j);
  }
}
int main() {
  int T;
  cin >> T;
  while (T--) {
    mt19937 R(600000);
    cin >> n >> m;
    memset(cnt, 0, sizeof(int) * (n << 1));
    memset(dfn, 0, sizeof(int) * (n << 1));
    memset(bad, 0, sizeof(bool) * (n << 1));
    memset(dep, 0, sizeof(int) * (n << 1));
    memset(h, -1, sizeof(int) * (n << 1)), idx = 0;
    for (int i = 1; i <= m; i++) {
      int a, b;
      scanf("%d%d", &a, &b);
      add(a, b);
    }
    int r = 0;
    for (int i = 1; i <= 200; i++) {
      memset(vis, 0, sizeof(bool) * (n << 1));
      memset(nvis, 0, sizeof(int) * (n << 1));
      int u = 1ll * R() % n * R() % n + 1;
      sz = 0;
      if (check(u) == n) {
        r = u;
        break;
      }
    }
    sz = 0;
    if (!r) {
      cout << -1 << endl;
    } else {
      memset(vis, 0, sizeof(bool) * (n << 1));
      dfs1(r);
      memset(vis, 0, sizeof(bool) * (n << 1));
      dfs2(r);
      for (int i = 1; i <= n; i++)
        if (!bad[i]) ans.push_back(i);
      if (ans.size() * 5 >= n) {
        for (auto p : ans) cout << p << ' ';
        cout << endl;
      } else {
        cout << -1 << endl;
      }
    }
    ans.clear();
  }
}
