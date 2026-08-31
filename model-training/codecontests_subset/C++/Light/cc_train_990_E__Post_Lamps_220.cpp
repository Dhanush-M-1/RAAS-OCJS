#include <bits/stdc++.h>
using namespace std;
int b[1100000], a[1100000], pre[1100000];
int main() {
  int n, m, k, i, j, s, cnt, len = 0, max = 0;
  long long ans = 0;
  scanf("%d%d%d", &n, &m, &k);
  for (i = 1; i <= m; ++i) {
    scanf("%d", &s);
    b[s] = 1;
  }
  b[n] = 1;
  for (i = 1; i < n; ++i)
    if (b[i])
      pre[i] = pre[i - 1];
    else
      pre[i] = i;
  for (i = 1; i < n; ++i) {
    if (b[i])
      ++len;
    else
      len = 0;
    if (len > max) max = len;
  }
  for (i = 1; i <= k; ++i) scanf("%d", &a[i]);
  if (max == 0)
    max = 1;
  else
    ++max;
  for (i = max; i <= k; ++i) {
    cnt = 0;
    j = 0;
    if (b[j]) continue;
    while (j < n) {
      ++cnt;
      if (!b[j])
        j = j + i;
      else
        j = pre[j] + i;
    }
    if (ans == 0)
      ans = (long long)cnt * a[i];
    else if ((long long)cnt * a[i] < ans)
      ans = (long long)cnt * a[i];
  }
  if (ans > 0)
    printf("%I64d", ans);
  else
    printf("-1");
  return 0;
}
