#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2, a, b, c, d;
  while (cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2) {
    int i, j, k, m;
    bool flag = 0;
    for (i = 1; i <= 9; ++i)
      for (j = 1; j <= 9; ++j)
        for (k = 1; k <= 9; ++k)
          for (m = 1; m <= 9; ++m)
            if (i + j == r1 && k + m == r2 && i + k == c1 && j + m == c2 &&
                i + m == d1 && j + k == d2 &&
                (i != j && i != k && i != m && j != k && j != m && k != m)) {
              flag = 1;
              goto loop;
            }
  loop:
    if (flag) {
      printf("%d %d\n%d %d\n", i, j, k, m);
    } else
      puts("-1");
  }
}
