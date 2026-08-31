#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2, a, b, c, d;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (a = 1; a <= 9; a++)
    for (b = 1; b <= 9; b++)
      for (c = 1; c <= 9; c++)
        for (d = 1; d <= 9; d++) {
          if (a != b && a != c && a != d && b != c && b != d && c != d) {
            if (a + b == r1 && c + d == r2 && a + c == c1 && b + d == c2 &&
                a + d == d1 && b + c == d2) {
              cout << a << " " << b << endl;
              cout << c << " " << d << endl;
              return 0;
            }
          }
        }
  cout << "-1\n";
  return 0;
}
