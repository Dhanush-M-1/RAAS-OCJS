#include <iostream>

int main() {
  int A, B;
  std::cin >> A >> B;

  std::cout << ((A * B) % 2 == 0 ? "Even" : "Odd") << std::endl;
}
