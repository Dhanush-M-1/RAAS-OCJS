#include <bits/stdc++.h>
using namespace std;
int change(int n) {
  int p = 1;
  while (p * 2 <= n) {
    p *= 2;
  }
  return p;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  for (int a = 1; a <= 9; ++a) {
    for (int b = 1; b <= 9; ++b) {
      for (int c = 1; c <= 9; ++c) {
        for (int d = 1; d <= 9; ++d) {
          if (a + b == r1 && c + d == r2 && a + c == c1 && b + d == c2 &&
              a + d == d1 && b + c == d2 && a != b && a != c && a != d &&
              b != c && b != d && c != d) {
            cout << a << " " << b << "\n" << c << " " << d;
            return 0;
          }
        }
      }
    }
  }
  cout << -1;
  return 0;
}
