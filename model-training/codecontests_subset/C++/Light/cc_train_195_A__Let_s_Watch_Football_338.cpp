#include <bits/stdc++.h>
int main() {
  int a, b, c;
  scanf("%d %d %d", &a, &b, &c);
  int extra = a * c - b * c;
  int t = extra / b;
  if (extra % b != 0) {
    t++;
  }
  printf("%d\n", t);
  return 0;
}
