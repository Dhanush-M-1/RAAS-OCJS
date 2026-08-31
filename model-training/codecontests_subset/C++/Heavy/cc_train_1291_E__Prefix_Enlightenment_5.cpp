#include <bits/stdc++.h>
int a[300005];
std::vector<int> g[300005];
int vis[600005], count[600005];
int p[600005];
int find(int u) {
  if (p[u] == u)
    return u;
  else
    return p[u] = find(p[u]);
}
void merge(int u, int v) {
  int x = find(u), y = find(v);
  if (x != y) {
    if (x > y) {
      p[y] = x;
      count[x] += count[y];
      count[y] = 0;
    } else {
      p[x] = y;
      count[y] += count[x];
      count[x] = 0;
    }
  }
}
int main() {
  int n, k;
  scanf("%d%d", &n, &k);
  for (int i = 1; i <= n; i++) scanf("%1d", &a[i]);
  for (int i = 1; i <= k; i++) {
    int c;
    scanf("%d", &c);
    while (c--) {
      int p;
      scanf("%d", &p);
      g[p].push_back(i);
    }
    p[i] = i;
    p[i + k] = i + k;
    count[i] = 0, count[i + k] = 1;
  }
  int ans = 0;
  int True = 2 * k + 1;
  p[True] = True;
  count[True] = 0;
  for (int i = 1; i <= n; i++) {
    if ((int)g[i].size() != 0) {
      if (g[i].size() == 1) {
        int u = g[i][0];
        int x = find(u), y = find(u + k);
        if (x != True && y != True) {
          if (vis[x]) vis[x] = 0, ans -= count[x];
          if (vis[y]) vis[y] = 0, ans -= count[y];
          ans -= count[True];
          if (a[i] != 0)
            merge(x, True);
          else
            merge(y, True);
          vis[True] = 1;
          ans += count[True];
        }
      } else {
        int u = g[i][0], v = g[i][1];
        int x0 = find(u), y0 = find(u + k), x1 = find(v), y1 = find(v + k);
        if (vis[x0]) vis[x0] = 0, ans -= count[x0];
        if (vis[y0]) vis[y0] = 0, ans -= count[y0];
        if (vis[x1]) vis[x1] = 0, ans -= count[x1];
        if (vis[y1]) vis[y1] = 0, ans -= count[y1];
        if (a[i] != 0) {
          merge(x0, x1);
          merge(y0, y1);
        } else {
          merge(x0, y1);
          merge(x1, y0);
        }
        int x = find(u), y = find(u + k);
        if (x == True || y == True) {
          vis[True] = 1;
          ans += count[True];
        } else {
          int t = count[x] < count[y] ? x : y;
          vis[t] = 1;
          ans += count[t];
        }
      }
    }
    printf("%d\n", ans);
  }
  printf("\n");
  return 0;
}
