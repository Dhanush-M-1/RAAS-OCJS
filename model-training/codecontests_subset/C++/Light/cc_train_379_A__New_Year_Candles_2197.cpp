#include <bits/stdc++.h>
int main() {
  int a, b, c, count;
  scanf("%d%d", &a, &b);
  count = 0;
  c = a;
  count = count + c;
  while (c >= b) {
    c = c - b;
    c++;
    count++;
  }
  printf("%d", count);
  return 0;
}
