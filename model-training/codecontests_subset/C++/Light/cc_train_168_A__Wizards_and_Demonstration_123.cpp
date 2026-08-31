#include <bits/stdc++.h>
using namespace std;
int run() {
  int i, p, j;
  int n, x, y;
  scanf("%d %d %d", &n, &x, &y);
  p = y * n / 100;
  if ((y * n) % 100 != 0) p++;
  if (p > x)
    printf("%d\n", p - x);
  else
    puts("0");
  return 0;
}
int main() {
  run();
  return 0;
}
