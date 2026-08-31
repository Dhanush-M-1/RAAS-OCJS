#include <bits/stdc++.h>
using namespace std;
int _bufint;
inline int in() {
  scanf("%d", &_bufint);
  return _bufint;
}
long long gcd(long long a, long long b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
const double eps = 1e-6;
const long long LINF = ~((1ll) << 63);
const int INF = ~(1 << 31);
const int maxn = 100000008;
struct query {
  int t, l, r, d;
  query(int _t, int _l, int _r, int _d) {
    t = _t;
    l = _l;
    r = _r;
    d = _d;
  }
};
vector<query> q;
int main() {
  int n = in(), m = in();
  vector<long long> v(n, maxn), delta(n, 0), res;
  for (int i = 0; i < m; ++i) {
    int t = in(), l = in(), r = in(), d = in();
    q.push_back(query(t, l, r, d));
    if (t == 1) {
      for (int j = l - 1; j < r; ++j) {
        v[j] += d, delta[j] -= d;
      }
    } else {
      for (int j = l - 1; j < r; ++j) {
        v[j] = min((long long)d, v[j]);
      }
    }
  }
  for (int i = 0; i < n; ++i) {
    v[i] += delta[i];
  }
  res = v;
  for (int i = 0; i < m; ++i) {
    int t = q[i].t, l = q[i].l, r = q[i].r, d = q[i].d;
    if (t == 1) {
      for (int j = l - 1; j < r; ++j) {
        v[j] += d;
      }
    } else {
      long long cur = -INF;
      for (int j = l - 1; j < r; ++j) {
        cur = max(v[j], cur);
      }
      if (cur != d) {
        puts("NO");
        return 0;
      }
    }
  }
  puts("YES");
  for (int i = 0; i < n; ++i) {
    printf("%d ", (int)(res[i]));
  }
  return 0;
}
