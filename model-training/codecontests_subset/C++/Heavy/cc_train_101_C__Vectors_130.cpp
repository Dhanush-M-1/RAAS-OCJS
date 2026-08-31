#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10, INF = 0x3f3f3f3f, MOD = 1e9 + 7;
struct P {
  long long x, y;
  P() {}
  P(long long x, long long y) : x(x), y(y) {}
  P rotate() { return P(-y, x); }
  P operator-(const P& rhs) const { return P(x - rhs.x, y - rhs.y); }
  long long operator*(const P& rhs) const { return x * rhs.x + y * rhs.y; }
  bool operator==(const P& rhs) const { return x == rhs.x && y == rhs.y; }
};
bool judge(P& u, P& v) {
  if (v == P(0, 0)) return u == P(0, 0);
  long long w = v.x * v.x + v.y * v.y;
  return u * v % w == 0 && u * v.rotate() % w == 0;
}
P a, b, c;
int main() {
  ios_base::sync_with_stdio(0);
  while (cin >> a.x >> a.y >> b.x >> b.y >> c.x >> c.y) {
    bool ok = false;
    for (int i = 0; i < 4; ++i) {
      P d = b - a;
      if (judge(d, c)) {
        ok = true;
        break;
      }
      a = a.rotate();
    }
    cout << (ok ? "YES" : "NO") << '\n';
  }
  return 0;
}
