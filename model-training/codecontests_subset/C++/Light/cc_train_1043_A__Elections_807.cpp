#include <bits/stdc++.h>
using namespace std;
long long a[105], n, sum;
bool check(long long x) {
  long long tmp = 0;
  for (int i = 1; i <= n; i++) tmp += (x - a[i]);
  if (tmp > sum) return true;
  return false;
}
int main() {
  long long i, j, k, m, l, r, ans;
  while (scanf("%lld", &n) != EOF) {
    l = 0;
    sum = 0;
    for (i = 1; i <= n; i++) {
      scanf("%lld", &a[i]);
      sum += a[i];
      l = max(l, a[i]);
    }
    r = l * 105;
    while (l <= r) {
      long long mid = (l + r) / 2;
      if (check(mid)) {
        ans = mid;
        r = mid - 1;
      } else
        l = mid + 1;
    }
    printf("%lld\n", ans);
  }
}
