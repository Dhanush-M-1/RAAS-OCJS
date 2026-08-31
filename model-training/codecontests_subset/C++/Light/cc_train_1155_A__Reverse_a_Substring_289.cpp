#include <bits/stdc++.h>
int main() {
  int num_lets;
  std::cin >> num_lets;
  char last_char = 0;
  char now_char = getchar();
  for (int i = 0; i < num_lets; ++i) {
    last_char = now_char;
    now_char = getchar();
    if (last_char > now_char) {
      std::cout << "YES\n" << i << ' ' << i + 1;
      return 0;
    }
  }
  std::cout << "NO";
  return 0;
}
