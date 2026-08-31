#include <bits/stdc++.h>
using namespace std;
int x[1000009], c[1000009], last[1000009];
int main() {
  int n, a, m, k, i, j, s = 0, smax = 0, cnt, l;
  scanf("%d %d %d", &n, &m, &k);
  for (i = 0; i < m; i++) {
    scanf("%d", &a);
    x[a] = 1;
    if (i != 0 && x[a - 1] == 1) {
      s++;
      smax = max(s, smax);
    } else
      s = 1;
  }
  smax = max(s, smax);
  for (i = 1; i <= k; i++) scanf("%d", &c[i]);
  if (smax + 1 > k || x[0] == 1) {
    printf("-1");
    return 0;
  }
  for (i = 0; i <= n; i++) {
    if (x[i] == 0)
      last[i] = i;
    else
      last[i] = last[i - 1];
  }
  long long ans, ansmin = -1;
  for (i = smax + 1; i <= k; i++) {
    l = 0;
    cnt = 0;
    while (l < n) {
      cnt++;
      if (l + i >= n) break;
      l = last[l + i];
    }
    ans = (long long)cnt * (long long)c[i];
    if (ansmin == -1)
      ansmin = ans;
    else
      ansmin = min(ansmin, ans);
  }
  printf("%lld", ansmin);
  return 0;
}
