#include <bits/stdc++.h>
int main() {
  int sum, n, x;
  int a, b;
  while (~scanf("%d", &n)) {
    sum = 0;
    while (n--) {
      scanf("%d", &x);
      x /= 100;
      sum += x;
      x % 2 ? a++ : b++;
    }
    if (!a && b % 2 || sum % 2)
      printf("NO\n");
    else
      printf("YES\n");
  }
  return 0;
}
