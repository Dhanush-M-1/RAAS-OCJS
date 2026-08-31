#include <bits/stdc++.h>
int a[10], n, x, cur;
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j++) {
      x = i * j;
      cur = 0;
      while (x) {
        a[cur++] = x % n;
        x /= n;
      }
      while (cur--) printf("%d", a[cur]);
      printf(" ");
    }
    puts("");
  }
}
