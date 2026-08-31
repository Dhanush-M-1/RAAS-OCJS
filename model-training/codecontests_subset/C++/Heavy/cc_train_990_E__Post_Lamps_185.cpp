#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5;
int n, m, k, s[N], a[N], b[N], c[N];
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1; i <= m; i++) scanf("%d", &s[i]), b[s[i]] = 1;
  for (int i = 1; i <= k; i++) scanf("%d", &a[i]);
  if (b[0]) return puts("-1"), 0;
  c[0] = 0;
  for (int i = 1; i < n; i++)
    if (b[i])
      c[i] = c[i - 1];
    else
      c[i] = i;
  long long ans = 1e18;
  for (int i = 1; i <= k; i++) {
    int now = 0;
    long long cnt = 0;
    while (now < n) {
      int tmp = now;
      now += i;
      cnt++;
      if (now >= n) break;
      if (b[now]) now = c[now];
      if (c[now] <= tmp) {
        cnt = (1e12) + 1;
        break;
      }
    }
    ans = min(ans, cnt * a[i]);
  }
  printf("%lld\n", ans <= 1e12 ? ans : -1);
  return 0;
}
