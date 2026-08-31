#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 7;
int n, m, k, s[maxn];
bool vis[maxn];
long long a[maxn];
int main() {
  while (~scanf("%d%d%d", &n, &m, &k)) {
    memset(vis, 0, sizeof(vis));
    memset(s, 0, sizeof(s));
    while (m--) {
      int x;
      scanf("%d", &x);
      vis[x] = true;
    }
    for (int i = 1; i <= k; i++) scanf("%lld", &a[i]);
    if (vis[0]) {
      printf("-1\n");
      continue;
    }
    int len = 0;
    long long ans = 1e18;
    for (int i = 0; i <= n; i++) {
      if (vis[i])
        s[i] = s[i - 1] + 1;
      else
        s[i] = 0;
      len = max(len, s[i]);
    }
    ans = 1e18;
    for (int i = len + 1; i <= k; i++) {
      long long cnt = 0;
      for (int j = 0; j < n; j += i) {
        if (vis[j]) j -= s[j];
        cnt++;
      }
      ans = min(ans, a[i] * cnt);
    }
    if (ans >= 1e18)
      printf("-1\n");
    else
      printf("%I64d\n", ans);
  }
  return 0;
}
