#include <bits/stdc++.h>
int main(int argc, const char* argv[]) {
  int n;
  std::cin >> n;
  int sum = 0, max = -1;
  for (int i = 0; i < n; i++) {
    int t;
    std::cin >> t;
    max = std::max(max, t);
    sum += t;
  }
  std::cout << std::max((2 * sum / n) + 1, max) << std::endl;
}
