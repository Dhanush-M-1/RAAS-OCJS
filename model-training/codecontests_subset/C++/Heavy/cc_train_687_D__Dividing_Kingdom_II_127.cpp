#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1010, MAXM = 500000;
struct edge {
  int u, v, w;
  int id;
  void read(int i) {
    scanf("%d %d %d", &u, &v, &w);
    u--;
    v--;
    id = i;
  }
};
bool operator<(edge e1, edge e2) { return e1.w < e2.w; }
int N, M, Q;
edge E[MAXM];
struct union_find {
  int par[MAXN];
  void reset() {
    for (int i = 0; i < N; i++) {
      par[i] = i;
    }
  }
  int find(int x) { return x == par[x] ? x : par[x] = find(par[x]); }
  bool merge(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) {
      return false;
    }
    par[x] = y;
    return true;
  }
} uf;
int col[MAXN];
vector<int> adj[MAXN];
void dfs(int x, int c) {
  if (col[x] != -1) {
    return;
  }
  col[x] = c;
  for (int t : adj[x]) {
    dfs(t, !c);
  }
}
int main() {
  scanf("%d %d %d", &N, &M, &Q);
  for (int i = 0; i < M; i++) {
    E[i].read(i);
  }
  sort(E, E + M);
  for (int qi = 0; qi < Q; qi++) {
    int x, y;
    scanf("%d %d", &x, &y);
    x--;
    uf.reset();
    memset(col, -1, sizeof(col));
    for (int i = 0; i < N; i++) {
      adj[i].clear();
    }
    for (int i = M - 1; i >= 0; i--) {
      if (E[i].id < x || E[i].id >= y) {
        continue;
      }
      int u = E[i].u, v = E[i].v;
      if (!uf.merge(u, v)) {
        continue;
      }
      adj[u].push_back(v);
      adj[v].push_back(u);
    }
    for (int i = 0; i < N; i++) {
      dfs(i, 0);
    }
    int ans = -1;
    for (int i = M - 1; i >= 0; i--) {
      if (E[i].id < x || E[i].id >= y) {
        continue;
      }
      if (col[E[i].u] == col[E[i].v]) {
        ans = E[i].w;
        break;
      }
    }
    printf("%d\n", ans);
  }
}
