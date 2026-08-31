#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
const long long inf = 1e14;
int n;
long long a[maxn], ans[maxn];
struct SegmentTree {
  long long tr[maxn << 2], tag[maxn << 2];
  void pushup(int rt) { tr[rt] = min(tr[rt << 1], tr[rt << 1 | 1]); }
  void build(int rt, int l, int r) {
    tag[rt] = 0;
    if (l == r) {
      tr[rt] = a[l];
      return;
    }
    int mid = (l + r) >> 1;
    build(rt << 1, l, mid);
    build(rt << 1 | 1, mid + 1, r);
    pushup(rt);
  }
  void load(int rt, long long k) {
    tr[rt] += k;
    tag[rt] += k;
  }
  void pushdown(int rt) {
    load(rt << 1, tag[rt]);
    load(rt << 1 | 1, tag[rt]);
    tag[rt] = 0;
  }
  void update(int nl, int nr, int l, int r, int rt, long long k) {
    if (nl > nr) return;
    if (nl <= l && nr >= r) {
      load(rt, k);
      return;
    }
    int mid = (l + r) >> 1;
    pushdown(rt);
    if (nl <= mid) update(nl, nr, l, mid, rt << 1, k);
    if (nr >= mid + 1) update(nl, nr, mid + 1, r, rt << 1 | 1, k);
    pushup(rt);
  }
} seg2;
int pos;
void get_pos2(int rt, int l, int r) {
  if (l == r) {
    pos = l;
    return;
  }
  seg2.pushdown(rt);
  int mid = (l + r) >> 1;
  if (seg2.tr[rt << 1 | 1] <= 0)
    get_pos2(rt << 1 | 1, mid + 1, r);
  else
    get_pos2(rt << 1, l, mid);
  seg2.pushup(rt);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%lld", a + i);
  seg2.build(1, 1, n);
  for (int x = 1; x <= n; x++) {
    get_pos2(1, 1, n);
    ans[pos] = x;
    seg2.update(pos, pos, 1, n, 1, inf);
    seg2.update(pos + 1, n, 1, n, 1, -x);
  }
  for (int i = 1; i <= n; i++) printf("%lld ", ans[i]);
  return 0;
}
