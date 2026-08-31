#include <bits/stdc++.h>
using namespace std;
struct pt {
  long long x, y;
  pt(long long xx, long long yy) { x = xx, y = yy; }
  pt() {}
  pt operator+(pt b) { return pt(x + b.x, y + b.y); }
  pt gir() { return pt(-y, x); }
  bool operator==(pt b) { return x == b.x and y == b.y; }
};
bool go(long long x1, long long y1, long long z1, long long x2, long long y2,
        long long z2) {
  long long det = x1 * y2 - x2 * y1;
  long long a = z1 * y2 - y1 * z2;
  long long b = x1 * z2 - x2 * z1;
  if (det != 0)
    return a % det == 0 and b % det == 0;
  else
    return z1 == z2 and z1 == 0;
}
int main() {
  pt a, b, c;
  cin >> a.x >> a.y;
  cin >> b.x >> b.y;
  cin >> c.x >> c.y;
  pt d = c.gir();
  bool vale = a == b;
  if (go(c.x, d.x, b.x - a.x, c.y, d.y, b.y - a.y)) vale = true;
  a = a.gir();
  if (go(c.x, d.x, b.x - a.x, c.y, d.y, b.y - a.y)) vale = true;
  a = a.gir();
  if (go(c.x, d.x, b.x - a.x, c.y, d.y, b.y - a.y)) vale = true;
  a = a.gir();
  if (go(c.x, d.x, b.x - a.x, c.y, d.y, b.y - a.y)) vale = true;
  if (vale)
    cout << "YES\n";
  else
    cout << "NO\n";
}
