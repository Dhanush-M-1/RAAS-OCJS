#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  scanf("%lld", &t);
  while (t--) {
    long long n, m, x, ans = -1;
    scanf("%lld%lld", &n, &m);
    map<long long, long long> mp;
    for (long long i = 0; i < n; i++) {
      scanf("%lld", &x);
      mp[x]++;
    }
    for (long long i = 0; i < m; i++) {
      scanf("%lld", &x);
      if (mp[x] > 0 && ans == -1) {
        ans = x;
      }
    }
    if (ans == -1) {
      printf("NO\n");
    } else {
      printf("YES\n");
      printf("1 %lld\n", ans);
    }
  }
  return 0;
}
