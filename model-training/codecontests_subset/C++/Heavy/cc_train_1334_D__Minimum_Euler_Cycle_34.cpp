#include <bits/stdc++.h>
using namespace std;
const long long N = 300010;
long long t, n, a[N], b[N], x[N];
int main() {
  scanf("%lld", &t);
  while (t--) {
    long long l, r;
    scanf("%lld", &n);
    scanf("%lld%lld", &l, &r);
    long long tot = r - l + 1;
    long long high = n - 1, low = 1, mid, s = -1;
    while (high >= low) {
      mid = (high + low) / 2;
      long long c = (2 * ((mid * n) - (mid * (mid + 1)) / 2));
      if (c >= l) {
        s = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    if (s == -1) {
      printf("1\n");
      continue;
    }
    long long ps = s - 1, pre = (2 * ((ps * n) - (ps * (ps + 1)) / 2));
    long long pos = l - pre;
    while (tot > 0 && s < n) {
      long long len = (2 * (n - s));
      while (tot > 0 && pos <= len) {
        if (pos % 2)
          printf("%lld ", s);
        else {
          printf("%lld ", s + (pos / 2));
        }
        pos++;
        tot--;
      }
      if (tot > 0) {
        pos = 1;
        s++;
      }
    }
    if (tot) printf("1 ");
    printf("\n");
  }
  return 0;
}
