#include <bits/stdc++.h>
const int N = 1e5 + 5;
using namespace std;
const long long INF = 1e18;
int n;
long long b[N], a[N];
long long k[N];
struct node {
  int u, v, nxt;
} edge[N];
int head[N], mcnt;
void add_edge(int u, int v) {
  mcnt++;
  edge[mcnt].u = u;
  edge[mcnt].v = v;
  edge[mcnt].nxt = head[u];
  head[u] = mcnt;
}
void dfs(int u, int fa) {
  for (int i = head[u]; i; i = edge[i].nxt) {
    int v = edge[i].v;
    dfs(v, u);
  }
  if (fa == -1) return;
  if (a[u] < b[u])
    b[fa] += b[u] - a[u];
  else if (a[u] > b[u]) {
    double t = 1.0 * k[u] * (a[u] - b[u]);
    if (t > INF) {
      puts("NO");
      exit(0);
    }
    b[fa] -= t;
    if (b[fa] < -INF) {
      puts("NO");
      exit(0);
    }
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", &b[i]);
  for (int i = 1; i <= n; i++) scanf("%lld", &a[i]);
  for (int i = 2; i <= n; i++) {
    int fa;
    scanf("%d%lld", &fa, &k[i]);
    add_edge(fa, i);
  }
  dfs(1, 0);
  puts(a[1] > b[1] ? "NO" : "YES");
}
