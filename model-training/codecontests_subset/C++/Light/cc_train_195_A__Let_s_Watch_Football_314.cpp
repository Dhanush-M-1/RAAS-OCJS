#include <bits/stdc++.h>
int main() {
  int a, b, c;
  scanf("%d %d %d", &a, &b, &c);
  int ini = 0, fim = (a * c + 1) / b;
  int resp = 0;
  for (int i = 0; i <= fim + 1; i++) {
    int time = i * b + b * c;
    if (time >= a * c) {
      resp = i;
      break;
    }
  }
  printf("%d\n", resp);
  return 0;
}
