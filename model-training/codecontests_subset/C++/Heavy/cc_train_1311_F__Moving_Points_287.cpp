#include <bits/stdc++.h>
using namespace std;
long long n, m, ans[200005 << 2], tag[200005 << 2], cnt[200005 << 2],
    tagg[200005 << 2];
struct p {
  long long x, v, vv;
} a[200005];
int cmp(p a, p b) { return a.v < b.v; }
int cmpp(p a, p b) { return a.x < b.x; }
inline long long ls(long long x) { return x << 1; }
inline long long rs(long long x) { return x << 1 | 1; }
inline void push_up(long long p) {
  cnt[p] = cnt[ls(p)] + cnt[rs(p)];
  ans[p] = ans[ls(p)] + ans[rs(p)];
}
void build(long long p, long long l, long long r) {
  tag[p] = 0;
  if (l == r) {
    ans[p] = 0;
    return;
  }
  long long mid = (l + r) >> 1;
  build(ls(p), l, mid);
  build(rs(p), mid + 1, r);
  push_up(p);
}
inline void f(long long p, long long l, long long r, long long k) {
  tag[p] = tag[p] + k;
  ans[p] = ans[p] + k * (r - l + 1);
}
inline void push_down(long long p, long long l, long long r) {
  long long mid = (l + r) >> 1;
  f(ls(p), l, mid, tag[p]);
  f(rs(p), mid + 1, r, tag[p]);
  tag[p] = 0;
}
inline void update(long long nl, long long nr, long long l, long long r,
                   long long p, long long k) {
  if (nl <= l && r <= nr) {
    ans[p] += k * (r - l + 1);
    tag[p] += k;
    cnt[p]++;
    return;
  }
  push_down(p, l, r);
  long long mid = (l + r) >> 1;
  if (nl <= mid) update(nl, nr, l, mid, ls(p), k);
  if (nr > mid) update(nl, nr, mid + 1, r, rs(p), k);
  push_up(p);
}
long long query(long long q_x, long long q_y, long long l, long long r,
                long long p) {
  long long res = 0;
  if (q_x <= l && r <= q_y) return ans[p];
  long long mid = (l + r) >> 1;
  push_down(p, l, r);
  if (q_x <= mid) res += query(q_x, q_y, l, mid, ls(p));
  if (q_y > mid) res += query(q_x, q_y, mid + 1, r, rs(p));
  return res;
}
long long query2(long long q_x, long long q_y, long long l, long long r,
                 long long p) {
  long long res = 0;
  if (q_x <= l && r <= q_y) return cnt[p];
  long long mid = (l + r) >> 1;
  push_down(p, l, r);
  if (q_x <= mid) res += query2(q_x, q_y, l, mid, ls(p));
  if (q_y > mid) res += query2(q_x, q_y, mid + 1, r, rs(p));
  return res;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &a[i].x);
  }
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &a[i].v);
  }
  build(1, 1, n);
  sort(a + 1, a + 1 + n, cmp);
  long long tmp = 1;
  a[1].vv = 1;
  for (int i = 2; i <= n; i++) {
    if (a[i].v != a[i - 1].v) tmp++;
    a[i].vv = tmp;
  }
  long long ans = 0;
  sort(a + 1, a + 1 + n, cmpp);
  vector<long long> v;
  for (int i = 1; i <= n; i++) {
    long long tmpp = query(1, a[i].vv, 1, n, 1);
    long long cntt = query2(1, a[i].vv, 1, n, 1);
    ans += a[i].x * cntt - tmpp;
    update(a[i].vv, a[i].vv, 1, n, 1, a[i].x);
  }
  cout << ans;
  return 0;
}
