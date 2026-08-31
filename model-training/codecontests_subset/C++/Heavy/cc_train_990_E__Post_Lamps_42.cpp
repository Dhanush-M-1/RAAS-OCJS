#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000005;
const long long inf = 1ll << 60;
int n, m, k, a[maxn];
int lft[maxn];
bool avl[maxn];
long long ans = inf;
long long get_lamps(int p) {
  int ans = 0, pos = 0, cur = -1;
  while (pos < n) {
    if (lft[pos] <= cur) {
      return inf;
    } else {
      cur = lft[pos];
      pos = lft[pos] + p;
      ++ans;
    }
  }
  return ans;
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i <= n; ++i) avl[i] = true;
  for (int i = 1, s; i <= m; ++i) scanf("%d", &s), avl[s] = false;
  for (int i = 1; i <= k; ++i) scanf("%d", a + i);
  for (int i = 0; i <= n; ++i) {
    if (avl[i])
      lft[i] = i;
    else if (i > 0)
      lft[i] = lft[i - 1];
    else
      lft[i] = -1;
  }
  for (int i = 1; i <= k; ++i) {
    long long num = get_lamps(i);
    if (num < inf) ans = min(ans, num * a[i]);
  }
  printf("%I64d\n", ans < inf ? ans : -1ll);
  return 0;
}
