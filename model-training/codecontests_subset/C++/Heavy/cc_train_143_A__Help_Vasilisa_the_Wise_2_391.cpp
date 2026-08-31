#include <bits/stdc++.h>
using namespace std;
bool isnumber(int a);
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  if ((c1 + c2) != (d1 + d2)) {
    cout << -1 << endl;
    return 0;
  }
  int a = d1 + r1 - c2;
  int b = r1 + c2 - d1;
  int c = d2 + r2 - c2;
  int d = r2 + c2 - d2;
  if (isnumber(a) || isnumber(b) || isnumber(c) || isnumber(d)) {
    cout << -1 << endl;
    return 0;
  }
  a /= 2;
  b /= 2;
  c /= 2;
  d /= 2;
  set<int> num;
  num.insert(a);
  num.insert(b);
  num.insert(c);
  num.insert(d);
  if (num.size() != 4) {
    cout << -1 << endl;
    return 0;
  }
  cout << a << " " << b << endl;
  cout << c << " " << d << endl;
  return 0;
}
bool isnumber(int a) { return (a % 2 || a < 1 || a > 18); }
