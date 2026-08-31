#include <bits/stdc++.h>
using namespace std;
map<double, long long> a1, a2;
long long maxx, maxy, w, cnt, l, r = 1, x, y;
double tmp;
inline long long qpow(register long long x) {
  long long ans = 0;
  while (x) {
    ans = ans * 10 + x % 10;
    x /= 10;
  }
  return ans;
}
int main() {
  scanf("%lld%lld%lld", &maxx, &maxy, &w);
  for (register int i = 1; i <= maxx; i++) a1[1.0 * i / qpow(i)]++;
  for (register int i = 1; i <= maxy; i++) cnt += a1[1.0 * qpow(i) / i];
  if (cnt < w) return puts("-1"), 0;
  l = x = maxx;
  y = maxy;
  cnt = a1[1.0];
  a2[1.0]++;
  while (l >= 1 && r <= maxy) {
    if (cnt >= w) {
      if (l * r < x * y) x = l, y = r;
      tmp = (double)l / qpow(l);
      cnt -= a2[tmp];
      a1[tmp]--;
      l--;
    } else {
      r++;
      tmp = (double)qpow(r) / r;
      cnt += a1[tmp];
      a2[tmp]++;
    }
  }
  printf("%lld %lld\n", x, y);
  return 0;
}
