#include <bits/stdc++.h>
int main() {
  int n;
  std::cin >> n;
  std::string s;
  std::cin >> s;
  for (int i = 0; i < n - 1; i++) {
    if (s[i] > s[i + 1]) {
      std::cout << "YES\n" << i + 1 << " " << i + 2;
      return 0;
    }
  }
  std::cout << "NO";
  return 0;
}
