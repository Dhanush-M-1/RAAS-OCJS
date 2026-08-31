#include <bits/stdc++.h>
using namespace std;
int n, m, q, dia[300005], rad[300005], par[300005];
bool vis[300005];
int rt;
vector<int> V[300005];
void dfs(int id) {
  vis[id] = true;
  par[id] = rt;
  rad[id] = dia[id] = 0;
  for (int i = 0; i < V[id].size(); i++) {
    int to = V[id][i];
    if (vis[to]) continue;
    dfs(to);
    dia[id] = max(dia[id], dia[to]);
    dia[id] = max(dia[id], rad[id] + rad[to] + 1);
    if (rad[to] + 1 > rad[id]) rad[id] = rad[to] + 1;
  }
  return;
}
int f(int x) {
  if (par[x] == x)
    return x;
  else
    return par[x] = f(par[x]);
}
void merge(int a, int b) {
  int fa = f(a);
  int fb = f(b);
  if (fa == fb) return;
  int nd =
      max(max(dia[fa], dia[fb]), (dia[fa] + 1) / 2 + (dia[fb] + 1) / 2 + 1);
  dia[fa] = 0;
  par[fa] = fb;
  dia[fb] = nd;
  return;
}
int main() {
  scanf("%d %d %d", &n, &m, &q);
  for (int i = 1; i <= m; i++) {
    int a, b;
    scanf("%d %d", &a, &b);
    V[a].push_back(b);
    V[b].push_back(a);
  }
  memset(vis, 0, sizeof(vis));
  for (int i = 1; i <= n; i++) {
    if (!vis[i]) {
      rt = i;
      dfs(i);
    }
  }
  for (int i = 1; i <= n; i++) {
    if (par[i] != i) {
      dia[i] = 0;
    }
  }
  for (int i = 1; i <= q; i++) {
    int a, b, c;
    scanf("%d", &a);
    if (a == 1) {
      scanf("%d", &b);
      int fb = f(b);
      printf("%d\n", dia[fb]);
    } else {
      scanf("%d %d", &b, &c);
      merge(b, c);
    }
  }
  return 0;
}
