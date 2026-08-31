#include <bits/stdc++.h>
using namespace std;
int par[300005];
vector<int> v[300005];
int parent(int x) {
  if (x == par[x]) return x;
  return par[x] = parent(par[x]);
}
void join(int x, int y) {
  x = parent(x);
  y = parent(y);
  par[x] = y;
}
int dis[300005][2], dia[300005];
int bfs(int x, bool f) {
  queue<int> q;
  q.push(x);
  dis[x][f] = 0;
  while (!q.empty()) {
    x = q.front();
    q.pop();
    for (auto nxt : v[x]) {
      if (dis[nxt][f] == -1) {
        dis[nxt][f] = dis[x][f] + 1;
        q.push(nxt);
      }
    }
  }
  return x;
}
void mer(int x, int y) {
  x = parent(x);
  y = parent(y);
  if (x == y) return;
  int mx = max(dia[x], dia[y]);
  mx = max(mx, (dia[x] + 1) / 2 + (dia[y] + 1) / 2 + 1);
  par[x] = y;
  dia[y] = mx;
}
int main() {
  int n, m, q;
  while (cin >> n >> m >> q) {
    memset(dis, -1, sizeof dis);
    for (int i = 0; i <= n; ++i) par[i] = i;
    for (int i = 0; i < m; ++i) {
      int fr, to;
      scanf("%d%d", &fr, &to);
      v[fr].push_back(to);
      v[to].push_back(fr);
      join(fr, to);
    }
    for (int i = 1; i <= n; ++i) {
      if (par[i] != i) continue;
      int x = bfs(i, 0);
      dia[i] = dis[bfs(x, 1)][1];
    }
    while (q--) {
      int cmd, x, y;
      scanf("%d%d", &cmd, &x);
      if (cmd == 1) {
        x = parent(x);
        printf("%d\n", dia[x]);
        continue;
      }
      scanf("%d", &y);
      mer(x, y);
    }
  }
}
