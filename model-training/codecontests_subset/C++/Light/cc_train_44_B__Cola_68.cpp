#include <bits/stdc++.h>
int main() {
  int n, a, b, c;
  while (scanf("%d%d%d%d", &n, &a, &b, &c) == 4) {
    int ans = 0;
    for (int i = 0; i <= n / 2 && i <= c; i++) {
      for (int j = 0; 2 * i + j <= n && j <= b; j++) {
        int k = n - (2 * i + j);
        k *= 2;
        if (k >= 0 && k <= a) ans++;
      }
    }
    printf("%d\n", ans);
  }
}
