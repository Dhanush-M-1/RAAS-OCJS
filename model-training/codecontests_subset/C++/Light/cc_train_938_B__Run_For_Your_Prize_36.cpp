#include <bits/stdc++.h>
int main() {
  unsigned ya = 1, drug = 1000000, time_ya = 0, time_d = 0, n;
  std::cin >> n;
  for (auto i = 0; i < n; ++i) {
    unsigned temp;
    std::cin >> temp;
    if (temp - ya < drug - temp) {
      time_ya = std::max(time_ya, temp - ya);
    } else {
      time_d = std::max(time_d, drug - temp);
    }
  }
  std::cout << std::max(time_ya, time_d) << "\n";
}
