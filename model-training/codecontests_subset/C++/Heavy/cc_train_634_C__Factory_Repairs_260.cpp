#include <bits/stdc++.h>
using namespace std;
const int mxval = 200000;
long long int oka[200000 + 11], wa[200000 + 11];
void update(long long int *BIT, int idx, int val) {
  while (idx <= mxval) BIT[idx] += val, idx += idx & -idx;
}
long long int query(long long int *BIT, int idx) {
  long long int ret = 0;
  while (idx) ret += BIT[idx], idx -= idx & -idx;
  return ret;
}
long long int order[200000 + 11];
int main() {
  int i, j, n, k, a, b, q;
  int tp, di, vi, st;
  scanf("%d %d %d", &n, &k, &a);
  scanf("%d %d", &b, &q);
  long long int res;
  while (q--) {
    scanf("%d", &tp);
    if (tp == 1) {
      scanf("%d %d", &di, &vi);
      order[di] += vi;
      update(oka, di, -(query(oka, di) - query(oka, di - 1)));
      update(wa, di, -(query(wa, di) - query(wa, di - 1)));
      update(oka, di, min(order[di], (long long int)a));
      update(wa, di, min(order[di], (long long int)b));
    } else {
      scanf("%d", &st);
      res = query(wa, st - 1);
      res += query(oka, mxval) - query(oka, st + k - 1);
      printf("%I64d\n", res);
    }
  }
  return 0;
}
