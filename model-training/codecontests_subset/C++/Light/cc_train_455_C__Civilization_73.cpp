#include <bits/stdc++.h>
using namespace std;
const int maxn = 300000 + 5;
vector<int> graph[maxn];
int n, m, q, a, b, k, parent[maxn], lp[maxn], vertex, len, c, d, l, h[maxn];
int findparent(int x) {
  if (x == parent[x])
    return x;
  else
    return parent[x] = findparent(parent[x]);
}
void dfs(int x, int s, int t) {
  if (s > len) {
    len = s;
    vertex = x;
  }
  h[x] = t;
  parent[x] = l;
  for (int j = 0; j < graph[x].size(); j++) {
    if (h[graph[x][j]] != t) {
      h[graph[x][j]] = t;
      dfs(graph[x][j], s + 1, t);
    }
  }
}
int main() {
  scanf("%d", &n);
  scanf("%d", &m);
  scanf("%d", &q);
  for (int i = 0; i < m; i++) {
    scanf("%d", &a);
    scanf("%d", &b);
    graph[a].push_back(b);
    graph[b].push_back(a);
  }
  for (int i = 1; i <= n; i++) {
    if (parent[i]) continue;
    len = -1;
    l = i;
    dfs(i, 0, 1);
    len = -1;
    dfs(vertex, 0, 2);
    lp[i] = len;
  }
  for (int i = 0; i < q; i++) {
    scanf("%d", &k);
    scanf("%d", &a);
    if (k == 2) {
      scanf("%d", &b);
      c = findparent(a);
      d = findparent(b);
      if (c == d) continue;
      if (c != d) {
        lp[c] = max(lp[c], max(lp[d], (lp[c] + 1) / 2 + (lp[d] + 1) / 2 + 1));
        parent[d] = c;
      }
    } else
      printf("%d \n", lp[findparent(a)]);
  }
}
