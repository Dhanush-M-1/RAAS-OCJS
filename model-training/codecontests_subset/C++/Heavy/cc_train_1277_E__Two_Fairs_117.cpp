#include <bits/stdc++.h>
#pragma GCC optimize(2)
using namespace std;
const int INF = 0x3f3f3f3f;
const int MAXN = 2e5 + 5;
const int MAXM = 1e6 + 5;
const int MOD = 1e9 + 7;
const int dir[4][2] = {1, 0, -1, 0, 0, 1, 0, -1};
const double PI = acos(-1.0);
const double EXP = 1e-8;
struct Edge {
  int to, next;
} edge[MAXM];
int head[MAXN], tot;
void add_edge(int u, int v) {
  edge[++tot].to = v;
  edge[tot].next = head[u];
  head[u] = tot;
}
bool vis[MAXN];
int belong[MAXN], scc;
int block[MAXN], du[2][MAXN];
int a, b, n, m;
void init() {
  for (int i = 1; i <= n; i++) vis[i] = false, head[i] = 0;
  tot = scc = 0;
}
void dfs(int u) {
  vis[u] = true;
  belong[u] = scc;
  block[scc]++;
  for (int i = head[u]; i; i = edge[i].next) {
    int v = edge[i].to;
    if (v == a)
      if (!du[0][belong[u]]) du[0][belong[u]] = true;
    if (v == b)
      if (!du[1][belong[u]]) du[1][belong[u]] = true;
    if (!vis[v]) dfs(v);
  }
}
int main(void) {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    cin >> n >> m >> a >> b;
    init();
    for (int i = 1; i <= m; i++) {
      int u, v;
      cin >> u >> v;
      add_edge(u, v);
      add_edge(v, u);
    }
    vis[a] = vis[b] = true;
    for (int i = 1; i <= n; i++) {
      if (i == a || i == b) continue;
      if (!vis[i]) {
        belong[++scc] = 0;
        block[scc] = 0;
        du[0][scc] = 0;
        du[1][scc] = 0;
        dfs(i);
      }
    }
    long long left = 0, right = 0;
    if (scc == 1)
      cout << 0 << endl;
    else {
      for (int i = 1; i <= scc; i++) {
        if (du[0][i] && du[1][i]) continue;
        if (du[0][i]) left += block[i];
        if (du[1][i]) right += block[i];
      }
      cout << left * right << endl;
    }
  }
  return 0;
}
