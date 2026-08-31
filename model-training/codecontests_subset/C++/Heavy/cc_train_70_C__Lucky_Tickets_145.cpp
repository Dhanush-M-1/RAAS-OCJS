#include <bits/stdc++.h>
using namespace std;
map<double, int> mp1, mp2;
int rev(int k) {
  int p = 0;
  while (k > 0) {
    p = p * 10 + (k % 10);
    k /= 10;
  }
  return p;
}
int main() {
  double q;
  int MaxX, MaxY, w, ansx = 0, ansy = 0, x, y, cnt;
  cin >> MaxX >> MaxY >> w;
  for (x = 1; x <= MaxX; x++) {
    q = (double)(x * 1.0 / rev(x));
    mp1[q]++;
  }
  x = MaxX;
  y = 0;
  cnt = 0;
  while (y <= MaxY && x >= 1) {
    if (cnt < w) {
      y++;
      q = (double)((1.0 * rev(y)) / y);
      cnt += mp1[q];
      mp2[q]++;
    } else {
      if (ansx * ansy > x * y || ansx == 0) {
        ansx = x;
        ansy = y;
      }
      q = (double)((x * 1.0) / rev(x));
      cnt -= mp2[q];
      mp1[q]--;
      x--;
    }
  }
  if (ansx == 0)
    cout << -1;
  else
    cout << ansx << ' ' << ansy;
  return 0;
}
