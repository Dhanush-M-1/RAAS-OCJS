#include <bits/stdc++.h>
using namespace std;
int rev(int x) {
  int y = 0;
  while (x) {
    y = y * 10 + x % 10;
    x /= 10;
  }
  return y;
}
int gcd(int x, int y) {
  if (y == 0) return x;
  return gcd(y, x % y);
}
pair<int, int> fx(int x) {
  int g = gcd(x, rev(x));
  return make_pair(x / g, rev(x) / g);
}
pair<int, int> fy(int x) {
  int g = gcd(x, rev(x));
  return make_pair(rev(x) / g, x / g);
}
map<pair<int, int>, int> mx;
map<pair<int, int>, int> my;
int main() {
  int maxx, maxy, w;
  scanf("%d %d %d", &maxx, &maxy, &w);
  mx.clear();
  my.clear();
  int ansx, ansy;
  ansx = ansy = -1;
  for (int y = 1; y <= maxy; y++) my[fy(y)]++;
  int total = 0;
  int y = maxy;
  for (int x = 1; x <= maxx; x++) {
    total += my[fx(x)];
    mx[fx(x)]++;
    while (y > 1 && total >= w) {
      int add = mx[fy(y)];
      if (total - add < w) break;
      my[fy(y)]--;
      total -= add;
      y--;
    }
    if (total >= w) {
      if (ansx == -1) {
        ansx = x;
        ansy = y;
      } else if (x * y < ansx * ansy) {
        ansx = x;
        ansy = y;
      }
    }
  }
  if (ansx == -1)
    printf("-1\n");
  else
    printf("%d %d\n", ansx, ansy);
  return 0;
}
