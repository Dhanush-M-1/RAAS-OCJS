#include <bits/stdc++.h>
int main() {
  int n, k, a[10010], max = 200;
  std::cin >> n >> k;
  for (int i = 0; i < n; ++i) {
    int x;
    std::cin >> x;
    if (k % x == 0) {
      max = std::min(max, k / x);
    }
  }
  std::cout << max;
}
