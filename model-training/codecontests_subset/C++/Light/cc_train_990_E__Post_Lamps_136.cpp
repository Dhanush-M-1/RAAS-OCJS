#include <bits/stdc++.h>
using namespace std;
long long n, m, k, ans = (1ll << 50);
long long b[1000005], c[1000005], p[1000005];
int main() {
  scanf("%lld%lld%lld", &n, &m, &k);
  long long x;
  for (long long i = 1; i <= m; i++) {
    scanf("%lld", &x);
    b[x] = 1;
  }
  for (long long i = 1; i <= k; i++) {
    scanf("%lld", &c[i]);
  }
  if (b[0]) {
    puts("-1");
    return 0;
  }
  for (long long i = 1; i <= n; i++) {
    if (b[i])
      p[i] = p[i - 1];
    else
      p[i] = i;
  }
  bool f;
  long long ct;
  for (long long i = 1; i <= k; i++) {
    x = 0;
    f = 1;
    ct = 0;
    while (x < n) {
      x = p[x];
      if (x + i >= n) {
        ct++;
        break;
      }
      if (p[x + i] <= x) {
        f = 0;
        break;
      }
      x += i;
      ct++;
    }
    if (f) {
      ans = min(ans, ct * c[i]);
    }
  }
  if (ans == (1ll << 50)) {
    puts("-1");
  } else {
    cout << ans;
  }
}
