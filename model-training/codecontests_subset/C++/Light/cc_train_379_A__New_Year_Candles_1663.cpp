#include <bits/stdc++.h>
int main() {
  int a, b;
  scanf("%d %d", &a, &b);
  int tot = a;
  int temp = 0;
  while (a / b) {
    tot += (a / b);
    temp = a % b;
    a = (a / b) + temp;
  }
  printf("%d\n", tot);
  return 0;
}
