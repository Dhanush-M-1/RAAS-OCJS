#include <bits/stdc++.h>
using namespace std;
const int maxn = 100 * 1000 + 10;
int n, m;
vector<pair<int, int> > vertex[maxn];
bool mark[maxn];
stack<int> f[maxn];
stack<int> adj[maxn];
int build(int v) {
  for (int i = 0; i < ((int(vertex[v].size()))); i++) {
    int u = vertex[v][i].first, e = vertex[v][i].second;
    if (!mark[e]) {
      adj[v].push(u);
      mark[e] = true;
    }
  }
  while (!adj[v].empty()) {
    int u = adj[v].top();
    adj[v].pop();
    int w = build(u);
    if (w == 0)
      f[v].push(u);
    else
      printf("%d %d %d\n", v, u, w);
  }
  while (((int(f[v].size()))) >= 2) {
    int u = f[v].top();
    f[v].pop();
    int w = f[v].top();
    f[v].pop();
    printf("%d %d %d\n", u, v, w);
  }
  if (!f[v].empty()) {
    int w = f[v].top();
    f[v].pop();
    return w;
  } else
    return 0;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    vertex[u].push_back(make_pair(v, i));
    vertex[v].push_back(make_pair(u, i));
  }
  if (m & 1) {
    printf("No solution");
    return 0;
  }
  build(1);
  return 0;
}
