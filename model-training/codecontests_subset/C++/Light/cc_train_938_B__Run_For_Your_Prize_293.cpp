#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  scanf("%lld", &n);
  long long a[n + 2];
  for (long long i = 1; i <= n; i++) {
    scanf("%lld", &a[i]);
  }
  long long ans = a[n] - 1;
  ans = min(ans, 1000000 - a[1]);
  for (long long i = 1; i <= n - 1; i++) {
    ans = min(ans, max(a[i] - 1, 1000000 - a[i + 1]));
  }
  printf("%lld\n", ans);
  return 0;
}
