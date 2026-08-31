#include <bits/stdc++.h>
int main() {
  std::ios::sync_with_stdio(false);
  int buttons, bulbs;
  std::cin >> buttons >> bulbs;
  bool *on = new bool[bulbs];
  for (int i = 0; i < bulbs; ++i) {
    on[i] = false;
  }
  for (int i = 0; i < buttons; ++i) {
    int temp;
    std::cin >> temp;
    for (int j = 0; j < temp; ++j) {
      int temp2;
      std::cin >> temp2;
      on[temp2 - 1] = true;
    }
  }
  for (int i = 0; i < bulbs; ++i) {
    if (!on[i]) {
      std::cout << "NO\n";
      return 0;
    }
  }
  std::cout << "YES\n";
}
