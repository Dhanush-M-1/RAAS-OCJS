#include <bits/stdc++.h>
int k, n, m;
long long ans, temp;
int p[3000000];
int a[3000000];
int main() {
  scanf("%d %d %d", &n, &m, &k);
  int pos;
  for (int i = 1; i <= m; ++i) {
    scanf("%d", &pos);
    p[pos] = -1;
  }
  for (int i = 1; i <= k; ++i) scanf("%d", &a[i]);
  pos = -1;
  for (int i = 0; i <= n + k + 2; ++i) {
    if (p[i] == 0) pos = i;
    p[i] = pos;
  }
  ans = 1LL << 61;
  for (int i = 1; i <= k; ++i) {
    temp = 0;
    pos = p[0];
    temp = 0;
    if (pos < 0) break;
    while (pos < n) {
      temp += a[i];
      if (p[pos + i] <= pos) break;
      pos = p[pos + i];
    }
    if (pos >= n && temp < ans) ans = temp;
  }
  if (ans > 1LL << 60) ans = -1;
  printf("%I64d\n", ans);
  return 0;
}
