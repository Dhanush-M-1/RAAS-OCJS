#include <bits/stdc++.h>
bool bulb[101];
int main() {
  int m, n;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < n; ++i) {
    int x;
    scanf("%d", &x);
    for (int j = 0; j < x; ++j) {
      int b;
      scanf("%d", &b);
      bulb[b] = true;
    }
  }
  for (int i = 1; i <= m; ++i) {
    if (!bulb[i]) {
      printf("NO\n");
      return 0;
    }
  }
  printf("YES\n");
}
