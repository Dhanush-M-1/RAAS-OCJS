#include <bits/stdc++.h>
int main(void) {
  int n, i = 0;
  std::string first, second, third, fourth;
  std::cin >> first >> second >> n;
  std::cout << first << ' ' << second << '\n';
  for (int i = 0; i < n; i++) {
    std::cin >> third >> fourth;
    if (third == first) {
      first = fourth;
    } else {
      second = fourth;
    }
    std::cout << first << ' ' << second << '\n';
  }
  return 0;
}
