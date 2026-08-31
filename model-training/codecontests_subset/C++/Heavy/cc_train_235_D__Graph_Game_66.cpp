#include <bits/stdc++.h>
using namespace std;
const int N = 3333;
int n;
vector<int> g[N];
int inside[N];
int deg[N];
vector<int> dist0[N], dist1[N];
void dfs(int v, int d0, int d1) {
  if (inside[v]) {
    return;
  }
  dist0[v].push_back(d0);
  dist1[v].push_back(d1);
  inside[v] = 1;
  for (int j = 0; j < (int)g[v].size(); j++) {
    int u = g[v][j];
    int type = (deg[v] + deg[u] <= 3);
    dfs(u, d0 + type, d1 + 1 - type);
  }
  inside[v] = 0;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int x, y;
    scanf("%d %d", &x, &y);
    g[x].push_back(y);
    g[y].push_back(x);
  }
  vector<int> que;
  for (int i = 0; i < n; i++) {
    deg[i] = g[i].size();
    if (deg[i] == 1) {
      que.push_back(i);
    }
  }
  for (int i = 0; i < (int)que.size(); i++) {
    int v = que[i];
    for (int u : g[v]) {
      if (deg[u] > 1) {
        deg[u]--;
        if (deg[u] == 1) {
          que.push_back(u);
        }
      }
    }
  }
  double ans = 0.0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      dist0[j].clear();
      dist1[j].clear();
    }
    dfs(i, 1, 1);
    for (int j = 0; j < n; j++) {
      if (dist0[j].size() == 1) {
        ans += 1.0 / dist0[j][0];
      } else {
        ans += 1.0 / (dist0[j][0] + dist1[j][0] - 1) +
               1.0 / (dist0[j][1] + dist1[j][1] - 1) -
               1.0 / (dist0[j][0] + dist1[j][0] + dist1[j][1] - 3);
      }
    }
  }
  printf("%.20lf\n", ans);
  return 0;
}
