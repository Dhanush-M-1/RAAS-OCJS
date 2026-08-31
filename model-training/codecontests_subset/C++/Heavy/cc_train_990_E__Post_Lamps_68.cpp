#include <bits/stdc++.h>
using namespace std;
int n, m, k;
int s[1000005];
int f[1000005];
int a[1000005];
long long inf = 0x3f3f3f3f3f3f3f3f;
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    scanf("%d", &s[i]);
    f[s[i]] = 1;
  }
  for (int i = 1; i <= k; i++) {
    scanf("%d", &a[i]);
  }
  for (int i = 1; i <= n; i++)
    if (f[i]) f[i] += f[i - 1];
  long long ans = inf;
  for (int i = 1; i <= k; i++) {
    long long cnt = 0;
    for (int j = 0; j < n; j += i, cnt++) {
      if (f[j]) {
        if (f[j] >= i || j - f[j] < 0) {
          cnt = inf;
          break;
        }
        j -= f[j];
      }
    }
    if (cnt == inf) continue;
    ans = min(ans, cnt * a[i]);
  }
  if (ans == inf) return !printf("-1\n");
  printf("%lld\n", ans);
  return 0;
}
