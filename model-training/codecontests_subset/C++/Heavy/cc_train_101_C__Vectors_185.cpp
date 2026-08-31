#include <bits/stdc++.h>
using namespace std;
const long double eps = 1e-9;
long long xabs(long long a) { return a < 0 ? -a : +a; }
bool check(long long p, long long q, long long x, long long y, long long a,
           long long b) {
  if (a * x + b * y == p && a * y - b * x == q)
    return true;
  else
    return false;
}
bool can(long long ax, long long ay, long long bx, long long by, long long x,
         long long y) {
  long long p = bx - ax;
  long long q = by - ay;
  if (x == 0 && y == 0) {
    if (p == 0 && q == 0)
      return true;
    else
      return false;
  }
  if (y != 0) swap(x, y), swap(p, q);
  long long b = (p * y - q * x) / (y * y + x * x);
  long long a = (p - b * y) / x;
  if (check(p, q, x, y, a, b))
    return true;
  else
    return false;
}
int main() {
  long long ax, ay, bx, by, x, y;
  cin >> ax >> ay >> bx >> by >> x >> y;
  bool fl = false;
  for (int i = 0; i < 4; ++i) {
    fl |= can(ax, ay, bx, by, x, y);
    swap(ax, ay);
    ax = -ax;
  }
  if (fl)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
