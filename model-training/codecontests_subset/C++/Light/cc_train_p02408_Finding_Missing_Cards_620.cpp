#include <iostream>

int n, a[4][13] = {};

void plus(char c, int m) {
  switch(c) {
  case 'S':
    a[0][m]++;
    break;
  case 'H':
    a[1][m]++;
    break;
  case 'C':
    a[2][m]++;
    break;
  case 'D':
    a[3][m]++;
  }
}

int main() {
  char b[4] = {'S', 'H', 'C', 'D'};
  std::cin >> n;
  for (int i = 0; i < n; i++) {
    char c;
    int m;
    std::cin >> c >> m;
    plus(c, m - 1);
  }
  for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 13; j++) {
      if (a[i][j] == 0) std::cout << b[i] << " " << j + 1 << std::endl;
    }
  }
  return 0;
}

