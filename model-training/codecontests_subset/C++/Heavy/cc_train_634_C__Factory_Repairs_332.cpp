#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
struct node {
  int l, r, flag;
  long long num[4];
} tree[201000 * 4];
long long a, b;
void Build(int rt, int l, int r) {
  tree[rt].l = l, tree[rt].r = r;
  for (int i = 0; i < 3; i++) tree[rt].num[i] = 0;
  if (l == r) return;
  int mid = (l + r) / 2;
  Build(rt << 1, l, mid);
  Build(rt << 1 | 1, mid + 1, r);
}
void UP(int rt) {
  for (int i = 0; i < 3; i++)
    tree[rt].num[i] = tree[rt << 1].num[i] + tree[rt << 1 | 1].num[i];
}
void Update(int rt, int k, long long e) {
  if (tree[rt].l == tree[rt].r) {
    tree[rt].num[0] = min(tree[rt].num[0] + e, b);
    tree[rt].num[1] = min(tree[rt].num[1] + e, a);
    return;
  }
  int mid = (tree[rt].l + tree[rt].r) / 2;
  if (k <= mid)
    Update(rt << 1, k, e);
  else
    Update(rt << 1 | 1, k, e);
  UP(rt);
}
long long Query(int rt, int l, int r, long long e) {
  if (l > r) return 0;
  if (tree[rt].l == l && tree[rt].r == r) return tree[rt].num[e];
  int mid = (tree[rt].l + tree[rt].r) / 2;
  if (r <= mid)
    return Query(rt << 1, l, r, e);
  else if (l > mid)
    return Query(rt << 1 | 1, l, r, e);
  else
    return Query(rt << 1, l, mid, e) + Query(rt << 1 | 1, mid + 1, r, e);
}
int main() {
  int n, k, q;
  while (scanf("%d %d %I64d %I64d %d", &n, &k, &a, &b, &q) != EOF) {
    Build(1, 1, n);
    while (q--) {
      long long x, y, z, ans1, ans2;
      scanf("%I64d", &x);
      if (x == 1) {
        scanf("%I64d %I64d", &y, &z);
        Update(1, y, z);
      } else {
        scanf("%I64d", &y);
        ans1 = Query(1, 1, y - 1, 0);
        ans2 = Query(1, y + k, n, 1);
        printf("%I64d\n", ans1 + ans2);
      }
    }
  }
  return 0;
}
