#include <bits/stdc++.h>
int N, X, Y;
int main() {
  while (scanf("%d %d %d", &N, &X, &Y) == 3) {
    int ans = (int)(ceil(N * 0.01 * Y)) - X;
    if (ans < 0) ans = 0;
    printf("%d\n", ans);
  }
  return 0;
}
