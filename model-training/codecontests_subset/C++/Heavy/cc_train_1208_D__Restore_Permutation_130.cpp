#include <bits/stdc++.h>
using namespace std;
const long long inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3f;
const long long mod = 1e9 + 7;
long long tree[200050 << 2], lazy[200050 << 2], a[200050];
void pushup(long long rt) { tree[rt] = min(tree[rt << 1], tree[rt << 1 | 1]); }
void pushdown(long long rt) {
  if (lazy[rt]) {
    lazy[rt << 1] += lazy[rt];
    lazy[rt << 1 | 1] += lazy[rt];
    tree[rt << 1] -= lazy[rt];
    tree[rt << 1 | 1] -= lazy[rt];
    lazy[rt] = 0;
  }
}
void build(long long l, long long r, long long rt) {
  if (l == r) {
    tree[rt] = a[l];
    return;
  }
  long long mid = (l + r) / 2;
  build(l, mid, rt * 2);
  build(mid + 1, r, rt * 2 + 1);
  pushup(rt);
}
void update_id(long long pos, long long l, long long r, long long rt) {
  if (l == r) {
    tree[rt] = INF;
    return;
  }
  pushdown(rt);
  long long mid = (l + r) / 2;
  if (pos <= mid)
    update_id(pos, l, mid, rt * 2);
  else
    update_id(pos, mid + 1, r, rt * 2 + 1);
  pushup(rt);
}
void update_range(long long L, long long R, long long w, long long l,
                  long long r, long long rt) {
  if (L <= l && r <= R) {
    tree[rt] -= w;
    lazy[rt] += w;
    return;
  }
  pushdown(rt);
  long long mid = (l + r) / 2;
  if (L <= mid) update_range(L, R, w, l, mid, rt * 2);
  if (R > mid) update_range(L, R, w, mid + 1, r, rt * 2 + 1);
  pushup(rt);
}
long long query(long long l, long long r, long long rt) {
  if (l == r) {
    return l;
  }
  pushdown(rt);
  long long mid = (l + r) / 2;
  if (tree[rt << 1 | 1] == 0)
    return query(mid + 1, r, rt * 2 + 1);
  else
    return query(l, mid, rt * 2);
}
long long ans[200050];
int main() {
  long long n;
  scanf("%lld", &n);
  for (long long i = 1; i <= n; i++) scanf("%lld", &a[i]);
  build(1, n, 1);
  for (long long i = 1; i <= n; i++) {
    int pos = query(1, n, 1);
    ans[pos] = i;
    update_id(pos, 1, n, 1);
    update_range(pos, n, i, 1, n, 1);
  }
  for (long long i = 1; i <= n; i++) cout << ans[i] << ' ';
  cout << endl;
  return 0;
}
