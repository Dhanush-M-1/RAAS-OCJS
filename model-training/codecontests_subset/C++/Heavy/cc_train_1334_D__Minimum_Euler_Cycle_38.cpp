#include <bits/stdc++.h>
using namespace std;
long long n, t, l, r, o, e, pos;
long long Find(long long k) {
  long long t = k;
  if (t % 2 == 1)
    t = (t + 1) / 2;
  else
    t /= 2;
  for (long long i = 0; i <= n - 1; i++) {
    if (n * i - i * (i + 1) / 2 < t && t <= n * (i + 1) - (i + 1) * (i + 2) / 2)
      return i + 1;
  }
}
int main() {
  scanf("%lld", &t);
  while (t--) {
    scanf("%lld%lld%lld", &n, &l, &r);
    if (l % 2 == 0) {
      o = l + 1;
      e = l + 2;
      pos = Find(l);
    } else {
      o = l;
      e = l + 1;
    }
    long long s1 = Find(o);
    long long cnt = Find(e);
    long long s2 = e / 2 - ((cnt - 1) * n - (cnt - 1) * cnt / 2) + cnt;
    if (l % 2 == 0) {
      printf("%lld ", l / 2 - ((pos - 1) * n - (pos - 1) * pos / 2) + pos);
    }
    for (long long i = o; i <= r; i++) {
      if (i == n * (n - 1) + 1) {
        printf("1");
        break;
      }
      if (i % 2) {
        printf("%lld ", s1);
        if (s2 == n) s1++;
      } else {
        printf("%lld ", s2);
        s2++;
        if (s2 > n) s2 = s1 + 1;
      }
    }
    puts("");
  }
  return 0;
}
