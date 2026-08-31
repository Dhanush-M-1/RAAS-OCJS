#include <bits/stdc++.h>
using namespace std;
int mx, mn, w, x, cc, y, ansx, ansy;
map<double, int> m1, m2;
double q;
int rev(int x) {
  int ret = 0;
  while (x > 0) ret = ret * 10 + (x % 10), x /= 10;
  return ret;
}
int main() {
  cin >> mx >> mn >> w;
  for (int i = 1; i <= mx; i++) q = i * 1.0 / rev(i), m1[q]++;
  x = mx;
  while (y <= mn && x >= 1) {
    if (cc < w && y < mn)
      y++, q = (rev(y) * 1.0) / y, cc += m1[q], m2[q]++;
    else if (cc >= w) {
      if (ansx * ansy > x * y || !ansx) ansx = x, ansy = y;
      q = (x * 1.0) / rev(x), cc -= m2[q], m1[q]--, x--;
    } else
      y = mn + 1;
  }
  if (!ansx)
    cout << -1;
  else
    cout << ansx << " " << ansy;
}
