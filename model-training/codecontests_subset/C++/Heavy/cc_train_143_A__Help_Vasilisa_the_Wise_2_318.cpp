#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int a = 1; a <= 9; ++a) {
    for (int b = 1; b <= 9; ++b) {
      for (int c = 1; c <= 9; ++c) {
        for (int d = 1; d <= 9; ++d) {
          if (a == b or a == c or a == d or b == c or b == d or c == d)
            continue;
          if (a + b == r1 && a + d == d1 && a + c == c1 && b + d == c2 &&
              b + c == d2 && d + c == r2) {
            cout << a << " " << b << endl << c << " " << d << endl;
            return 0;
          }
        }
      }
    }
  }
  cout << -1 << endl;
  return 0;
}
