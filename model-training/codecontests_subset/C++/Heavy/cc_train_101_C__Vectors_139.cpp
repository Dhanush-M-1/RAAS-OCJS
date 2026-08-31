#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:16777216")
using namespace std;
template <class T>
void pv(T a, T b) {
  for (T i = a; i != b; ++i) cout << *i << " ";
  cout << endl;
}
long long f(long long x) { return max(x, -x); }
int solve(long long x, long long y, long long x_, long long y_, long long a,
          long long b) {
  long long dx = x_ - x;
  long long dy = y_ - y;
  if (a == 0 && b == 0) {
    if (dx == 0 && dy == 0) return 1;
  }
  if (a == 0 && b != 0) {
    if (f(dx) % f(b) == 0 && f(dy) % f(b) == 0) return 1;
  }
  if (a != 0 && b == 0) {
    if (f(dx) % f(a) == 0 && f(dy) % f(a) == 0) return 1;
  }
  if (a != 0 && b != 0) {
    long long det = a * a + b * b;
    long long detA = a * dx + b * dy;
    long long detB = b * dx - a * dy;
    if (f(detA) % f(det) == 0 && f(detB) % f(det) == 0) return 1;
  }
  return 0;
}
void flip(long long &x, long long &y) {
  long long nx = -y, ny = x;
  x = nx, y = ny;
}
int main() {
  long long x, y, x_, y_, a, b;
  cin >> x >> y >> x_ >> y_ >> a >> b;
  for (int i = 0; i < (10); i++) {
    for (int j = 0; j < (10); j++) {
      if (solve(x, y, x_, y_, a, b)) {
        puts("YES");
        return 0;
      }
      flip(x_, y_);
    }
    flip(x, y);
  }
  puts("NO");
  return 0;
}
