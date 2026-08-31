#include <bits/stdc++.h>
using namespace std;
pair<int, int> it;
int n, f[3010], x, y, fa[3010], dep[3010], tot, L[3010], t, tmp[3010],
    num[3010], belong[3010];
vector<int> E[3010];
int dis[3010][3010];
bool vis[3010];
queue<int> h;
void read(int &x) {
  char ch = getchar();
  int mark = 1;
  for (; ch != '-' && (ch < '0' || ch > '9'); ch = getchar())
    ;
  if (ch == '-') mark = -1, ch = getchar();
  for (x = 0; ch >= '0' && ch <= '9'; ch = getchar()) x = x * 10 + ch - 48;
  x *= mark;
}
int find(int x) { return (f[x] == x) ? x : f[x] = find(f[x]); }
void Union(int x, int y) { f[find(y)] = find(x); }
void dfs(int u) {
  vis[u] = 1;
  for (int i = 0; i < E[u].size(); i++) {
    int v = E[u][i];
    if (!vis[v]) dep[v] = dep[u] + 1, fa[v] = u, dfs(v);
  }
}
void Dfs(int u, int st) {
  vis[u] = 1;
  belong[u] = st;
  for (int i = 0; i < E[u].size(); i++) {
    int v = E[u][i];
    if (!vis[v]) Dfs(v, st);
  }
}
void bfs(int st) {
  memset(vis, 0, sizeof(vis));
  vis[st] = 1;
  dis[st][st] = 0;
  h.push(st);
  while (h.size()) {
    int u = h.front();
    h.pop();
    for (int i = 0; i < E[u].size(); i++) {
      int v = E[u][i];
      if (!vis[v]) {
        vis[v] = 1;
        dis[st][v] = dis[st][u] + 1;
        h.push(v);
      }
    }
  }
}
double Get(int x, int y) {
  if (x == y) return 1;
  if (belong[x] == belong[y]) return (double)1 / (dis[x][y] + 1);
  double X = dis[x][belong[x]] + dis[y][belong[y]];
  double Y = (num[belong[x]] - num[belong[y]] + tot) % tot + 1;
  double Z = (num[belong[y]] - num[belong[x]] + tot) % tot + 1;
  return ((Z - 2) / (X + Y) + (Y - 2) / (X + Z) + 1) / (X + Y + Z - 2);
}
int main() {
  read(n);
  for (int i = 1; i <= n; i++) f[i] = i;
  for (int i = 1; i <= n; i++) {
    read(x);
    read(y);
    x++;
    y++;
    if (find(x) != find(y)) {
      Union(x, y);
      E[x].push_back(y), E[y].push_back(x);
    } else
      it = make_pair(x, y);
  }
  dfs(1);
  x = it.first, y = it.second;
  if (dep[x] < dep[y]) swap(x, y);
  for (; dep[x] != dep[y]; x = fa[x]) L[++tot] = x;
  for (; x != y; x = fa[x], y = fa[y]) L[++tot] = x, tmp[++t] = y;
  L[++tot] = x;
  for (int i = t; i; i--) L[++tot] = tmp[i];
  memset(vis, 0, sizeof(vis));
  for (int i = 1; i <= tot; i++) num[L[i]] = i, vis[L[i]] = 1;
  for (int i = 1; i <= tot; i++) Dfs(L[i], L[i]);
  for (int i = 1; i <= n; i++) bfs(i);
  double ans = 0;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) ans += Get(i, j);
  printf("%.9lf\n", ans);
  return 0;
}
