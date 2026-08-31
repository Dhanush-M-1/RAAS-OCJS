#include <bits/stdc++.h>
int ceil_div(int num, int d) { return (num + d - 1) / d; }
int main() {
  int a, b, c;
  std::scanf("%d%d%d", &a, &b, &c);
  std::printf("%d\n", ceil_div(a * c, b) - c);
  return 0;
}
