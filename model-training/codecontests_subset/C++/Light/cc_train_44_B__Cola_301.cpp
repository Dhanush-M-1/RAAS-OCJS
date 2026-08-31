#include <bits/stdc++.h>
int main() {
  int n, a, b, c, ways = 0;
  scanf("%d %d %d %d", &n, &a, &b, &c);
  int x = a / 2;
  for (int i = c * 2; i >= 0; i -= 2) {
    if (i == n) {
      ways++;
    } else if (i < n) {
      for (int j = b; j >= 0; j--) {
        if (i + j == n) {
          ways++;
        } else if (i + j < n) {
          if (i + j + x >= n) {
            ways++;
          }
        }
      }
    }
  }
  printf("%d\n", ways);
  return 0;
}
