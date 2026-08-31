#include <bits/stdc++.h>
using namespace std;
long long n, m, k;
long long read() {
  long long s = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    s = s * 10 + ch - '0';
    ch = getchar();
  }
  return s * f;
}
inline void print(long long *f, long long len) {
  for (long long i = 0; i < len; i++) printf("%lld ", f[i]);
  puts("");
}
long long x[202020], y[202020];
signed main() {
  n = read();
  for (long long i = 1, iend = n; i <= iend; ++i) x[i] = read(), y[i] = read();
  x[n + 1] = 103134134134;
  long long ans = 0;
  for (long long i = 2, iend = n; i <= iend; ++i) {
    if (x[i] - x[i - 1] > y[i])
      ++ans;
    else if (x[i + 1] - x[i] > y[i])
      x[i] += y[i], ++ans;
  }
  cout << ans + 1;
}
