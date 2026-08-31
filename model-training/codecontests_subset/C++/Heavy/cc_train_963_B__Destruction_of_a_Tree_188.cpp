#include <bits/stdc++.h>
using namespace std;
struct Edge {
  int to;
  int next;
  int val;
} edge[400005];
int head[200005];
int cnt = 1;
void addedge(int u, int v) {
  edge[cnt].to = v;
  edge[cnt].next = head[u];
  head[u] = cnt++;
}
int rt;
int num[200005];
bool vis[200005];
int ans[200005];
int tot = 0;
void dfs1(int u, int fa) {
  ans[++tot] = u;
  vis[u] = 1;
  for (int i = head[u]; i; i = edge[i].next) {
    int to = edge[i].to;
    if (to == fa) continue;
    if (!vis[to]) dfs1(to, u);
  }
}
void dfs(int u, int fa) {
  for (int i = head[u]; i; i = edge[i].next) {
    int to = edge[i].to;
    if (to == fa) continue;
    dfs(to, u);
    if (vis[to]) num[u] ^= 1;
  }
  if (!num[u]) dfs1(u, fa);
}
set<int> s0;
set<int> s1;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int x;
    scanf("%d", &x);
    if (x) {
      addedge(i, x);
      addedge(x, i);
    } else
      rt = i;
  }
  dfs(rt, 0);
  if (tot < n) return printf("NO\n"), 0;
  printf("YES\n");
  for (int i = tot; i >= 1; i--) printf("%d\n", ans[i]);
}
