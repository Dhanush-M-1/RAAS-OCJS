#include <iostream>

int main() {
  int a, b;
  std::cin >> a >> b;
  std::cout << (a < 10 && b < 10 ? a * b : -1) << std::endl;
}