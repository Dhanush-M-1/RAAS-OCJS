#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int a = 1; a < 10; ++a) {
    for (int b = 1; b < 10; ++b) {
      for (int c = 1; c < 10; ++c) {
        for (int d = 1; d < 10; ++d) {
          if (a + d == d1 && c + b == d2 && a + b == r1 && c + d == r2 &&
              a + c == c1 && b + d == c2) {
            if (a != b && a != c && a != d && b != c && b != d && c != d) {
              cout << a << " " << b << endl << c << " " << d;
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
