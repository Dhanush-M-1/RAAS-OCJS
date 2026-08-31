#include <bits/stdc++.h>
const int maxn = 1e6 + 5;
const int maxm = 2e6 + 5;
using namespace std;
int n, k;
int tot, head[maxn];
int a[maxn], b[maxn];
int ans;
struct edgenode {
  int to, next;
} edge[maxm];
void addedge(int u, int v) {
  edge[tot].to = v;
  edge[tot].next = head[u];
  head[u] = tot++;
}
void dfs1(int x) {
  if (head[x] == -1) {
    a[x] = 1;
    b[x] = k;
    return;
  }
  for (int i = head[x]; i != -1; i = edge[i].next) {
    int v = edge[i].to;
    dfs1(v);
    if (b[v]) a[x] += a[v];
    b[x] = max(b[x], b[v] - 1);
  }
}
void dfs2(int x, int val) {
  if (head[x] == -1) {
    ans = max(ans, val + 1);
    return;
  }
  for (int i = head[x]; i != -1; i = edge[i].next) {
    int v = edge[i].to;
    if (b[v])
      dfs2(v, val + a[x] - a[v]);
    else
      dfs2(v, val + a[x]);
  }
}
int main() {
  memset(head, -1, sizeof head);
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; i++) {
    int x;
    scanf("%d", &x);
    addedge(x, i);
  }
  dfs1(1);
  dfs2(1, 0);
  printf("%d\n", ans);
  return 0;
}
