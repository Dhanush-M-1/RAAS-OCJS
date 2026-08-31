#include <bits/stdc++.h>
int main() {
  int a1, b, c, d, n, k = 4;
  std::cin >> n;
  int a[n];
  int i, i1, j;
  for (i = 1; i <= n; i++) {
    std::cin >> a1 >> b >> c;
    if (a1 > c) {
      std::cout << c << '\n';
    } else {
      std::cout << c * (b / c + 1) << '\n';
    }
  }
}
