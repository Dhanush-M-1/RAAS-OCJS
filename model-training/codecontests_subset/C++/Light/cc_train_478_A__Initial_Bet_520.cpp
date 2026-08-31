#include <bits/stdc++.h>
int d[5], n, f = 1;
int main() {
  for (int i = 0; i < 5; i++) {
    scanf("%d", &d[i]);
    if (d[i] < 0) f = 0;
    n += d[i];
  }
  if (n % 5 == 0 && f != 0 && n != 0)
    printf("%d\n", n / 5);
  else
    printf("-1\n");
}
