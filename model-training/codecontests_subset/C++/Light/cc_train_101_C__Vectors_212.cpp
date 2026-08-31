#include <bits/stdc++.h>
using namespace std;
const int N = 100004;
long long xa, ya, xb, yb, xc, yc;
bool f(long long xa, long long ya, long long xb, long long yb) {
  xb -= xa;
  yb -= ya;
  if (xc == 0 && yc == 0) {
    return xb == 0 && yb == 0;
  }
  long long k1 = (xb * xc + yb * yc) / (xc * xc + yc * yc);
  long long k2 = (xc * yb - xb * yc) / (xc * xc + yc * yc);
  return k1 * xc - k2 * yc == xb && k1 * yc + k2 * xc == yb;
}
int main() {
  cin >> xa >> ya >> xb >> yb >> xc >> yc;
  puts(f(xa, ya, xb, yb) || f(-ya, xa, xb, yb) || f(-xa, -ya, xb, yb) ||
               f(ya, -xa, xb, yb)
           ? "YES"
           : "NO");
}
