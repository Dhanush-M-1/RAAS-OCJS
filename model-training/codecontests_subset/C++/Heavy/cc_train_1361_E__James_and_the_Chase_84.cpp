#include <bits/stdc++.h>
using namespace std;
mt19937 rnnnd(chrono::steady_clock::now().time_since_epoch().count());
inline int read() {
  int x = 0, f = 1, c = getchar();
  while (!isdigit(c)) {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (isdigit(c)) {
    x = (x << 1) + (x << 3) + (c ^ 48);
    c = getchar();
  }
  return f == 1 ? x : -x;
}
const int N = 1e5 + 4;
int n, m, c[N], vis[N], dep[N], up1[N], up2[N];
vector<int> e[N], ans;
void upd(int x, int v) {
  if (!v || dep[v] >= dep[x]) return;
  if (!up1[x] || dep[v] < dep[up1[x]]) {
    up2[x] = up1[x];
    up1[x] = v;
  } else if (!up2[x] || dep[v] < dep[up2[x]])
    up2[x] = v;
}
bool dfs_1(int x) {
  vis[x] = 2;
  for (auto v : e[x]) {
    if (!vis[v]) {
      dep[v] = dep[x] + 1;
      if (dfs_1(v)) return 1;
      upd(x, up1[v]);
      upd(x, up2[v]);
    } else if (vis[v] == 1)
      return 1;
    else
      upd(x, v);
  }
  vis[x] = 1;
  return 0;
}
void dfs_3(int x) {
  vis[x] = 3;
  if (!up1[x] || (!up2[x] && up1[up1[x]])) {
    up1[x] = 1;
    ans.push_back(x);
  } else
    up1[x] = 0;
  for (auto v : e[x])
    if (vis[v] != 3) dfs_3(v);
}
inline void solve() {
  for (int i = 1; i <= n; i++) e[i].clear();
  n = read();
  m = read();
  for (int i = 1, u, v; i <= m; i++) {
    u = read();
    v = read();
    e[u].push_back(v);
  }
  for (int i = 1; i <= n; i++) c[i] = i;
  shuffle(c + 1, c + n + 1, rnnnd);
  for (int i = 1; i <= min(n, 100); i++) {
    memset(vis, 0, sizeof(int) * (n + 1));
    memset(up1, 0, sizeof(int) * (n + 1));
    memset(up2, 0, sizeof(int) * (n + 1));
    memset(dep, 0, sizeof(int) * (n + 1));
    if (dfs_1(c[i])) continue;
    dfs_3(c[i]);
    if (ans.size() * 5 >= n) {
      sort(ans.begin(), ans.end());
      for (auto v : ans) cout << v << " ";
      puts("");
    } else
      puts("-1");
    ans.clear();
    return;
  }
  puts("-1");
}
int main() {
  for (int T = read(); T--;) solve();
  return (0 - 0);
}
