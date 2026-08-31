#include <bits/stdc++.h>
long long int a[50004];
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int n;
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) scanf("%lld", &a[i]);
    if (a[1] + a[2] <= a[n]) {
      printf("%d %d %d\n", 1, 2, n);
    } else
      printf("-1\n");
  }
}
