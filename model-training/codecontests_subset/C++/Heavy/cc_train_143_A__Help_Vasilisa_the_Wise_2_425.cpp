#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int a, b, c, d;
  c = c1 + d2 - r1;
  c /= 2;
  a = c1 - d2 + r1;
  a /= 2;
  b = r1 - a;
  d = d1 - a;
  vector<int> x;
  x.push_back(a);
  x.push_back(b);
  x.push_back(c);
  x.push_back(d);
  sort(x.begin(), x.end());
  for (int i = 0; i < 3; i++) {
    if (x[i] == x[i + 1] || x[i] > 9 || x[i + 1] > 9) {
      cout << -1 << endl;
      return 0;
    }
  }
  if (a <= 0 || b <= 0 || c <= 0 || d <= 0) {
    cout << -1 << endl;
    return 0;
  }
  if (a + b == r1 && a + c == c1 && a + d == d1 && b + c == d2 && d + b == c2 &&
      c + d == r2) {
    cout << a << " " << b << endl;
    cout << c << " " << d << endl;
  } else
    cout << -1 << endl;
}
