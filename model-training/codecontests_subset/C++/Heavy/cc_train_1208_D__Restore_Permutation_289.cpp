#include <bits/stdc++.h>
using namespace std;
const long long N = 1e6 + 5;
long long n, a[N], c[N], p[N];
inline long long read() {
  long long ret = 0, f = 0;
  char c = getchar();
  while (!isdigit(c)) {
    if (c == '-') f = 1;
    c = getchar();
  }
  while (isdigit(c)) {
    ret = ret * 10 + c - 48;
    c = getchar();
  }
  if (f) return -ret;
  return ret;
}
long long lowbit(long long x) { return x & -x; }
void add(long long x, long long y) {
  while (x <= n) {
    c[x] += y;
    x += lowbit(x);
  }
}
long long sum(long long x) {
  long long res = 0;
  while (x > 0) {
    res += c[x];
    x -= lowbit(x);
  }
  return res;
}
signed main() {
  n = read();
  for (long long i = 1; i <= n; i++) a[i] = read();
  for (long long i = 1; i <= n; i++) add(i, i);
  for (long long i = n; i; i--) {
    long long l = 1, r = n;
    while (l < r) {
      long long mid = (l + r + 1) / 2;
      if (sum(mid - 1) <= a[i])
        l = mid;
      else
        r = mid - 1;
    }
    p[i] = r;
    add(r, -r);
  }
  for (long long i = 1; i <= n; i++) printf("%d ", p[i]);
}
