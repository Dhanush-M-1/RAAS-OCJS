#include <bits/stdc++.h>
using namespace std;
template <typename Tp>
void read(Tp &x) {
  x = 0;
  long long f = 1;
  char c = getchar();
  while (c > '9' || c < '0') {
    if (c == '-') {
      f = -1;
    }
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = (x << 1) + (x << 3) + (c ^ 48);
    c = getchar();
  }
  x *= f;
}
long long n, m;
long long s[200005], a[200005];
long long st[200005 << 2], ps[200005 << 2], laz[200005 << 2];
void pushup(long long x) {
  st[x] = min(st[(x << 1)], st[((x << 1) | 1)]);
  if (st[x] == st[((x << 1) | 1)])
    ps[x] = ps[((x << 1) | 1)];
  else
    ps[x] = ps[(x << 1)];
}
void build(long long x, long long l, long long r) {
  if (l == r) {
    st[x] = s[l];
    ps[x] = l;
    return;
  }
  build((x << 1), l, ((l + r) >> 1));
  build(((x << 1) | 1), ((l + r) >> 1) + 1, r);
  pushup(x);
}
void pushdown(long long x) {
  if (laz[x]) {
    laz[(x << 1)] += laz[x];
    laz[((x << 1) | 1)] += laz[x];
    st[(x << 1)] += laz[x];
    st[((x << 1) | 1)] += laz[x];
    laz[x] = 0;
  }
}
void upd(long long x, long long l, long long r, long long L, long long R,
         long long v) {
  if (l > R || r < L) return;
  if (l >= L && r <= R) {
    st[x] += v;
    laz[x] += v;
    return;
  }
  pushdown(x);
  upd((x << 1), l, ((l + r) >> 1), L, R, v);
  upd(((x << 1) | 1), ((l + r) >> 1) + 1, r, L, R, v);
  pushup(x);
}
signed main() {
  read(n);
  for (long long i = 1; i <= n; i++) read(s[i]);
  build(1, 1, n);
  long long pos;
  for (long long i = 1; i <= n; i++) {
    pos = ps[1];
    a[pos] = i;
    upd(1, 1, n, pos, pos, 0x3f3f3f3f3f3f3fll);
    upd(1, 1, n, pos + 1, n, -i);
  }
  for (long long i = 1; i <= n; i++) printf("%I64d ", a[i]);
  return 0;
}
