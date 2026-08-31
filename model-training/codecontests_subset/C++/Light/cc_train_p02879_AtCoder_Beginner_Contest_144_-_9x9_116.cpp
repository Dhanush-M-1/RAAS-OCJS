#include <iostream>

int main() {
  int a, b; std::cin >> a >> b;
  if(a >= 10 || b>= 10) std::cout << "-1";
  else std::cout << a*b;
  return 0;
}