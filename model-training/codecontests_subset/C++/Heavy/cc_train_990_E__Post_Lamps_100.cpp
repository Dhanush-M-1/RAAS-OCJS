#include <bits/stdc++.h>
#pragma GCC diagnostic ignored "-Wunused-result"
using namespace std;
const long long bm = 3 * (long long)(1e6);
long long n, m, k;
bool blocked[bm];
long long ui[bm];
long long ga[bm];
long long tc(long long x) {
  long long cc = 0;
  long long p = 0;
  while (p < n) {
    if (p == ga[p + x])
      return 1000000000000000000;
    else {
      p = ga[p + x];
      ++cc;
    }
  }
  return cc * ui[x];
}
long long solve() {
  scanf("%lld %lld %lld", &n, &m, &k);
  for (long long i = 0; i < m; i++) {
    long long x;
    scanf("%lld", &x);
    blocked[x] = true;
  }
  if (blocked[0]) return -1;
  for (long long i = 0; i < k; i++) scanf("%lld", &ui[i + 1]);
  long long lf = 0;
  for (long long i = 0; i < bm; i++) {
    if (i <= n && blocked[i] == false) {
      lf = i;
    }
    ga[i] = lf;
  }
  long long rd = 1000000000000000000;
  for (long long i = 0; i < k; i++) rd = min(rd, tc(i + 1));
  if (rd == 1000000000000000000) rd = -1;
  return rd;
}
signed main() { printf("%lld\n", solve()); }
