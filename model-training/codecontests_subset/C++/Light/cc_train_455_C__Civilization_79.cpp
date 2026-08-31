#include <bits/stdc++.h>
using namespace std;
const int maxn = 300100;
int read() {
  int x = 0, w = 1;
  char ch = 0;
  while (!isdigit(ch)) {
    ch = getchar();
    if (ch == '-') w = -1;
  }
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  return x * w;
}
vector<int> G[maxn];
int vis[maxn];
int fa[maxn], ans[maxn];
int findfa(int rt) { return rt == fa[rt] ? rt : fa[rt] = findfa(fa[rt]); }
void merge(int a, int b) {
  if (findfa(a) != findfa(b)) fa[fa[a]] = fa[b];
}
int tmp = 0, tmp2 = 0;
void dfs(int rt, int col, int res) {
  if (vis[rt] == col) return;
  if (res > tmp) tmp = res, tmp2 = rt;
  vis[rt] = col;
  for (int to : G[rt]) merge(rt, to), dfs(to, col, res + 1);
}
int main() {
  int n = read(), m = read(), q = read();
  for (int i = 1; i <= n; i++) fa[i] = i;
  while (m--) {
    int u = read(), v = read();
    G[u].push_back(v);
    G[v].push_back(u);
  }
  for (int i = 1; i <= n; i++)
    if (!vis[i]) {
      tmp = 0, tmp2 = i;
      dfs(i, i, 0);
      tmp = 0;
      dfs(tmp2, tmp2, 0);
      ans[findfa(i)] = tmp;
    }
  while (q--) {
    int opt = read();
    if (opt == 1)
      printf("%d\n", ans[findfa(read())]);
    else {
      int u = read(), v = read();
      u = findfa(u), v = findfa(v);
      if (u == v) continue;
      fa[u] = v;
      ans[v] =
          max(max(ans[v], ans[u]), (ans[u] + 1) / 2 + (ans[v] + 1) / 2 + 1);
    }
  }
}
