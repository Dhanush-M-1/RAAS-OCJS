#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0), cin.tie(nullptr), cout.tie(nullptr);
  int r1, r2, c1, c2, d1, d2, s1 = 0, s2 = 0, s3 = 0, s4 = 0, s5 = 0, s6 = 0,
                              i = 0, j = 0, l = 0, k = 0, a = 0, b = 0, c = 0,
                              d = 0;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  bool sqare = false;
  for (i = 1; i < 10; ++i) {
    for (j = 1; j < 10; ++j) {
      for (k = 1; k < 10; ++k) {
        for (l = 1; l < 10; ++l) {
          s1 = i + j;
          s2 = k + l;
          s3 = i + k;
          s4 = j + l;
          s5 = i + l;
          s6 = j + k;
          if (s1 == r1 && s2 == r2 && s3 == c1 && s4 == c2 && s5 == d1 &&
              s6 == d2) {
            sqare = true;
            a = i, b = j, c = k, d = l;
            break;
          }
        }
      }
    }
  }
  if (sqare && a != b && a != c && a != d && b != c && b != d && c != d)
    cout << a << " " << b << '\n' << c << " " << d << '\n';
  else
    cout << -1 << '\n';
  return 0;
}
