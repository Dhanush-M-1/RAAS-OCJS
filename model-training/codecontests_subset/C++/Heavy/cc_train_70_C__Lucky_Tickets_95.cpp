#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> mp0, mp1;
int gcd(int x, int y) {
  if (y == 0)
    return x;
  else
    return gcd(y, x % y);
}
int rev(int x) {
  int ret = 0;
  while (x) {
    ret = ret * 10 + x % 10;
    x /= 10;
  }
  return ret;
}
pair<int, int> SpeMakePair(int x, int y) {
  int g = gcd(x, y);
  return make_pair(x / g, y / g);
}
int main() {
  int maxx, maxy, w, x, y, ansx, ansy, noww;
  cin >> maxx >> maxy >> w;
  for (int i = 1; i <= maxx; i++) mp0[SpeMakePair(i, rev(i))]++;
  x = maxx;
  y = 0;
  noww = 0;
  ansx = 0;
  while (x > 0) {
    if (noww < w) {
      if (y < maxy)
        y++, noww += mp0[SpeMakePair(rev(y), y)], mp1[SpeMakePair(rev(y), y)]++;
      else
        break;
    } else {
      if (ansx == 0 || x * y < ansx * ansy) ansx = x, ansy = y;
      noww -= mp1[SpeMakePair(x, rev(x))];
      mp0[SpeMakePair(x, rev(x))]--;
      x--;
    }
  }
  if (ansx == 0)
    cout << -1 << endl;
  else
    cout << ansx << " " << ansy << endl;
  return 0;
}
