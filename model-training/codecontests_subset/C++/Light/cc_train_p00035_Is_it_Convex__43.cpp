#include <iostream>
#include <cmath>
#include <complex>
using namespace std;
typedef complex<double> C;
#define EPS (1e-8)
double cross(C a, C b) {
  return a.real() * b.imag() - a.imag() * b.real();
}
const string mes[2] = {"YES", "NO"};
double xa, ya, xb, yb, xc, yc, xd, yd;

void solve() {
  C a(xa, ya), b(xb, yb), c(xc, yc), d(xd, yd);
  // ABC
  // BCD
  // CDA
  // DAB
  double scross = 
    cross(a-b,b-c) * cross(b-c,c-d) * cross(c-d,d-a) * cross(d-a,a-b);
  int res = (scross > EPS) ? 0 : 1 ;
  cout<<mes[res]<<endl;
}

int main (int argc, char const* argv[]) {
  char c;
  while (cin>>xa>>c>>ya>>c>>xb>>c>>yb>>c>>xc>>c>>yc>>c>>xd>>c>>yd) {
    solve();
  }
  return 0;
}