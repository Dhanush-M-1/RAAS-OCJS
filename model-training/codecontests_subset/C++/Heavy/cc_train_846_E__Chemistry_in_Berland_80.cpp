#include <bits/stdc++.h>
using namespace std;
long long a[100007], b[100007], x[100007], k[100007];
int main() {
  long long w = 1;
  for (long long i = 1; i <= 60; i++) {
    w *= 2;
  }
  long long n, m, i, j, y, xx;
  scanf("%I64d", &n);
  for (i = 1; i <= n; i++) scanf("%I64d", &b[i]);
  for (i = 1; i <= n; i++) scanf("%I64d", &a[i]);
  if (n > 1) {
    for (i = 2; i <= n; i++) {
      scanf("%I64d%I64d", &x[i], &k[i]);
    }
  }
  i = n;
  double yy;
  while (i > 1) {
    if (b[i] < a[i]) {
      yy = b[x[i]] - k[i] * (a[i] - b[i]);
      if (yy > w || yy < -w) {
        b[1] = -1;
        break;
      }
      b[x[i]] -= k[i] * (a[i] - b[i]);
    } else if (b[i] > a[i]) {
      yy = b[x[i]] + b[i] - a[i];
      if (yy > w) {
        b[1] = -1;
        break;
      }
      b[x[i]] += b[i] - a[i];
    }
    i--;
  }
  if (b[1] >= a[1])
    printf("YES\n");
  else
    printf("NO\n");
  while (j >= 2) return 0;
}
