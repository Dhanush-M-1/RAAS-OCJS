#include <bits/stdc++.h>
using namespace std;
int bl[3003000];
int ifushf[3003000];
int main() {
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    int a;
    scanf("%d", &a);
    bl[a] = 1;
  }
  if (bl[0]) {
    printf("-1\n");
    return 0;
  }
  ifushf[0] = 0;
  for (int i = 1; i <= n; i++) {
    if (bl[i])
      ifushf[i] = ifushf[i - 1];
    else
      ifushf[i] = i;
  }
  long long ans = (1ll << 60);
  for (int i = 1; i <= k; i++) {
    int val;
    scanf("%d", &val);
    int t = 0;
    int pos = 0;
    while (pos < n) {
      t++;
      pos += i;
      if (pos >= n) break;
      if (ifushf[pos] <= pos - i) break;
      pos = ifushf[pos];
    }
    if (pos >= n) ans = min(ans, (long long)val * t);
  }
  if (ans != (1ll << 60))
    printf("%lld\n", ans);
  else
    printf("-1\n");
}
