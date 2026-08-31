#include <bits/stdc++.h>
int main() {
  int a, b, c;
  scanf("%d%d%d", &a, &b, &c);
  int temp, x;
  x = (a * c);
  temp = (a * c) / b;
  if (x % b == 0) {
    temp = temp;
  } else {
    temp = temp + 1;
  }
  printf("%d\n", temp - c);
  return 0;
}
