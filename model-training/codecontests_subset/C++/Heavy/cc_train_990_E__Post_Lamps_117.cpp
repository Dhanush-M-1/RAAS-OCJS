#include <bits/stdc++.h>
using namespace std;
int q[1000005];
int w[1000005];
int vis[1000005];
int d[1100005];
int main() {
  int n, m, k;
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) scanf("%d", &q[i]), vis[q[i]] = 1;
  for (int i = 1; i <= k; i++) scanf("%d", &w[i]);
  if (vis[0] && m > 0) {
    puts("-1");
    return 0;
  }
  for (int i = 1; i <= n; i++) {
    if (vis[i])
      d[i] = d[i - 1];
    else
      d[i] = i;
  }
  for (int i = 1; i <= k; i++) d[n + i] = n + i;
  long long ans = 1e14;
  for (int i = 1; i <= k; i++) {
    long long sum = 0;
    bool f = true;
    int loc = 0;
    while (1) {
      if (loc >= n) break;
      if (loc == d[loc + i]) {
        f = false;
        break;
      }
      loc = d[loc + i];
      sum += w[i];
    }
    if (f) ans = min(ans, sum);
  }
  if (ans != 1e14)
    printf("%lld\n", ans);
  else
    puts("-1");
  return 0;
}
