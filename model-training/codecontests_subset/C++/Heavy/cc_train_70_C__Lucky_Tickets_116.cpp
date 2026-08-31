#include <bits/stdc++.h>
using namespace std;
int gcd(int x, int y) { return y == 0 ? x : gcd(y, x % y); }
int rev(int x) {
  int ret = 0;
  while (x) {
    ret = ret * 10 + x % 10;
    x /= 10;
  }
  return ret;
}
map<pair<int, int>, int> m1, m2;
int ansx, ansy;
void check(int x, int y) {
  if (ansx == -1 || ((long long)ansx) * ansy > ((long long)x) * y)
    ansx = x, ansy = y;
}
int main() {
  int xmax, ymax, w;
  ansx = ansy = -1;
  scanf("%d%d%d", &xmax, &ymax, &w);
  int now = 0, x = 0, y = ymax;
  for (int i = 1, j, d; i <= ymax; i++) {
    j = rev(i);
    d = gcd(i, j);
    m2[make_pair(i / d, j / d)]++;
  }
  for (x = 1; x <= xmax; x++) {
    int i = x, j = rev(x), d = gcd(i, j);
    m1[make_pair(i / d, j / d)]++;
    now += m2[make_pair(j / d, i / d)];
    while (now >= w) {
      check(x, y);
      i = y, j = rev(y), d = gcd(i, j);
      m2[make_pair(i / d, j / d)]--;
      now -= m1[make_pair(j / d, i / d)];
      y--;
    }
  }
  if (ansx == -1)
    puts("-1");
  else
    printf("%d %d\n", ansx, ansy);
  return 0;
}
