#include <bits/stdc++.h>
using namespace std;
template <class TT>
TT abs(TT a) {
  if (a < 0) return -a;
  return a;
}
template <class ZZ>
ZZ max(ZZ a, ZZ b, ZZ c) {
  return max(a, max(b, c));
}
template <class ZZ>
ZZ min(ZZ a, ZZ b, ZZ c) {
  return min(a, min(b, c));
}
template <class ZZ>
ZZ sqr(ZZ a) {
  return a * a;
}
typedef struct {
  long long x, y;
} P;
P a, b, c;
bool f() {
  P o = (P){b.x - a.x, b.y - a.y};
  long long d = sqr(c.x) + sqr(c.y);
  long long u = o.x * c.y - o.y * c.x;
  if (!d) return !(o.x || o.y);
  if (u % d) return false;
  long long m = u / d;
  if (c.x) return ((o.x - m * c.y) % c.x == 0);
  if (c.y) return ((o.y + m * c.x) % c.y == 0);
  return true;
}
int main() {
  int i, k;
  P d;
  while (cin >> a.x >> a.y) {
    cin >> b.x >> b.y;
    cin >> c.x >> c.y;
    k = 1;
    for (i = 0; i < 4 && k; i++) {
      if (f()) {
        cout << "YES" << endl;
        k = 0;
      }
      d.x = -a.y;
      d.y = a.x;
      a = d;
    }
    if (k) cout << "NO" << endl;
  }
  return 0;
}
