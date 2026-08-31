#include <bits/stdc++.h>
using namespace std;
long long anss = 1e15, ansx, ansy;
map<double, long long> mp1, mp2;
double x[500005], y[500005];
long long work(long long x) {
  long long ans = 0;
  while (x) {
    ans = ans * 10 + x % 10;
    x /= 10;
  }
  return ans;
}
signed main() {
  long long xx, yy, w, ans = 0;
  scanf("%lld%lld%lld", &xx, &yy, &w);
  for (long long i = 1; i <= xx; i++) {
    x[i] = i;
    x[i] /= work(i);
    mp1[x[i]]++;
  }
  for (long long i = 1; i <= yy; i++) {
    y[i] = work(i);
    y[i] /= i;
  }
  long long xxx = xx, yyy = 1;
  ans += mp1[y[1]];
  mp2[y[1]]++;
  while (xxx >= 1 && yyy <= yy) {
    if (ans >= w) {
      if (anss > xxx * yyy) {
        ansx = xxx;
        ansy = yyy;
        anss = xxx * yyy;
      }
      ans -= mp2[x[xxx]];
      mp1[x[xxx]]--;
      xxx--;
    } else {
      yyy++;
      ans += mp1[y[yyy]];
      mp2[y[yyy]]++;
    }
  }
  if (anss == 1e15)
    printf("-1\n");
  else
    printf("%lld %lld\n", ansx, ansy);
  return 0;
}
