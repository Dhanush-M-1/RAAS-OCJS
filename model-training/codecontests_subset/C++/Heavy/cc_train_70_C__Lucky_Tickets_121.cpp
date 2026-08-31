#include <bits/stdc++.h>
using namespace std;
int mx, my, w, x, y, tot, bestx = 100001, besty = 100001;
map<pair<int, int>, int> xc, yc;
pair<int, int> xfr[100001], yfr[100001];
int rev(int a) {
  int b = 0;
  for (; a; a /= 10) b = b * 10 + a % 10;
  return b;
}
int gcd(int a, int b) {
  while (b) {
    int t = b;
    b = a % b;
    a = t;
  }
  return a;
}
pair<int, int> frac(int a, int b) {
  int g = gcd(a, b);
  return make_pair(a / g, b / g);
}
int main() {
  scanf("%d%d%d", &mx, &my, &w);
  for (x = 1; x <= mx; x++) xfr[x] = frac(x, rev(x));
  for (y = 1; y <= my; y++) yfr[y] = frac(rev(y), y);
  for (x = 1; x <= mx; x++) xc[xfr[x]]++;
  for (x = mx, y = 1; x; x--) {
    for (; tot + xc[yfr[y]] < w && y <= my; y++) {
      yc[yfr[y]]++;
      tot += xc[yfr[y]];
    }
    if (tot + xc[yfr[y]] >= w && (long long)x * y < (long long)bestx * besty)
      bestx = x, besty = y;
    xc[xfr[x]]--;
    tot -= yc[xfr[x]];
  }
  if (bestx != 100001)
    printf("%d %d\n", bestx, besty);
  else
    printf("-1\n");
  return 0;
}
