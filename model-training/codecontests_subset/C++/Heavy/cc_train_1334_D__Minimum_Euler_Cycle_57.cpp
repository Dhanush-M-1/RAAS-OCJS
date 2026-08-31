#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 9;
int main() {
  long long i, j, m, n, t, l, r, fir, sec;
  scanf("%lld", &t);
  while (t--) {
    scanf("%lld %lld %lld", &n, &l, &r);
    long long pos = 0;
    for (i = 1; i <= n; i++) {
      if (i == n) {
        pos = -1;
        break;
      }
      pos += (n - i) * 2;
      if (pos >= l) {
        pos -= (n - i) * 2 - 1;
        fir = i;
        break;
      }
    }
    if (pos == -1) {
      cout << 1 << endl;
      continue;
    }
    long long dis = l - pos + 1;
    sec = (dis + 1) / 2 + i;
    while (l <= r) {
      if (fir == n)
        printf("%lld", 1ll);
      else if (l % 2 == 1)
        printf("%lld", fir);
      else {
        printf("%lld", sec++);
        if (sec > n) {
          fir++;
          sec = fir + 1;
        }
      }
      printf("%c", l == r ? '\n' : ' ');
      l++;
    }
  }
  return 0;
}
