#include <bits/stdc++.h>
int main() {
  int a[105], i, s, k, n, m;
  scanf("%d%d", &n, &m);
  k = 0;
  scanf("%d", &a[0]);
  for (i = 1; i < n; i++) {
    scanf("%d", &a[i]);
    s = a[i - 1] - a[i] - m;
    if (s > k) k = s;
  }
  printf("%d\n", k);
  return 0;
}
