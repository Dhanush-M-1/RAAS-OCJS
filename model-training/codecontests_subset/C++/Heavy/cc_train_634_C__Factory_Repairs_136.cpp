#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1);
const int oo = 0x7fffffff;
const int mod = 1000000007;
const int maxn = 1000007;
int a, b;
struct da {
  int l, r;
  int s[3];
  int mid() { return (l + r) / 2; }
  int len() { return (r - l + 1); }
  void Clear() { s[0] = s[1] = s[2] = 0; }
  void add(int num) {
    num = s[2] + num;
    s[0] = min(b, num);
    s[1] = min(a, num);
    s[2] = num;
  }
} tree[maxn << 2];
void build(int l, int r, int rt) {
  tree[rt].l = l;
  tree[rt].r = r;
  tree[rt].Clear();
  if (l == r) return;
  int mid = tree[rt].mid();
  build(l, mid, rt << 1);
  build(mid + 1, r, rt << 1 | 1);
}
void update(int rt, int pos, int val) {
  tree[rt].add(val);
  if (tree[rt].l == tree[rt].r) return;
  if (pos <= tree[rt].mid())
    update(rt << 1, pos, val);
  else
    update(rt << 1 | 1, pos, val);
  tree[rt].s[0] = tree[rt << 1].s[0] + tree[rt << 1 | 1].s[0];
  tree[rt].s[1] = tree[rt << 1].s[1] + tree[rt << 1 | 1].s[1];
  tree[rt].s[2] = tree[rt << 1].s[2] + tree[rt << 1 | 1].s[2];
}
int query(int l, int r, int op, int rt) {
  if (l > r) return 0;
  if (tree[rt].l == l && r == tree[rt].r) {
    return tree[rt].s[op];
  }
  int mid = tree[rt].mid();
  if (r <= mid)
    return query(l, r, op, rt << 1);
  else if (l > mid)
    return query(l, r, op, rt << 1 | 1);
  else {
    return query(l, mid, op, rt << 1) + query(mid + 1, r, op, rt << 1 | 1);
  }
}
int main() {
  int n, k, q, i, op, u, v, ans;
  while (scanf("%d %d %d %d %d", &n, &k, &a, &b, &q) != EOF) {
    build(1, n, 1);
    while (q--) {
      scanf("%d %d", &op, &u);
      if (op == 1) {
        scanf("%d", &v);
        update(1, u, v);
      } else {
        ans = query(1, u - 1, 0, 1) + query(u + k, n, 1, 1);
        printf("%d\n", ans);
      }
    }
  }
  return 0;
}
