#include <bits/stdc++.h>
using namespace std;
long long tree[2][3 * 200007], a, b;
void upd(long long n, long long l, long long r, long long i, long long v) {
  if (l == r && l == i) {
    tree[0][n] = min(b, tree[0][n] + v);
    tree[1][n] = min(a, tree[1][n] + v);
    return;
  }
  if (i < l || i > r) return;
  upd(2 * n, l, ((l + r) / 2), i, v);
  upd(2 * n + 1, ((l + r) / 2) + 1, r, i, v);
  tree[0][n] = tree[0][2 * n] + tree[0][2 * n + 1];
  tree[1][n] = tree[1][2 * n] + tree[1][2 * n + 1];
}
long long qry(long long t, long long n, long long l, long long r, long long i,
              long long j) {
  if (l > j || r < i) return 0;
  if (l >= i && r <= j) return tree[t][n];
  return (qry(t, 2 * n, l, ((l + r) / 2), i, j) +
          qry(t, 2 * n + 1, ((l + r) / 2) + 1, r, i, j));
}
int main() {
  memset(tree, 0, sizeof(tree));
  long long n, k, q;
  scanf("%lld %lld", &n, &k);
  scanf("%lld %lld", &a, &b);
  scanf("%lld", &q);
  while (q--) {
    long long op;
    scanf("%lld", &op);
    if (op == 1) {
      long long d, v;
      scanf("%lld %lld", &d, &v);
      upd(1, 1, n, d, v);
    } else {
      long long p;
      scanf("%lld", &p);
      long long ans = qry(0, 1, 1, n, 1, p - 1) + qry(1, 1, 1, n, p + k, n);
      printf("%lld\n", ans);
    }
  }
}
