#include <bits/stdc++.h>
using namespace std;
long long maxx, maxy, W, cnt, ansx, ansy;
map<double, long long> map1, map2;
inline int rev(int x) {
  int ans = 0;
  for (; x; x /= 10) (ans *= 10) += x % 10;
  return ans;
}
int main() {
  scanf("%lld%lld%lld", &maxx, &maxy, &W);
  for (int i = (1); i <= (maxx); ++i) ++map1[1. * i / rev(i)];
  for (int i = (1); i <= (maxy); ++i) cnt += map1[1. * rev(i) / i];
  if (cnt < W) return puts("-1"), 0;
  long long tx = maxx, ty = 1LL;
  long long ansx = maxx, ansy = maxy;
  cnt = map1[1.], ++map2[1.];
  while (tx && ty ^ maxy) {
    if (cnt >= W) {
      if (tx * ty < ansx * ansy) ansx = tx, ansy = ty;
      double quo = 1. * tx / rev(tx);
      --tx;
      cnt -= map2[quo], --map1[quo];
    } else {
      ++ty;
      double quo = 1. * rev(ty) / ty;
      cnt += map1[quo], ++map2[quo];
    }
  }
  printf("%lld %lld\n", ansx, ansy);
  return 0;
}
