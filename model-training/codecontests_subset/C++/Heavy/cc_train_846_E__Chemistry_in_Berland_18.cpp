#include <bits/stdc++.h>
using namespace std;
const long long mx = 1e18;
long long n, tot, e[500010], hd[500010], nt[500010], f[500010], val[500010],
    a[500010], b[500010];
void build(long long x, long long y, long long w) {
  tot++;
  e[tot] = y;
  val[tot] = w;
  nt[tot] = hd[x];
  hd[x] = tot;
}
void dfs(long long x, long long fa) {
  long long i, now;
  f[x] = a[x];
  for (i = hd[x]; i; i = nt[i]) {
    if (e[i] == fa) continue;
    dfs(e[i], x);
    if (f[e[i]] < 0) {
      f[e[i]] = -f[e[i]];
      if (mx / val[i] < f[e[i]])
        now = mx;
      else
        now = f[e[i]] * val[i];
      f[x] -= now;
      f[x] = max(f[x], -mx);
    } else
      f[x] += f[e[i]];
  }
}
int main() {
  long long i, x, y;
  scanf("%lld", &n);
  for (i = 1; i <= n; i++) {
    scanf("%lld", &b[i]);
  }
  for (i = 1; i <= n; i++) {
    scanf("%lld", &a[i]);
    a[i] = b[i] - a[i];
  }
  for (i = 2; i <= n; i++) {
    scanf("%lld%lld", &x, &y);
    build(x, i, y);
  }
  dfs(1, 0);
  if (f[1] >= 0)
    puts("YES");
  else
    puts("NO");
}
