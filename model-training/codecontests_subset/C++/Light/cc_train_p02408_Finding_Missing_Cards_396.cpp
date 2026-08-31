#include <iostream>

int main() {
  const int l_suits = 4, l_num = 13;
  char suits[l_suits]{'S', 'H', 'C', 'D'};
  bool cards[l_suits][l_num] = {};

  int n, j, num;
  char suit;
  std::cin >> n;
  for (int i = 0; i < n; i++) {
    std::cin >> suit >> num;
    j = 0;
    while (suits[j] != suit) {
      j++;
    }
    cards[j][num - 1] = true;
  }

  for (int i = 0; i < l_suits; i++) {
    for (int j = 0; j < l_num; j++) {
      if (!cards[i][j])
        std::cout << suits[i] << " " << j + 1 << std::endl;
    }
  }
}

