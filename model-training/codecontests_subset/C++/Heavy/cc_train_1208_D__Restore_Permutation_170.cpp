#include <bits/stdc++.h>
using namespace std;
long long n;
long long s[200001], up[200001];
long long d[200001], c[200001];
long long ans[200001];
inline long long lowbit(long long x) { return x & -x; }
inline long long getup(long long x) {
  long long ans = 0;
  for (; x; x -= lowbit(x)) ans += c[x];
  return ans;
}
inline void add(long long x, long long d) {
  for (; x <= n; x += lowbit(x)) c[x] += d;
}
long long mybound(long long x) {
  long long l = 1, r = n;
  while (l < r) {
    long long mid = (l + r + 1) >> 1;
    if (getup(mid) <= x)
      l = mid;
    else
      r = mid - 1;
  }
  return l;
}
signed main() {
  scanf("%lld", &n);
  for (long long i = 1; i <= n; i++) scanf("%lld", &s[i]);
  for (long long i = 1; i <= n; i++) up[i] = up[i - 1] + i - 1;
  for (long long i = 1; i <= n; i++) c[i] = up[i] - up[i - lowbit(i)];
  for (long long i = n; i >= 1; i--) {
    long long p = mybound(s[i]);
    ans[i] = p;
    add(p + 1, -p);
  }
  for (long long i = 1; i <= n; i++) printf("%lld ", ans[i]);
  putchar('\n');
  return 0;
}
