#include <bits/stdc++.h>
int main() {
  int a, b, c;
  int res = 0;
  scanf("%d %d %d", &a, &b, &c);
  bool found = false;
  while (!found) {
    int data = res * b;
    int t0;
    for (t0 = res; t0 <= res + c; t0++) {
      if (data < (t0 - res) * a) {
        res++;
        break;
      } else {
        data += b;
      }
    }
    if (t0 == res + c + 1) found = true;
  }
  printf("%d", res);
}
