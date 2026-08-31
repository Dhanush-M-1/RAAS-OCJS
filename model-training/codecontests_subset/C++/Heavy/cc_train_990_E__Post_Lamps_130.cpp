#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int maxn = 1e6 + 5;
const int inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3f;
int s[maxn], a[maxn], vis[maxn], b[maxn];
int main() {
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) scanf("%d", &s[i]), vis[s[i]] = 1;
  for (int i = 1; i <= k; i++) scanf("%d", &a[i]);
  if (vis[0]) b[0] = -1;
  for (int i = 1; i < n; i++) {
    if (vis[i])
      b[i] = b[i - 1];
    else
      b[i] = i;
  }
  int f = 0, cnt = 0;
  long long res = INF;
  for (int i = 1; i <= k; i++) {
    f = cnt = 0;
    for (int j = 0; j < n;) {
      if (vis[j] == 0)
        j += i, cnt++;
      else {
        if (b[j] == -1 || j - b[j] >= i) {
          f = 1;
          break;
        } else
          j = i + b[j], cnt++;
      }
    }
    if (f) continue;
    res = min(res, 1ll * cnt * a[i]);
  }
  if (res == INF) res = -1;
  printf("%lld\n", res);
  return 0;
}
