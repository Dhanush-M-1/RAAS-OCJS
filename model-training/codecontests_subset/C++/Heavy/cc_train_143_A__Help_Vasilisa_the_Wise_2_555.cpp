#include <bits/stdc++.h>
using namespace std;
int notIdentical(int a, int b, int c, int d) {
  if (a != b && b != c && c != d && d != a && a != c && b != d) return 1;
  return 0;
}
int main() {
  int r1, r2, c1, c2, d1, d2, i;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (i = 1; i <= 9; ++i) {
    if (r1 - i >= 1 && r1 - i <= 9) {
      if (c1 - i >= 1 && c1 - i <= 9) {
        if (r2 - c1 + i >= 1 && r2 - c1 + i <= 9) {
          if (notIdentical(i, r1 - i, c1 - i, r2 - c1 + i)) {
            if (2 * i + r2 - c1 == d1 && r1 + c1 - i * 2 == d2) {
              cout << i << " " << r1 - i << endl
                   << c1 - i << " " << r2 - c1 + i;
              return 0;
            }
          }
        }
      }
    }
  }
  cout << -1;
  return 0;
}
