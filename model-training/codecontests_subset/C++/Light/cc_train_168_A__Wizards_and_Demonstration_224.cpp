#include <bits/stdc++.h>
using namespace std;
const int maxn = 100 + 5;
const int maxm = maxn * 4;
const double eps = 1e-8;
int sgn(double x) { return (x > eps) - (x < -eps); }
int main() {
  double n, x, y;
  int ret;
  while (cin >> n >> x >> y) {
    double r = n * y / 100;
    int xx = r;
    if (sgn(xx - r) != 0) xx++;
    if (x >= xx)
      ret = 0;
    else
      ret = xx - x;
    cout << ret << endl;
  }
}
