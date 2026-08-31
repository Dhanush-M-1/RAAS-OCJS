#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
vector<int> g[maxn];
int dp[maxn];
int n;
struct Edge {
  int u, v, next;
} edge[maxn * 10];
int head[maxn];
int tot = 0;
void init() {
  memset(head, -1, sizeof(head));
  tot = 0;
}
void addedge(int u, int v) {
  edge[tot] = Edge{u, v, head[u]};
  head[u] = tot++;
}
void dfs1(int u, int pre) {
  dp[u] = 1;
  for (int i = 0; i < g[u].size(); i++) {
    int v = g[u][i];
    if (v == pre) continue;
    dfs1(v, u);
    dp[u] += dp[v];
  }
}
int in[maxn];
void dfs2(int u, int pre) {
  for (int i = 0; i < g[u].size(); i++) {
    int v = g[u][i];
    if (dp[v] % 2 == 0) {
      addedge(v, u);
      in[u]++;
    } else {
      addedge(u, v);
      in[v]++;
    }
    dfs2(v, u);
  }
}
void bfs() {
  cout << "YES\n";
  queue<int> q;
  for (int i = 1; i <= n; i++) {
    if (in[i] == 0) {
      q.push(i);
    }
  }
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    cout << u << endl;
    for (int i = head[u]; ~i; i = edge[i].next) {
      int v = edge[i].v;
      in[v]--;
      if (!in[v]) {
        q.push(v);
      }
    }
  }
}
int p[maxn];
int main() {
  cin >> n;
  int rt = -1;
  for (int i = 1; i <= n; i++) cin >> p[i];
  if (n % 2 == 0) {
    cout << "NO\n";
    return 0;
  }
  for (int i = 1; i <= n; i++) {
    if (p[i] == 0) rt = i;
    g[p[i]].push_back(i);
  }
  dfs1(rt, -1);
  init();
  dfs2(rt, -1);
  bfs();
  return 0;
}
