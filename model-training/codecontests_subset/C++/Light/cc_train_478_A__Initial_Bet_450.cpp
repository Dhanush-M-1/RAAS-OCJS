#include <bits/stdc++.h>
int main() {
  int c1, c2, c3, c4, c5;
  std::cin >> c1 >> c2 >> c3 >> c4 >> c5;
  int sum = c1 + c2 + c3 + c4 + c5;
  std::cout << ((sum % 5 == 0 && sum != 0) ? (sum / 5) : -1);
}
