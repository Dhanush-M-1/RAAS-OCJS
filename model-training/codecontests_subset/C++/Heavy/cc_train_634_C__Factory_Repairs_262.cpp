#include <bits/stdc++.h>
using namespace std;
const int MAX = 2e5 + 5;
int n, k, a, b, q;
struct stree {
  int tree[4 * MAX];
  void update(int x, int st, int nd, int p, int v, int l) {
    if (st > p || nd < p) return;
    if (st == nd) {
      tree[x] = min(tree[x] + v, l);
      return;
    }
    int mid = (st + nd) >> 1, I = x << 1, D = I + 1;
    update(I, st, mid, p, v, l);
    update(D, mid + 1, nd, p, v, l);
    tree[x] = tree[I] + tree[D];
  }
  int query(int x, int st, int nd, int a, int b) {
    if (a > b || st > b || nd < a) return 0;
    if (st >= a && nd <= b) return tree[x];
    int mid = (st + nd) >> 1, I = x << 1, D = I + 1;
    return query(I, st, mid, a, b) + query(D, mid + 1, nd, a, b);
  }
} t1, t2;
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  while (q--) {
    int op;
    scanf("%d", &op);
    if (op == 1) {
      int d, c;
      scanf("%d%d", &d, &c);
      t1.update(1, 1, n, d, c, b);
      t2.update(1, 1, n, d, c, a);
      continue;
    }
    int d;
    scanf("%d", &d);
    int q = t1.query(1, 1, n, 1, d - 1) + t2.query(1, 1, n, d + k, n);
    printf("%d\n", q);
  }
  return 0;
}
