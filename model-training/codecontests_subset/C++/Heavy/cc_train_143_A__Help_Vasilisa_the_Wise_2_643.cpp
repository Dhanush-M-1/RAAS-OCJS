#include <bits/stdc++.h>
using namespace std;
void solve();
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
void solve() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a;
  bool ans = false;
  for (a = 1; a <= 9; ++a) {
    int b = r1 - a;
    int c = c1 - a;
    int d = d1 - a;
    if (a > 0 && a < 10 && b > 0 && b < 10 && c > 0 && c < 10 && d > 0 &&
        d < 10) {
      if (a != b && b != c && c != d && b != d && a != d && a != c) {
        if (a + b == r1 && c + d == r2 && a + c == c1 && b + d == c2 &&
            a + d == d1 && b + c == d2) {
          cout << a << " " << b << "\n";
          cout << c << " " << d << "\n";
          ans = true;
        }
      }
    }
  }
  if (!ans) cout << "-1";
}
