#include <bits/stdc++.h>
using namespace std;
struct vect {
  long long x, y;
  void read() { cin >> x >> y; }
  long long length() { return x * x + y * y; }
};
long long operator*(vect a, vect b) { return a.x * b.x + a.y * b.y; }
vect rot(vect a) {
  vect b;
  b.x = a.y;
  b.y = -a.x;
  return b;
}
vect opposite(vect a) {
  vect b;
  b.x = -a.x;
  b.y = -a.y;
  return b;
}
int main() {
  vect a, b, c, d;
  a.read();
  b.read();
  c.read();
  if (c.x == 0 && c.y == 0) {
    if (a.length() == b.length() && (a * b == 0 || rot(a) * b == 0)) {
      cout << "YES";
      return 0;
    } else {
      cout << "NO";
      return 0;
    }
  }
  d = rot(c);
  for (int i = 0; i < 4; i++) {
    long long x = b.x - a.x, y = b.y - a.y;
    if (!c.x) swap(c, d);
    long long rest1 = (y * c.x - x * c.y) % (c.x * d.y - c.y * d.x);
    long long beta = (y * c.x - x * c.y) / (c.x * d.y - c.y * d.x);
    long long rest2 = (x - beta * d.x) % c.x;
    long long alpha = (x - beta * d.x) / c.x;
    if (rest1 == 0 && rest2 == 0) {
      cout << "YES";
      return 0;
    }
    if (i % 2 == 0)
      a = opposite(a);
    else
      a = rot(a);
  }
  cout << "NO";
  return 0;
}
