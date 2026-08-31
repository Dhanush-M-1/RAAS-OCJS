#include <bits/stdc++.h>
using namespace std;
const int mx = 2e5 + 10;
int fta[mx], ftb[mx];
int cura[mx], curb[mx];
void upd(int i, int v, int ft[]) {
  for (++i; i < mx; i += (i & -i)) ft[i] += v;
}
int qry(int i, int ft[]) {
  int a = 0;
  for (++i; i > 0; i -= (i & -i)) a += ft[i];
  return a;
}
int rng(int l, int r, int ft[]) {
  if (l > r) return 0;
  return qry(r, ft) - qry(l - 1, ft);
}
int main() {
  int n, k, a, b, q, op;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  while (q--) {
    scanf("%d", &op);
    if (op == 1) {
      int di, ai;
      scanf("%d %d", &di, &ai);
      int olda = cura[di], oldb = curb[di];
      cura[di] = min(a, olda + ai);
      curb[di] = min(b, oldb + ai);
      upd(di, cura[di] - olda, fta);
      upd(di, curb[di] - oldb, ftb);
    } else {
      int l;
      scanf("%d", &l);
      int r = l + k - 1;
      int ans = rng(0, l - 1, ftb) + rng(r + 1, n, fta);
      printf("%d\n", ans);
    }
  }
  return 0;
}
