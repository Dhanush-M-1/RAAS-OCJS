#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
const long long INF = 1e18;
int n;
long long a[maxn], ans[maxn];
long long tree[maxn << 2], laz[maxn << 2];
void pushup(int rt) { tree[rt] = min(tree[rt << 1], tree[(rt << 1) | 1]); }
void build(int l, int r, int rt) {
  if (l == r) {
    tree[rt] = a[l];
    return;
  }
  build(l, ((l + r) >> 1), 2 * rt);
  build(((l + r) >> 1) + 1, r, 2 * rt + 1);
  pushup(rt);
}
void change(int x, int l, int r, int rt) {
  if (l == r) {
    tree[rt] = INF;
    return;
  }
  if (x <= ((l + r) >> 1))
    change(x, l, ((l + r) >> 1), 2 * rt);
  else
    change(x, ((l + r) >> 1) + 1, r, 2 * rt + 1);
  pushup(rt);
}
void pushdown(int rt) {
  long long& x = laz[rt];
  if (x) {
    tree[rt << 1] += x;
    tree[(rt << 1) | 1] += x;
    laz[rt << 1] += x;
    laz[(rt << 1) | 1] += x;
    x = 0;
  }
}
void update(int x, int ql, int qr, int l, int r, int rt) {
  if (ql == l && qr == r) {
    laz[rt] += x;
    tree[rt] += x;
    return;
  }
  pushdown(rt);
  if (qr <= ((l + r) >> 1))
    update(x, ql, qr, l, ((l + r) >> 1), 2 * rt);
  else if (ql > ((l + r) >> 1))
    update(x, ql, qr, ((l + r) >> 1) + 1, r, 2 * rt + 1);
  else {
    update(x, ql, ((l + r) >> 1), l, ((l + r) >> 1), 2 * rt);
    update(x, ((l + r) >> 1) + 1, qr, ((l + r) >> 1) + 1, r, 2 * rt + 1);
  }
  pushup(rt);
}
int query(int l, int r, int rt) {
  if (l == r) return l;
  pushdown(rt);
  if (tree[((l + r) >> 1) + 1, r, 2 * rt + 1] == 0)
    return query(((l + r) >> 1) + 1, r, 2 * rt + 1);
  else
    return query(l, ((l + r) >> 1), 2 * rt);
}
int main() {
  cin.sync_with_stdio(false);
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
  }
  build(1, n, 1);
  int t;
  for (int i = 1; i <= n; i++) {
    t = query(1, n, 1);
    ans[t] = i;
    change(t, 1, n, 1);
    if (t != n) update(-i, t + 1, n, 1, n, 1);
  }
  for (int i = 1; i <= n; i++) cout << ans[i] << ' ';
  return 0;
}
