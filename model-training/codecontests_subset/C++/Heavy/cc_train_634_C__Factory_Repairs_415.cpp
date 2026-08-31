#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, q;
struct Tree {
  int l, r, len, sum[2];
};
Tree tree[1000010 << 2];
void build(int le, int ri, int rt) {
  tree[rt].l = le, tree[rt].r = ri, tree[rt].len = ri - le + 1;
  tree[rt].sum[0] = 0;
  tree[rt].sum[1] = 0;
  if (ri == le)
    return;
  else {
    int m = (le + ri) >> 1;
    build(le, m, rt << 1);
    build(m + 1, ri, rt << 1 | 1);
  }
}
void update(int rt, int fd, int fa) {
  if (tree[rt].l == tree[rt].r && fd == tree[rt].l) {
    if (fa + tree[rt].sum[0] >= a)
      tree[rt].sum[0] = a;
    else
      tree[rt].sum[0] += fa;
    if (fa + tree[rt].sum[1] >= b)
      tree[rt].sum[1] = b;
    else
      tree[rt].sum[1] += fa;
    return;
  }
  int m = (tree[rt].l + tree[rt].r) >> 1;
  if (fd <= m)
    update(rt * 2, fd, fa);
  else
    update(rt * 2 + 1, fd, fa);
  for (int i = 0; i < 2; i++)
    tree[rt].sum[i] = tree[rt * 2].sum[i] + tree[rt * 2 + 1].sum[i];
}
int query(int L, int R, int le, int ri, int rt, int f) {
  if (L > R) return 0;
  if (L <= le && R >= ri) return tree[rt].sum[f];
  int m = (le + ri) >> 1;
  int res = 0;
  if (L <= m) res += query(L, R, le, m, rt << 1, f);
  if (R > m) res += query(L, R, m + 1, ri, rt << 1 | 1, f);
  return res;
}
int main() {
  int flag, na, d, p;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  build(1, n, 1);
  for (int i = 0; i < q; i++) {
    scanf("%d", &flag);
    if (flag == 1) {
      scanf("%d %d", &d, &na);
      update(1, d, na);
    } else {
      scanf("%d", &p);
      printf("%d\n", query(1, p - 1, 1, n, 1, 1) + query(p + k, n, 1, n, 1, 0));
    }
  }
  return 0;
}
