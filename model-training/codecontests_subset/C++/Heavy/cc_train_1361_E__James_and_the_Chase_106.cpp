#include <bits/stdc++.h>
using namespace std;
const int N = 100010;
vector<int> G[N];
int vis[N], n;
bool flag;
void dfs(int x) {
  vis[x] = 1;
  for (int i = 0; i < G[x].size(); ++i) {
    int y = G[x][i];
    if (!vis[y])
      dfs(y);
    else if (vis[y] == 2)
      flag = 0;
  }
  vis[x] = 2;
}
bool check(int x) {
  for (int i = 1; i <= n; ++i) vis[i] = 0;
  flag = 1;
  dfs(x);
  return flag;
}
bool h[N];
int d[N], f[N], g[N];
int find(int x) {
  vis[x] = 1;
  g[x] = x;
  for (int i = 0; i < G[x].size(); ++i) {
    int y = G[x][i];
    if (!vis[y]) {
      d[y] = d[x] + 1;
      f[x] += find(y);
      if (d[g[y]] < d[g[x]]) g[x] = g[y];
    } else {
      f[x]++;
      f[y]--;
      if (d[y] < d[g[x]]) g[x] = y;
    }
  }
  if (f[x] > 1) h[x] = 1;
  return f[x];
}
void work(int x) {
  vis[x] = 1;
  if (!h[x] && h[g[x]]) h[x] = 1;
  for (int i = 0; i < G[x].size(); ++i) {
    int y = G[x][i];
    if (!vis[y]) work(y);
  }
}
int myrand() { return rand() % 10000 * 10000 + rand() % 10000; }
int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -f;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - 48;
    ch = getchar();
  }
  return x * f;
}
signed main() {
  srand((unsigned)time(NULL));
  int T = read();
  while (T-- > 0) {
    n = read();
    for (int i = 1; i <= n; ++i) G[i].clear();
    int m = read();
    for (int i = 1; i <= m; ++i) {
      int x = read(), y = read();
      G[x].push_back(y);
    }
    int rt = -1;
    for (int tm = 1; tm <= 100; ++tm) {
      int r = myrand() % n + 1;
      if (check(r)) {
        rt = r;
        break;
      }
    }
    if (rt == -1) {
      puts("-1");
      continue;
    }
    for (int i = 1; i <= n; ++i) {
      h[i] = vis[i] = g[i] = d[i] = f[i] = 0;
    }
    find(rt);
    for (int i = 1; i <= n; ++i) vis[i] = 0;
    work(rt);
    vector<int> ans;
    for (int i = 1; i <= n; ++i) {
      if (!h[i]) ans.push_back(i);
    }
    if (5 * (int)ans.size() >= n) {
      for (int i = 0; i < ans.size(); ++i) printf("%d ", ans[i]);
      putchar('\n');
    } else
      puts("-1");
  }
  return 0;
}
