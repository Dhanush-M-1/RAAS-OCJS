#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  int r1, r2, d1, d2, c1, c2, a, b, c, d;
  cin >> r1 >> r2;
  cin >> d1 >> d2;
  cin >> c1 >> c2;
  a = (c1 + d1 - r2) / 2;
  b = c1 - a;
  c = r1 - a;
  d = r2 - b;
  if (a != b && a != c && a != d && b != c && b != d && c != d && a && b && c &&
      d && a <= 9 && b <= 9 && c <= 9 && d <= 9) {
    cout << a << " " << c << endl;
    cout << d << " " << b;
  } else
    cout << "-1";
  return 0;
}
