#include <bits/stdc++.h>
using namespace std;
void ASS(bool b) {
  if (!b) {
    ++*(int*)0;
  }
}
struct P {
  int x, y;
  P() {}
  P(int xx, int yy) {
    x = xx;
    y = yy;
  }
  P rot() { return P(y, -x); }
  P operator-(P p) { return P(x - p.x, y - p.y); }
  void read() { cin >> x >> y; }
  bool eq(const P& p) const { return x == p.x && y == p.y; }
};
long long Dot(P a, P b) { return a.x * (long long)b.y - b.x * (long long)a.y; }
long long gcd(long long a, long long b) {
  if (a == 0 || b == 0) return a + b;
  a = max(a, -a);
  b = max(b, -b);
  while (a) {
    long long c = b % a;
    b = a;
    a = c;
  }
  return b;
}
bool Ok(P A, P B, P C) {
  if (A.eq(B)) return 1;
  P c0(C.x, C.y);
  P c1(C.y, -C.x);
  P c = B - A;
  long long d = Dot(c0, c1);
  if (d == 0) return 0;
  ASS(d != 0);
  long long L0 = Dot(c, c1);
  long long L1 = Dot(c0, c);
  return L0 % d == 0 && L1 % d == 0;
}
int main() {
  P a, b, c;
  a.read();
  b.read();
  c.read();
  for (int za = 0; za < (int)(4); za++) {
    for (int zb = 0; zb < (int)(4); zb++) {
      for (int zc = 0; zc < (int)(4); zc++) {
        if (Ok(a, b, c)) {
          cout << "YES" << endl;
          return 0;
        }
        c = c.rot();
      }
      b = b.rot();
    }
    a = a.rot();
  }
  cout << "NO" << endl;
  return 0;
}
