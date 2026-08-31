#include <bits/stdc++.h>
using namespace std;
long long a, b, c, l, r, m;
bool can(int m) {
  double w, t;
  w = m * b;
  w = w * c;
  t = a - b * c;
  w /= t;
  if (w >= c)
    return true;
  else
    return false;
}
int main() {
  cin >> a >> b >> c;
  a *= c;
  l = 0;
  r = 1000000;
  while (l + 1 < r) {
    m = (l + r) / 2;
    if (can(m))
      r = m;
    else
      l = m;
  }
  if (can(l)) r = l;
  cout << r << endl;
}
