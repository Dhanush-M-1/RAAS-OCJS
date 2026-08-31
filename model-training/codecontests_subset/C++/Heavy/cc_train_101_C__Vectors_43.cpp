#include <bits/stdc++.h>
using namespace std;
struct point {
  long long x, y;
  point(long long _x = 0, long long _y = 0) {
    x = _x;
    y = _y;
  }
  point operator+(point w) { return point(x + w.x, y + w.y); }
  point operator-(point w) { return point(x - w.x, y - w.y); }
  point perp() { return point(-y, x); }
};
point A, B, C, D;
double det(long long a, long long b, long long c, long long d) {
  return (a * d - b * c);
}
bool cialo(double w) { return (w == (long long)(w)); }
int main() {
  cin >> A.x >> A.y >> B.x >> B.y >> C.x >> C.y;
  bool SOL = false;
  D = C.perp();
  for (int i = 0; i < 4; ++i) {
    if (A.x == B.x && A.y == B.y) {
      SOL = true;
      break;
    }
    double DP = det(C.x, D.x, C.y, D.y);
    if (DP == 0) {
      A = A.perp();
      continue;
    }
    point f = B - A;
    if (cialo(det(f.x, D.x, f.y, D.y) / DP) &&
        cialo(det(C.x, f.x, C.y, f.y) / DP)) {
      SOL = true;
      break;
    }
    A = A.perp();
  }
  if (SOL)
    cout << "YES\n";
  else
    cout << "NO\n";
  return 0;
}
