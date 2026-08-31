#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100005;
const long long INF = 1000000000000000000;
int fa[MAXN];
vector<pair<int, int> > tree[MAXN];
long long a[MAXN];
long long b[MAXN];
long long val[MAXN];
long long f[MAXN];
long long multi(const long long x, const long long y) {
  if (x >= INF / y) return INF;
  return x * y;
}
void dfs(const int u, const long long k) {
  bool flag(false);
  for (auto cur : tree[u]) {
    int v(cur.first), k(cur.second);
    dfs(v, k);
    if (f[v] > 0) {
      if (val[u] <= f[v] - INF)
        flag = true;
      else
        val[u] -= f[v];
    }
  }
  if (flag)
    f[u] = INF;
  else {
    if (val[u] >= 0)
      val[fa[u]] += val[u];
    else
      f[u] = multi(-val[u], k);
  }
}
bool solve(const int n) {
  for (int i(1); i <= n; ++i) val[i] = b[i] - a[i];
  dfs(1, 1);
  if (f[1] > 0)
    return false;
  else
    return true;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i(1); i <= n; ++i) scanf("%lld", b + i);
  for (int i(1); i <= n; ++i) scanf("%lld", a + i);
  for (int i(2), x, k; i <= n; ++i) {
    scanf("%d %d", &x, &k);
    tree[x].push_back(pair<int, int>(i, k));
    fa[i] = x;
  }
  if (solve(n))
    puts("YES");
  else
    puts("NO");
  return 0;
}
