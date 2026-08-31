#include <bits/stdc++.h>
using namespace std;
const double EPS = 1e-9;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
template <typename t1>
t1 gcd(t1 a, t1 b) {
  return b == 0 ? a : gcd(b, a % b);
}
template <typename t1>
t1 lcm(t1 a, t1 b) {
  return a * (b / gcd(a, b));
}
int main() {
  int r1, r2, c1, c2, d1, d2;
  while (cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2) {
    int a, b, c, d;
    int flag = 0;
    for (int i = 1; i <= 9; i++) {
      for (int j = 1; j <= 9; j++) {
        for (int k = 1; k <= 9; k++) {
          for (int l = 1; l <= 9; l++) {
            if (i != j && i != k && i != l && j != k && j != l && k != l &&
                i + j == r1 && k + l == r2 && i + k == c1 && j + l == c2 &&
                i + l == d1 && j + k == d2) {
              a = i;
              b = j;
              c = k;
              d = l;
              flag = 1;
              break;
            }
          }
        }
      }
    }
    if (flag)
      cout << a << " " << b << endl << c << " " << d << endl;
    else
      cout << -1 << endl;
  }
}
