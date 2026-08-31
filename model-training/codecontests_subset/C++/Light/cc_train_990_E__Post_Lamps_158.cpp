#include <bits/stdc++.h>
using namespace std;
long long n, m, k;
bool blocked[1000000];
long long r[1000000];
long long crap;
int32_t main() {
  ios_base::sync_with_stdio(false);
  scanf("%lld %lld %lld", &n, &m, &k);
  for (long long i = 0; i < m; ++i) {
    long long x;
    scanf("%lld", &x);
    blocked[x] = true;
  }
  if (blocked[0]) {
    printf("-1\n");
    return 0;
  }
  long long longestBlock = 0;
  long long curBlock = 0;
  for (long long i = 0; i < n; ++i) {
    if (blocked[i]) {
      r[i] = r[i - 1];
      curBlock++;
      longestBlock = max(longestBlock, curBlock);
    } else {
      r[i] = i;
      curBlock = 0;
    }
  }
  if (longestBlock + 1 > k) {
    printf("-1\n");
    return 0;
  }
  long long res = 1e18;
  for (long long l = 1; l <= longestBlock; ++l) scanf("%d", &crap);
  for (long long l = longestBlock + 1; l <= k; ++l) {
    long long c;
    scanf("%lld", &c);
    long long cur = 0;
    long long i = 0;
    while (true) {
      cur += c;
      if (i + l >= n) break;
      i = r[i + l];
    }
    res = min(res, cur);
  }
  printf("%lld\n", res);
}
