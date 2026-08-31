#include <bits/stdc++.h>
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    long long int n, i, j, k, f = 0;
    scanf("%lld", &n);
    long long int a[n];
    for (i = 0; i < n; i++) scanf("%lld", &a[i]);
    for (i = 2; i < n; i++) {
      if (a[i] >= a[0] + a[1]) {
        f = 1;
        break;
      }
    }
    if (f == 1)
      printf("1 2 %lld\n", i + 1);
    else
      printf("-1\n");
  }
  return 0;
}
