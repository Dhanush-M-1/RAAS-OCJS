#include <bits/stdc++.h>
int main() {
  int a, b;
  std::cin >> a >> b;
  int hours = 0;
  int used = 0;
  while (a != 0) {
    --a;
    ++used;
    ++hours;
    if (used == b) {
      ++a;
      used = 0;
    }
  }
  std::cout << hours << std::endl;
  return 0;
}
