#include <bits/stdc++.h>
int a[100001], b[100001], c[100001];
int main() {
  int n, i, j, k;
  int sum1, sum2;
  memset(a, 0, sizeof(a));
  memset(b, 0, sizeof(b));
  memset(c, 0, sizeof(c));
  scanf("%d", &n);
  for (i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (i = 1; i < n; i++) scanf("%d", &b[i]);
  for (i = 1; i <= n - 2; i++) scanf("%d", &c[i]);
  sum1 = sum2 = 0;
  for (i = 1; i <= n; i++) {
    sum1 += a[i];
    sum1 -= b[i];
  }
  for (i = 1; i <= n - 1; i++) {
    sum2 += b[i];
    sum2 -= c[i];
  }
  printf("%d\n%d\n", sum1, sum2);
}
