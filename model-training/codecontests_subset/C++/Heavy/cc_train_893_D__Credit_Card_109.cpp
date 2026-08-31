#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18;
long long n, d, a[100005], sum[100005], maxm[100005], now, ans;
int main() {
  while (~scanf("%lld %lld", &n, &d)) {
    maxm[n + 1] = -1e18;
    for (long long i = 1; i <= n; i++) {
      maxm[i] = -1e18;
      scanf("%lld", &a[i]);
      sum[i] = sum[i - 1] + a[i];
    }
    for (long long i = n; i >= 1; i--) {
      maxm[i] = max(maxm[i + 1], sum[i]);
    }
    if (maxm[1] > d) {
      printf("-1\n");
      return 0;
    }
    for (long long i = 1; i <= n; i++) {
      if (a[i] == 0) {
        if (now + sum[i] < 0) {
          long long M = maxm[i];
          long long c = d - (M + now);
          if (c <= 0) {
            printf("-1\n");
            return 0;
          } else {
            now += c;
            ans++;
          }
        }
        if (now + sum[i] < 0) {
          printf("-1\n");
          return 0;
        }
      }
    }
    printf("%lld\n", ans);
  }
}
