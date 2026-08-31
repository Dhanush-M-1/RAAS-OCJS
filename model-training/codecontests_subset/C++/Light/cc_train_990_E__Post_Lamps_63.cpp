#include <bits/stdc++.h>
using namespace std;
int f[1000005], a[1000005];
int main() {
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) {
    int x;
    scanf("%d", &x);
    f[x] = 1;
  }
  for (int i = 1; i <= k; i++) scanf("%d", &a[i]);
  if (f[0]) {
    puts("-1");
    return 0;
  }
  for (int i = 0; i <= n; i++) f[i] = f[i] ? f[i - 1] : i;
  int lim = 0;
  for (int i = 0; i <= n; i++) lim = max(lim, i == n ? i - f[i] : i - f[i] + 1);
  if (k < lim) {
    puts("-1");
    return 0;
  }
  long long ans = 1ll << 60;
  for (int i = lim; i <= k; i++) {
    long long tmp = 0;
    int cur = 0;
    for (;; cur = f[cur + i]) {
      tmp += a[i];
      if (cur + i >= n) break;
    }
    ans = min(ans, tmp);
  }
  printf("%I64d\n", ans);
}
