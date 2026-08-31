#include <bits/stdc++.h>
const int MAXQ = 262144;
long long tree[MAXQ * 2 + 10];
long long btree[MAXQ * 2 + 10];
void tree_change(int v, int val, int l, int r, int pos, int limit) {
  if (l == r) {
    tree[v] = ((limit) < (tree[v] + val) ? (limit) : (tree[v] + val));
    return;
  }
  int tm = (l + r) >> 1;
  int lchild = (v << 1) + 1;
  if (pos <= tm)
    tree_change(lchild, val, l, tm, pos, limit);
  else
    tree_change(lchild + 1, val, tm + 1, r, pos, limit);
  tree[v] = tree[lchild] + tree[lchild + 1];
}
long long tree_sum(int v, int cl, int cr, int l, int r) {
  if (l > r) return 0;
  if (cl == l && cr == r) return tree[v];
  int tm = (cl + cr) >> 1;
  int lchild = (v << 1) + 1;
  return tree_sum(lchild, cl, tm, l, ((r) < (tm) ? (r) : (tm))) +
         tree_sum(lchild + 1, tm + 1, cr, ((l) > (tm + 1) ? (l) : (tm + 1)), r);
}
void btree_change(int v, int val, int l, int r, int pos, int limit) {
  if (l == r) {
    btree[v] = ((limit) < (btree[v] + val) ? (limit) : (btree[v] + val));
    return;
  }
  int tm = (l + r) >> 1;
  int lchild = (v << 1) + 1;
  if (pos <= tm)
    btree_change(lchild, val, l, tm, pos, limit);
  else
    btree_change(lchild + 1, val, tm + 1, r, pos, limit);
  btree[v] = btree[lchild] + btree[lchild + 1];
}
long long btree_sum(int v, int cl, int cr, int l, int r) {
  if (l > r) return 0;
  if (cl == l && cr == r) return btree[v];
  int tm = (cl + cr) >> 1;
  int lchild = (v << 1) + 1;
  return btree_sum(lchild, cl, tm, l, ((r) < (tm) ? (r) : (tm))) +
         btree_sum(lchild + 1, tm + 1, cr, ((l) > (tm + 1) ? (l) : (tm + 1)),
                   r);
}
int main() {
  int n, k, a, b, q, qtype, di, ai, pi;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  for (int i = 0; i <= (2 * MAXQ + 2); i++) tree[i] = 0;
  for (int i = 0; i < q; i++) {
    scanf("%d", &qtype);
    if (qtype == 1) {
      scanf("%d %d", &di, &ai);
      tree_change(0, ai, 0, n - 1, di - 1, a);
      btree_change(0, ai, 0, n - 1, di - 1, b);
    } else {
      scanf("%d", &pi);
      pi--;
      long long bs = btree_sum(0, 0, n - 1, 0, pi - 1);
      printf("%I64d\n", bs + tree_sum(0, 0, n - 1, pi + k, n - 1));
    }
  }
  return 0;
}
