#include <bits/stdc++.h>
int main() {
  std::ios::sync_with_stdio(0);
  std::cin.tie(0);
  int n, sum = 0;
  std::cin >> n;
  int c1 = 0, c2 = 0;
  for (int i = 0, tp; i < n; ++i) {
    std::cin >> tp;
    if (tp == 100)
      ++c1;
    else
      ++c2;
  }
  sum = c1 + c2 * 2;
  if (sum % 2) {
    std::cout << "NO";
    return 0;
  }
  sum /= 2;
  if (sum % 2 && !c1) {
    std::cout << "NO";
    return 0;
  }
  std::cout << "YES";
}
