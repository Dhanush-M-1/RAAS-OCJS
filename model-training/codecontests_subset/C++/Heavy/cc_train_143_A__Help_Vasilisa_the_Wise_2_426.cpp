#include <bits/stdc++.h>
using namespace std;
bool within(signed short s) { return s >= 1 && s <= 9; }
int main() {
  ios_base::sync_with_stdio(0);
  signed short r1, r2, c1, c2, d1, d2, a, b, c, d;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  d = (d1 - r1 + c2) / 2;
  if (d * 2 != d1 - r1 + c2) {
    cout << -1;
    return 0;
  }
  b = c2 - d;
  a = d1 - d;
  c = c1 - a;
  map<signed short, signed short> m;
  m[a]++;
  m[b]++;
  m[c]++;
  m[d]++;
  if (m.size() == 4 && within(a) && within(b) && within(c) && within(d) &&
      d1 == a + d && d2 == b + c && r1 == a + b && r2 == c + d && c1 == a + c &&
      c2 == b + d)
    cout << a << " " << b << endl << c << " " << d;
  else
    cout << -1;
  return 0;
}
