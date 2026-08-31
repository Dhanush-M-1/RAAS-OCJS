#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios::sync_with_stdio(false);
  long long int r1, r2, c1, c2, d1, d2, first = 0;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  long long int val = r1 + r2 + c1 + c2 + d1 + d2;
  if (val % 3 != 0) {
    cout << "-1";
    exit(0);
  }
  val /= 3;
  long long int a = 0, b = 0, c = 0, d = 0;
  for (a = 1; a <= 9; a++) {
    for (b = 1; b <= 9; b++) {
      for (c = 1; c <= 9; c++) {
        for (d = 1; d <= 9; d++) {
          if (a + b == r1 && c + d == r2 && a + c == c1 && b + d == c2 &&
              a + d == d1 && b + c == d2) {
            if (a != b && a != c && a != d && b != c && b != d && c != d) {
              first = 1;
              cout << a << " " << b << "\n" << c << " " << d;
            }
          }
        }
      }
    }
  }
  if (first == 0) {
    cout << "-1";
  }
  return 0;
}
