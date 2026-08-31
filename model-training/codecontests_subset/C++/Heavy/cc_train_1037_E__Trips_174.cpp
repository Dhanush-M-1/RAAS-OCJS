#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int t, id, next;
  Edge() {}
  Edge(int a, int b, int c) : t(a), id(b), next(c) {}
};
Edge e[400005];
int head[200005], ans[200005], k;
int cur;
int d[200005], sum;
bool col[200005];
void dfs(int x) {
  col[x] = 0;
  sum--;
  for (int i = head[x]; i; i = e[i].next)
    if (col[e[i].t] && e[i].id < cur) {
      int u = e[i].t;
      d[u]--;
      if (d[u] < k) dfs(u);
    }
}
pair<int, int> a[200005];
int main() {
  int n, m;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    e[2 * i - 1] = Edge(y, i, head[x]);
    head[x] = 2 * i - 1;
    e[2 * i] = Edge(x, i, head[y]);
    head[y] = 2 * i;
    d[x]++;
    d[y]++;
    a[i] = pair<int, int>(x, y);
  }
  for (int i = 1; i <= n; i++) col[i] = 1;
  sum = n;
  cur = m + 1;
  for (int i = 1; i <= n; i++)
    if (col[i] && d[i] < k) dfs(i);
  for (int i = m; i > 0; i--) {
    ans[i] = sum;
    int x = a[i].first, y = a[i].second;
    cur--;
    if (col[x] && col[y]) {
      d[x]--;
      d[y]--;
      if (col[x] && d[x] < k) dfs(x);
      if (col[y] && d[y] < k) dfs(y);
    }
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
  return 0;
}
