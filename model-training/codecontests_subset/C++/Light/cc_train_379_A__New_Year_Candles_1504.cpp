#include <bits/stdc++.h>
int main() {
  int a, b, resp, recu;
  scanf("%d", &a);
  scanf("%d", &b);
  resp = a;
  while (a != 0) {
    if ((a % b) == 0) {
      a = a / b;
      resp = resp + a;
    } else {
      recu = a % b;
      a = a - recu;
      a = a / b;
      resp = resp + a;
      a = a + recu;
    }
    if (a < b) {
      a = 0;
    }
  }
  printf("%d", resp);
}
