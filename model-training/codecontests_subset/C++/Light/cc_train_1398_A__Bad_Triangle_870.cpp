#include <bits/stdc++.h>
int a[50003];
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int n;
    scanf("%d", &n);
    for (int i = 1; i <= n; ++i) {
      scanf("%d", &a[i]);
    }
    if (a[1] + a[2] <= a[n])
      printf("%d %d %d\n", 1, 2, n);
    else
      puts("-1");
  }
}
