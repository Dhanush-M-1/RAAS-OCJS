#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int r1, r2, c1, c2, d1, d2;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> r1 >> r2;
  cin >> c1 >> c2;
  cin >> d1 >> d2;
  int a, b, c, d;
  int first_sum = r1 - c2 + d1;
  if (first_sum % 2 == 0) {
    a = first_sum / 2;
    b = r1 - a;
    c = c1 - a;
    d = d1 - a;
    if ((d2 - b != c) || (c2 - b != d) || (r2 - c != d)) {
      cout << "-1" << endl;
      return 0;
    }
    if (a > 0 && b > 0 && c > 0 && d > 0 && a < 10 && b < 10 && c < 10 &&
        d < 10 && a != b && a != c && a != d && b != c && b != d && c != d) {
      cout << a << " " << b << endl;
      cout << c << " " << d << endl;
    } else {
      cout << "-1" << endl;
    }
  } else {
    cout << "-1" << endl;
  }
  return 0;
}
