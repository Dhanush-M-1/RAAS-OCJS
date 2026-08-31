#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 10;
const long long INF = 0x3f3f3f3f3f3f3f3f;
long long n, tag[N << 2], ans[N], pos;
long long a[N], val[N << 2];
inline void pushup(long long o) { val[o] = min(val[o << 1], val[o << 1 | 1]); }
inline void apply(long long o, long long x) { val[o] += x, tag[o] += x; }
inline void pushdown(long long o) {
  if (tag[o]) {
    apply(o << 1, tag[o]);
    apply(o << 1 | 1, tag[o]);
    tag[o] = 0;
  }
}
inline void build(long long o, long long l, long long r) {
  if (l == r) {
    val[o] = a[l];
    return;
  }
  long long mid = (l + r) >> 1;
  build(o << 1, l, mid), build(o << 1 | 1, mid + 1, r);
  pushup(o);
}
inline void change(long long o, long long l, long long r, long long x,
                   long long y, long long z) {
  if (x <= l && r <= y) {
    apply(o, z);
    return;
  }
  long long mid = (l + r) >> 1;
  pushdown(o);
  if (x <= mid) change(o << 1, l, mid, x, y, z);
  if (y > mid) change(o << 1 | 1, mid + 1, r, x, y, z);
  pushup(o);
}
inline long long last_zero(long long o, long long l, long long r) {
  if (l == r) return l;
  pushdown(o);
  long long mid = (l + r) >> 1;
  if (val[o << 1 | 1] == 0)
    return last_zero(o << 1 | 1, mid + 1, r);
  else
    return last_zero(o << 1, l, mid);
}
inline long long query_min(long long o, long long l, long long r, long long x,
                           long long y) {
  if (l == r) return val[o];
  pushdown(o);
  long long mid = (l + r) >> 1;
  long long res = INF;
  if (x <= mid)
    res = min(res, query_min(o << 1, l, mid, x, y));
  else if (y > mid)
    res = min(res, query_min(o << 1 | 1, mid + 1, r, x, y));
  return res;
}
signed main() {
  cin >> n;
  for (register long long i = (1); i <= (n); ++i) cin >> a[i];
  memset(val, INF, sizeof(val));
  build(1, 1, n);
  for (register long long i = (1); i <= (n); ++i) {
    pos = last_zero(1, 1, n);
    if (pos == 1) cerr << i << ' ' << pos << endl;
    ans[pos] = i;
    change(1, 1, n, pos, pos, INF);
    change(1, 1, n, pos, n, -1ll * i);
  }
  for (register long long i = (1); i <= (n); ++i) cout << ans[i] << ' ';
  return 0;
}
