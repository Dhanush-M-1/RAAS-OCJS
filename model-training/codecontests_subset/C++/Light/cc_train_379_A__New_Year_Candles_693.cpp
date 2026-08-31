#include <bits/stdc++.h>
int a, b, ans, aux, rem;
int main() {
  scanf("%d %d", &a, &b);
  while (a != 0) {
    aux = 0;
    ans += a;
    rem += (a % b);
    if (rem >= b) {
      aux = rem / b;
      rem = rem % b;
    }
    a = (a / b) + aux;
  }
  printf("%d", ans);
  return 0;
}
