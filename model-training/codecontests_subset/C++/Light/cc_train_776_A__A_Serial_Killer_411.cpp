#include <bits/stdc++.h>
int main() {
  std::ios::sync_with_stdio(0);
  std::cin.tie(0);
  int n;
  std::string s1, s2, st;
  std::cin >> s1 >> s2 >> n;
  for (int i = 0; i < n; ++i) {
    std::cout << s1 << ' ' << s2 << '\n';
    std::cin >> st;
    if (st == s1)
      std::cin >> s1;
    else
      std::cin >> s2;
  }
  std::cout << s1 << ' ' << s2 << '\n';
}
