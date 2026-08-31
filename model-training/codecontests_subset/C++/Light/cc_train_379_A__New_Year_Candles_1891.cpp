#include <bits/stdc++.h>
int main() {
  int a, b, i, rem, sum;
  scanf("%d %d", &a, &b);
  for (i = sum = a; a > 0; i = a + rem) {
    a = i / b;
    rem = i % b;
    sum += a;
  }
  printf("%d", sum);
}
