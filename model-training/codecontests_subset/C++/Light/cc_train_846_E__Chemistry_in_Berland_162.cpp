#include <bits/stdc++.h>
using namespace std;
long long n, x, y, t;
long long a[110000], h[110000];
struct edge {
  long long y, nxt, w;
} e[110000];
void add(long long i) {
  t++;
  e[t].y = i;
  e[t].nxt = h[x];
  e[t].w = y;
  h[x] = t;
}
void dfs(long long k, long long x, long long s) {
  for (long long i = h[k]; i; i = e[i].nxt) dfs(e[i].y, k, e[i].w);
  if (a[k] >= 0)
    a[x] += a[k];
  else {
    double y = double(s) * double(a[k]);
    if (!x || y < -23333333333333333) {
      puts("NO");
      exit(0);
    }
    a[x] += s * a[k];
    if (a[x] < -23333333333333333) {
      puts("NO");
      exit(0);
    }
  }
}
signed main() {
  cin >> n;
  for (long long i = 1; i <= n; i++) scanf("%lld", &a[i]);
  for (long long i = 1; i <= n; i++) scanf("%lld", &x), a[i] -= x;
  for (long long i = 2; i <= n; i++) scanf("%lld%lld", &x, &y), add(i);
  dfs(1, 0, 0);
  puts("YES");
  return 0;
}
