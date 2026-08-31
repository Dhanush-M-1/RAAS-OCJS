#include <bits/stdc++.h>
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int n;
    scanf("%d", &n);
    int a[50005];
    for (int x = 0; x < n; x++) {
      scanf("%d", &a[x]);
    }
    if (a[0] + a[1] > a[n - 1]) {
      printf("-1\n");
    } else {
      printf("1 2 %d\n", n);
    }
  }
  return 0;
}
