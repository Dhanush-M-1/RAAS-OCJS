#include <bits/stdc++.h>
using namespace std;
const long long inf = 1e17 + 7;
const long long N = 200010;
long long n, a[N], b[N];
long long f[N];
struct Edge {
  long long to, nxt;
  long long val;
} edge[N << 1];
long long head[N << 1], tot;
void add_edge(long long x, long long y, long long z) {
  edge[++tot].to = y;
  edge[tot].val = z;
  edge[tot].nxt = head[x];
  head[x] = tot;
}
void dfs(long long u) {
  f[u] = b[u] - a[u];
  for (long long i = head[u]; i; i = edge[i].nxt) {
    long long v = edge[i].to;
    dfs(v);
    if (f[v] < 0) {
      if (inf / edge[i].val <= -f[v])
        f[u] = -inf;
      else {
        f[u] += f[v] * edge[i].val;
        f[u] = max(f[u], -inf);
      }
    } else
      f[u] += f[v];
  }
}
signed main() {
  scanf("%lld", &n);
  for (long long i = 1; i <= n; i++) scanf("%lld", &b[i]);
  for (long long i = 1; i <= n; i++) scanf("%lld", &a[i]);
  for (long long i = 2; i <= n; i++) {
    long long x;
    long long k;
    scanf("%lld %lld", &x, &k);
    add_edge(x, i, k);
  }
  dfs(1);
  if (f[1] >= 0)
    printf("YES");
  else
    printf("NO");
  return 0;
}
