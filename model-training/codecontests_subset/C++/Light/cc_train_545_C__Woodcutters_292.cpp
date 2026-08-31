#include <bits/stdc++.h>
using namespace std;
struct nd {
  long long x, h;
} a[123456];
int main() {
  long long i, m, n, p, pr, j, l, ck, cnt = 1, stor, r;
  scanf("%lld", &pr);
  if (pr >= 2) {
    cnt = 2;
  }
  for (i = 0; i < pr; i++) {
    scanf("%lld%lld", &a[i].x, &a[i].h);
  }
  ck = a[0].x;
  for (i = 1; i < pr - 1; i++) {
    m = a[i].x - a[i].h;
    n = a[i].x + a[i].h;
    r = a[i + 1].x;
    if (ck < m || r > n) {
      cnt++;
    }
    if (ck >= m && r > n) {
      ck = n;
    } else {
      ck = a[i].x;
    }
  }
  printf("%lld\n", cnt);
  return 0;
}
