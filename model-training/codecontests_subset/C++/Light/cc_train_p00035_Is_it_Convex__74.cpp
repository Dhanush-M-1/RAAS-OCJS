#include <bits/stdc++.h>
using namespace std;
#define EPS 1e-10
typedef complex<double> P;

double cross(P a, P b) {
  return (a.real() * b.imag() - a.imag() * b.real());
}

bool is_intersect(P a1, P a2, P b1, P b2) {
  return (cross(a2 - a1, b1 - a1) * cross(a2 - a1, b2 - a1) < EPS) &&
    (cross(b2 - b1, a1 - b1) * cross(b2 - b1, a2 - b1) < EPS);
}

int main() {
  double xa, ya, xb, yb, xc, yc, xd, yd;
  char d;
  while (cin >> xa >> d >> ya >> d >> xb >> d >> yb >> d >> xc >> d >> yc >> d >> xd >> d >> yd) {
    P a(xa, ya), b(xb, yb), c(xc, yc), d(xd, yd);
    if (is_intersect(a, c, b, d)) cout << "YES\n";
    else cout << "NO\n";
  }
}
