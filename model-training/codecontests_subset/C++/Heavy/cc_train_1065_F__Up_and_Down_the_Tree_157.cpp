#include <bits/stdc++.h>
using namespace std;
const int nn = 1e6 + 8;
vector<int> G[nn];
int low[nn], f[nn][2];
int n, k;
void dfs(int u, int d) {
  low[u] = n;
  if (G[u].empty()) {
    low[u] = d;
    f[u][0] = 1;
  }
  int last = 0;
  for (int v : G[u]) {
    dfs(v, d + 1);
    if (low[v] - d <= k) {
      f[u][0] += f[v][0];
    } else {
      last = max(last, f[v][1]);
    }
    low[u] = min(low[u], low[v]);
  }
  for (int v : G[u]) {
    last = max(last, f[v][1] - f[v][0]);
  }
  f[u][1] = f[u][0] + last;
}
int main() {
  scanf("%d %d", &n, &k);
  for (int i = 2; i <= n; i++) {
    int u;
    scanf("%d", &u);
    G[u].push_back(i);
  }
  dfs(1, 0);
  cout << f[1][1];
}
