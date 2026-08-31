#include <bits/stdc++.h>
int main() {
  int a, b, c;
  while (scanf("%d%d%d", &a, &b, &c) != EOF) {
    int res = c * (a - b) / b;
    if (c * (a - b) % b != 0) res++;
    printf("%d\n", res);
  }
  return 0;
}
