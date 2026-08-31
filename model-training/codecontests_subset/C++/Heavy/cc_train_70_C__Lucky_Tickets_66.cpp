#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
const int mod = 1e9 + 7;
const int maxn = 1e5 + 100;
map<double, long long> mp1, mp2;
long long rev(long long x) {
  long long ans = 0;
  while (x) {
    ans = ans * 10 + x % 10;
    x /= 10;
  }
  return ans;
}
int main() {
  long long w, maxy, maxx, cnt = 0;
  scanf("%lld%lld%lld", &maxx, &maxy, &w);
  for (long long i = 1; i <= maxx; i++) mp1[1.0 * i / rev(i)]++;
  for (long long i = 1; i <= maxy; i++) cnt += mp1[1.0 * rev(i) / i];
  if (cnt < w) {
    cout << -1 << endl;
    return 0;
  }
  long long tx = maxx, ty = 1, ax = maxx, ay = maxy;
  cnt = mp1[1.0];
  mp2[1.0]++;
  while (tx >= 1 && ty <= maxy) {
    if (cnt >= w) {
      if (tx * ty < ax * ay) ax = tx, ay = ty;
      double tmp = 1.0 * tx / rev(tx);
      cnt -= mp2[tmp];
      mp1[tmp]--;
      tx--;
    } else {
      ty++;
      double tmp = 1.0 * rev(ty) / ty;
      cnt += mp1[tmp];
      mp2[tmp]++;
    }
  }
  printf("%lld %lld\n", ax, ay);
  return 0;
}
