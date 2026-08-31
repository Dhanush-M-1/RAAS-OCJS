#include <complex>
#include <iostream>
using namespace std;
typedef complex<double> P;
double cr(P a, P b) {
  return (conj(a) * b).imag();
}
int main() {
  P a, b, c, d;
  double x1, y1, x2, y2, x3, y3, x4, y4;
  char cm;
  while (cin >> x1 >> cm >> y1 >> cm >> x2 >> cm >> y2 >> cm >> x3 >> cm >> y3
    >> cm >> x4 >> cm >> y4) {
    a = P(x1, y1), b = P(x2, y2), c = P(x3, y3), d = P(x4, y4);
    P e = a - b, f = b - c, g = c - d, h = d - a;
    double i = cr(e, f), j = cr(f, g), k = cr(g, h), l = cr(h, e);
    cout
      << ((i > 0 && j > 0 && k > 0 && l > 0)
        || (i < 0 && j < 0 && k < 0 && l < 0) ? "YES" : "NO") << endl;
  }
}