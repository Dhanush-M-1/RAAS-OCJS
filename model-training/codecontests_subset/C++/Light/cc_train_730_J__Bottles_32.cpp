#include <bits/stdc++.h>
using namespace std;
const long long N = 110;
long long n, m, sum, cnt, p, f[N][N * N], ans;
struct data {
  long long x, y;
} a[N];
bool cmp(data x, data y) { return x.y == y.y ? x.x > y.x : x.y > y.y; }
signed main() {
  scanf("%lld", &n);
  for (long long i = 1; i <= n; i++) scanf("%lld", &a[i].x), sum += a[i].x;
  for (long long i = 1; i <= n; i++) scanf("%lld", &a[i].y), m += a[i].y;
  sort(a + 1, a + 1 + n, cmp);
  for (long long i = 1; i <= n; i++) {
    cnt += a[i].y;
    if (cnt >= sum) {
      p = i;
      break;
    }
  }
  memset(f, -0x3f, sizeof(f)), f[0][0] = 0;
  for (long long i = 1; i <= n; i++)
    for (long long j = m; j >= a[i].y; j--)
      for (long long k = 1; k <= p; k++)
        f[k][j] = max(f[k][j], f[k - 1][j - a[i].y] + a[i].x);
  for (long long i = sum; i <= m; i++) ans = max(ans, f[p][i]);
  printf("%lld %lld\n", p, sum - ans);
  return 0;
}
