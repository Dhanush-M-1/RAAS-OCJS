#include <bits/stdc++.h>
using namespace std;
int mx, mn, w, x, cc, y, ansx, ansy;
map<double, int> m1;
map<double, int> m2;
double q;
int dz(int x) {
  int ans = 0;
  while (x) ans = ans * 10 + (x % 10), x /= 10;
  return ans;
}
int main() {
  cin >> mx >> mn >> w;
  for (int i = 1; i <= mx; i++) q = i * 1.0 / dz(i), m1[q]++;
  x = mx;
  while (y <= mn && x >= 1) {
    if (cc < w && y < mn)
      y++, q = (dz(y) * 1.0) / y, cc += m1[q], m2[q]++;
    else if (cc >= w) {
      if (ansx * ansy > x * y || !ansx) ansx = x, ansy = y;
      q = (x * 1.0) / dz(x), cc -= m2[q], m1[q]--, x--;
    } else
      y = mn + 1;
  }
  if (ansx == 0)
    cout << -1;
  else
    cout << ansx << " " << ansy;
}
