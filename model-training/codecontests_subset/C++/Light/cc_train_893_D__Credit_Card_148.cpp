#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 1;
int n, d;
int a[maxn];
int lim[maxn];
int main() {
  scanf("%d %d", &n, &d);
  for (int i = 1; i <= n; ++i) scanf("%d", a + i);
  lim[n] = d;
  for (int i = n - 1; i >= 0; --i) {
    lim[i] = min(d, lim[i + 1] - a[i + 1]);
    if (a[i] == 0 && lim[i] < 0) {
      puts("-1");
      return 0;
    }
  }
  int ans = 0, cur = 0;
  for (int i = 1; i <= n; ++i) {
    cur += a[i];
    if (cur > d) {
      puts("-1");
      return 0;
    }
    if (a[i] == 0 && cur < 0) {
      ++ans;
      cur = lim[i];
    }
  }
  printf("%d\n", ans);
}
