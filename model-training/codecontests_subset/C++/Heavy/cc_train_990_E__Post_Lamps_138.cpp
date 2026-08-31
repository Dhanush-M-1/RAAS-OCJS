#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
const int N = 1e6 + 7;
long long cost[N];
int vis[N], n, m, k;
int pre[N];
int main(void) {
  scanf("%d", &n), scanf("%d", &m), scanf("%d", &k);
  int i;
  for (i = 1; i <= m; ++i) {
    int x;
    scanf("%d", &x);
    vis[x] = 1;
  }
  for (i = 1; i <= k; ++i) scanf("%lld", &cost[i]);
  long long ans = 1ll << 50;
  if (vis[0]) return puts("-1"), 0;
  for (i = 0; i < n; ++i) {
    if (vis[i])
      pre[i] = pre[i - 1];
    else
      pre[i] = i;
  }
  for (i = 1; i <= k; ++i) {
    int cur = 0;
    long long tans = 0;
    while (cur < n) {
      if (vis[cur]) {
        int p = pre[cur];
        int tcur = p + i;
        if (tcur <= cur) {
          tans = 1ll << 50;
          break;
        } else {
          cur = tcur;
          tans += cost[i];
        }
      } else {
        tans += cost[i];
        cur += i;
      }
    }
    ans = min(tans, ans);
  }
  printf("%lld\n", ans == 1ll << 50 ? -1ll : ans);
  return 0;
}
