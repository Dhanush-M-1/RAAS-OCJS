#include <bits/stdc++.h>
using namespace std;
long long w, mxx, mxy, ansx, ansy, sum;
map<double, long long> mp1, mp2;
long long rev(long long x) {
  long long xlh = 0;
  while (x) {
    xlh = xlh * 10 + x % 10;
    x /= 10;
  }
  return xlh;
}
int main() {
  long long i, x, y;
  double now;
  scanf("%lld%lld%lld", &mxx, &mxy, &w);
  for (i = 1; i <= mxx; i++) mp1[1.0 * i / rev(i)]++;
  for (i = 1; i <= mxy; i++) sum += mp1[1.0 * rev(i) / i];
  if (sum < w) return puts("-1"), 0;
  x = mxx;
  y = 1;
  sum = mp1[1];
  mp2[1]++;
  ansx = mxx;
  ansy = mxy;
  while (x >= 1 && y <= mxy) {
    if (sum >= w) {
      if (x * y < ansx * ansy) ansx = x, ansy = y;
      now = 1.0 * x / rev(x);
      sum -= mp2[now];
      mp1[now]--;
      x--;
    } else {
      y++;
      now = 1.0 * rev(y) / y;
      sum += mp1[now];
      mp2[now]++;
    }
  }
  printf("%lld %lld\n", ansx, ansy);
}
