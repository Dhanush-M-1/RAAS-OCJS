#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e18;
int main() {
  int n;
  scanf("%d", &n);
  long long result = INF, last = 1LL;
  for (int i = 0; i < n; ++i) {
    long long x;
    scanf("%lld", &x);
    result = min(result, max((long long)1e6 - x, (long long)last - 1LL));
    last = x;
  }
  printf("%lld", min(result, last - 1LL));
  return 0;
}
