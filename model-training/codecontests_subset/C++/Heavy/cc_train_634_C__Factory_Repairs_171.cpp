#include <bits/stdc++.h>
using namespace std;
const long long nmax = 200001;
const long long inf = (long long)1e9;
inline long long max(long long a, long long b) { return a > b ? a : b; }
inline long long min(long long a, long long b) { return a < b ? a : b; }
long long c1[nmax], c2[nmax];
long long n, k, a, b, q;
long long lowbit(long long s) { return s & (-s); }
void update(long long ind, long long val, long long* c) {
  while (ind <= n) {
    c[ind] += val;
    ind += lowbit(ind);
  }
}
long long sum(long long r, long long* c) {
  long long ret = 0;
  while (r > 0) {
    ret += c[r];
    r -= lowbit(r);
  }
  return ret;
}
long long query(long long l, long long r, long long* c) {
  long long ret = sum(r, c);
  ret -= sum(l - 1, c);
  return ret;
}
inline long long value(bool flag, long long vv, long long label) {
  if (flag == 0)
    return vv >= label ? label : vv;
  else
    return vv >= label ? label : vv;
}
long long f, d, v, p;
int main() {
  while (scanf("%lld%lld%lld%lld%lld", &n, &k, &a, &b, &q) != EOF) {
    memset(c1, 0, sizeof(c1));
    memset(c2, 0, sizeof(c2));
    long long relt = 0;
    for (long long i = 0; i < q; i++) {
      scanf("%lld", &f);
      if (f == 1) {
        scanf("%lld%lld", &d, &v);
        p = query(d, d, c1);
        if (p < b) update(d, value(0, v, b - p), c1);
        p = query(d, d, c2);
        if (p < a) update(d, value(1, v, a - p), c2);
      } else {
        scanf("%lld", &d);
        relt = sum(d - 1, c1);
        relt += query(d + k, n, c2);
        printf("%lld\n", relt);
      }
    }
  }
  return 0;
}
