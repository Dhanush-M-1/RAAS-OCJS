#include <bits/stdc++.h>
int main() {
  int32_t n;
  std::cin >> n;
  int32_t t1 = 0;
  for (int32_t i = 0; i < n; i++) {
    int32_t value;
    std::cin >> value;
    t1 += value;
  }
  int32_t t2 = 0;
  for (int32_t i = 0; i < n - 1; i++) {
    int32_t value;
    std::cin >> value;
    t2 += value;
  }
  int32_t t3 = 0;
  for (int32_t i = 0; i < n - 2; i++) {
    int32_t value;
    std::cin >> value;
    t3 += value;
  }
  std::cout << t1 - t2 << std::endl;
  std::cout << t2 - t3 << std::endl;
  return 0;
}
