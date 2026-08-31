#include <bits/stdc++.h>
int n;
int a, b;
int w;
int main() {
  while (scanf("%d", &n) != -1) {
    a = b = 0;
    for (int i = 0; i < n; i++) {
      scanf("%d", &w);
      if (w == 100)
        a++;
      else
        b++;
    }
    if (b % 2 == 0 && a % 2 == 0) {
      printf("YES\n");
    } else if (a % 2 == 1 && b % 2 == 0) {
      printf("NO\n");
    } else if (a % 2 == 1 && b % 2 == 1) {
      printf("NO\n");
    } else if (a % 2 == 0 && b % 2 == 1) {
      if (a >= 2)
        printf("YES\n");
      else
        printf("NO\n");
    }
  }
  return 0;
}
