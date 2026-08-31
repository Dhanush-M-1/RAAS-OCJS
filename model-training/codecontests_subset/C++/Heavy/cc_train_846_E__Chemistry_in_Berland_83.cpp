#include <bits/stdc++.h>
using namespace std;
const int maxn = 100005;
const long long inf = 0x3f3f3f3f3f3f3f3f;
int n;
long long a[maxn], b[maxn], K[maxn];
vector<int> G[maxn];
inline long long add(long long a, long long b) {
  double ret = 1.0 * a + b;
  if (ret > 1e18) return inf;
  if (ret < -1e18) return -inf;
  return a + b;
}
inline long long mul(long long a, long long b) {
  double ret = 1.0 * a * b;
  if (ret > 1e18) return inf;
  if (ret < -1e18) return -inf;
  return a * b;
}
long long dfs(int u, int fa) {
  for (int i = 0; i < (int)G[u].size(); ++i) {
    int v = G[u][i];
    if (v == fa) continue;
    long long ret = dfs(v, u);
    if (ret == -inf) return -inf;
    if (ret > 0) b[u] = add(b[u], ret);
    if (ret < 0) {
      ret = -ret;
      long long prod = mul(ret, K[v]);
      if (prod == -inf) return -inf;
      b[u] = add(b[u], -prod);
      if (b[u] == -inf) return -inf;
    }
  }
  return add(b[u], -a[u]);
}
void print() {
  for (int i = 1; i <= n; ++i) {
    printf("i=%d: ", i);
    for (int j = 0; j < (int)G[i].size(); ++j)
      printf("%d%c", G[i][j], j + 1 == (int)G[i].size() ? '\n' : ' ');
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%I64d", &b[i]);
  for (int i = 1; i <= n; ++i) scanf("%I64d", &a[i]);
  for (int i = 2; i <= n; ++i) {
    int x;
    scanf("%d%I64d", &x, &K[i]);
    G[x].push_back(i);
  }
  puts(dfs(1, 0) >= 0 ? "YES" : "NO");
  return 0;
}
