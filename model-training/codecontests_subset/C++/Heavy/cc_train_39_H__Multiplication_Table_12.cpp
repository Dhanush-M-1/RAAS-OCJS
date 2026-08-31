#include <bits/stdc++.h>
void answer(const std::vector<std::vector<std::string>>& v) {
  for (const auto& r : v) {
    const char* separator = "";
    for (const std::string& x : r) {
      std::cout << separator << x;
      separator = " ";
    }
    std::cout << '\n';
  }
}
void solve(unsigned k) {
  const size_t n = k - 1;
  std::vector<std::vector<std::string>> t(n, std::vector<std::string>(n));
  for (size_t i = 0; i < n; ++i) {
    for (size_t j = 0; j < n; ++j) {
      unsigned c = (i + 1) * (j + 1);
      do {
        t[i][j].push_back('0' + c % k);
        c /= k;
      } while (c != 0);
      std::reverse(t[i][j].begin(), t[i][j].end());
    }
  }
  answer(t);
}
int main() {
  unsigned k;
  std::cin >> k;
  solve(k);
  return 0;
}
