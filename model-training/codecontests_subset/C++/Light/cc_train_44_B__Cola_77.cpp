#include <bits/stdc++.h>
using namespace std;
const int maxn = 200005;
long long n, a, b, c;
long long Map[maxn];
int main() {
  while (scanf("%I64d%I64d%I64d%I64d", &n, &a, &b, &c) == 4) {
    memset(Map, 0, sizeof(Map));
    for (long long x1 = 0; x1 <= a; x1++)
      for (long long x2 = 0; x2 <= b; x2++) {
        long long cur = x1 + 2 * x2;
        if (cur > 2 * n) continue;
        Map[cur]++;
      }
    long long ans = 0;
    for (long long x3 = 0; x3 <= c; x3++) {
      long long rest = 2 * n - 4 * x3;
      if (rest >= 0) ans += Map[rest];
    }
    printf("%I64d\n", ans);
  }
  return 0;
}
