#include <bits/stdc++.h>
int main() {
  unsigned int buttons, bulbs, switches, b;
  std::cin >> buttons >> bulbs;
  std::set<unsigned int> numbers;
  for (unsigned int idx = 0; idx < buttons; idx++) {
    std::cin >> switches;
    for (unsigned int jdx = 0; jdx < switches; jdx++) {
      std::cin >> b;
      numbers.insert(b);
    }
  }
  if (numbers.size() == bulbs)
    std::cout << "YES" << std::endl;
  else
    std::cout << "NO" << std::endl;
  return 0;
}
