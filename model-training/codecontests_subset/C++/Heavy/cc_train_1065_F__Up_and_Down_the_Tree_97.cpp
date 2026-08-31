#include <bits/stdc++.h>
using namespace std;
const int N = 1000050, INF = (int)1e9;
const int LOG_N = 20;
int root = 0;
int n, m, a, b;
int val[N];
vector<int> G[N];
int parent[LOG_N][N];
int dp[2][N];
int depth[N], up[N], down[N];
void dfs(int v, int p, int d) {
  parent[0][v] = p;
  depth[v] = d;
  for (int nxt : G[v]) {
    if (nxt != p) dfs(nxt, v, d + 1);
  }
}
void init(int V) {
  dfs(root, -1, 0);
  for (int k = 0; k + 1 < LOG_N; k++) {
    for (int v = 0; v < V; v++) {
      if (parent[k][v] < 0)
        parent[k + 1][v] = -1;
      else
        parent[k + 1][v] = parent[k][parent[k][v]];
    }
  }
}
void get(int v) {
  dp[0][v] = val[v];
  for (int nxt : G[v]) {
    get(nxt);
    dp[0][v] += dp[0][nxt];
    dp[1][v] = max(dp[1][v], dp[1][nxt]);
  }
  if (up[v] == -1) {
    dp[1][v] = dp[1][v] + dp[0][v];
    dp[0][v] = 0;
  }
}
int dfs_val(int v, int p) {
  if (G[v].size() == 0) {
    down[v] = 0;
    val[v] = 1;
  } else {
    down[v] = INF;
    for (int nxt : G[v]) {
      if (nxt != p) {
        down[v] = min(down[v], dfs_val(nxt, v) + 1);
      }
    }
  }
  int cur = v, sum = down[v];
  for (int j = LOG_N - 1; j >= 0; j--) {
    if (parent[j][cur] != -1 && sum + (1 << j) <= m) {
      sum += (1 << j);
      cur = parent[j][cur];
    }
  }
  up[v] = cur == v ? -1 : cur;
  return down[v];
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i < n; i++) {
    int x;
    scanf("%d", &x);
    x--;
    G[x].push_back(i);
  }
  init(n);
  dfs_val(0, -1);
  get(0);
  cout << dp[0][0] + dp[1][0] << endl;
}
