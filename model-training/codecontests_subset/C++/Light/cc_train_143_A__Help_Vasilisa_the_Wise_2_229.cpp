#include <bits/stdc++.h>
int main() {
  int r1, r2, c1, c2, d1, d2;
  std::cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int ii, j, jj;
  for (int i = 1; i != 10; ++i) {
    ii = r1 - i;
    j = c1 - i;
    jj = d1 - i;
    if (ii > 0 && ii < 10 && j > 0 && j < 10 && jj > 0 && jj < 10 &&
        j + ii == d2 && j + jj == r2 && ii + jj == c2 && i != ii && i != j &&
        i != jj && ii != j && ii != jj && j != jj) {
      std::cout << i << " " << ii << std::endl;
      std::cout << j << " " << jj << std::endl;
      return 0;
    }
  }
  std::cout << -1;
  return 0;
}
