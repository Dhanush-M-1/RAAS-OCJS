#include <bits/stdc++.h>
int main() {
  int n, x, y, k;
  std::cin >> n >> x >> y;
  k = ceil(n * y / 100.0) - x;
  if (k < 0) k = 0;
  std::cout << k;
  return 0;
}
