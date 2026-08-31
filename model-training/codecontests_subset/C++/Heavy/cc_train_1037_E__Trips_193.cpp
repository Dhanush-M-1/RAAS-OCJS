#include <bits/stdc++.h>
using namespace std;
int n, m, k;
struct edge {
  int v, nxt;
} e[200005 * 2];
int cnt = 1, head[200005];
void adde(int u, int v) {
  e[++cnt].v = v;
  e[cnt].nxt = head[u];
  head[u] = cnt;
}
int vis[200005 * 2], d[200005], ans[200005], res;
struct ege2 {
  int u, v;
} edge[200005];
queue<int> q;
void solve() {
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    d[u] = 0;
    for (int i = head[u]; i; i = e[i].nxt) {
      int v = e[i].v;
      if (vis[i]) continue;
      vis[i] = vis[i ^ 1] = 1;
      d[v]--;
      if (d[v] == k - 1) {
        --res;
        q.push(v);
      }
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1, u, v; i <= m; ++i) {
    scanf("%d%d", &u, &v);
    edge[i].u = u;
    edge[i].v = v;
    adde(u, v);
    adde(v, u);
    ++d[u];
    ++d[v];
  }
  res = n;
  for (int i = 1; i <= n; ++i)
    if (d[i] < k) {
      --res;
      q.push(i);
    }
  solve();
  ans[m] = res;
  for (int i = m; i >= 2; --i) {
    if (vis[i << 1]) {
      ans[i - 1] = ans[i];
      continue;
    }
    vis[i << 1] = vis[i << 1 | 1] = 1;
    int u = edge[i].u, v = edge[i].v;
    d[u]--;
    d[v]--;
    if (d[u] == k - 1) {
      --res;
      q.push(u);
    }
    if (d[v] == k - 1) {
      --res;
      q.push(v);
    }
    solve();
    ans[i - 1] = res;
  }
  for (int i = 1; i <= m; ++i) printf("%d\n", ans[i]);
  return 0;
}
