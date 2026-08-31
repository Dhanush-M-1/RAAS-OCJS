#include <bits/stdc++.h>
const int maxn = 200100;
using namespace std;
struct node {
  int l, r;
  int num1, num2;
} tree[maxn << 2];
int n, k, a, b, q;
void build(int l, int r, int cur) {
  tree[cur].l = l;
  tree[cur].r = r;
  tree[cur].num1 = tree[cur].num2 = 0;
  if (l == r) return;
  int mid = (r + l) >> 1;
  build(l, mid, cur << 1);
  build(mid + 1, r, cur << 1 | 1);
}
void update(int tar, int cur, int val) {
  if (tree[cur].l == tree[cur].r) {
    tree[cur].num1 = min(tree[cur].num1 + val, a);
    tree[cur].num2 = min(tree[cur].num2 + val, b);
    return;
  }
  if (tar <= tree[cur * 2].r)
    update(tar, cur * 2, val);
  else
    update(tar, cur * 2 + 1, val);
  tree[cur].num1 = tree[cur * 2].num1 + tree[cur * 2 + 1].num1;
  tree[cur].num2 = tree[cur * 2].num2 + tree[cur * 2 + 1].num2;
}
int query(int pl, int pr, int cur, int fg) {
  if (pl <= tree[cur].l && tree[cur].r <= pr) {
    if (fg)
      return tree[cur].num1;
    else
      return tree[cur].num2;
  }
  int res = 0;
  if (pl <= tree[cur * 2].r) res += query(pl, pr, cur * 2, fg);
  if (pr >= tree[cur * 2 + 1].l) res += query(pl, pr, cur * 2 + 1, fg);
  return res;
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  build(1, n, 1);
  while (q--) {
    int op, x, y;
    scanf("%d", &op);
    if (op == 1) {
      scanf("%d%d", &x, &y);
      update(x, 1, y);
    } else {
      scanf("%d", &x);
      if (x > 1 && x + k <= n)
        printf("%d\n", query(1, x - 1, 1, 0) + query(x + k, n, 1, 1));
      else if (x + k <= n)
        printf("%d\n", query(x + k, n, 1, 1));
      else if (x > 1)
        printf("%d\n", query(1, x - 1, 1, 0));
      else
        printf("0\n");
    }
  }
  return 0;
}
