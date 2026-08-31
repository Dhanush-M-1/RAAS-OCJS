#include <bits/stdc++.h>
using namespace std;
int sTree[2][4 * 200005], nums[200005], kaka[2], n, k, q, x, y, z;
void update(int ind, int c, int b, int e, int i) {
  if (i < b || i > e)
    return;
  else if (b == e)
    sTree[ind][c] = ((nums[b]) < (kaka[ind]) ? (nums[b]) : (kaka[ind]));
  else if (b != e) {
    int m = b + (e - b) / 2;
    update(ind, 2 * c, b, m, i);
    update(ind, 2 * c + 1, m + 1, e, i);
    sTree[ind][c] = sTree[ind][2 * c] + sTree[ind][2 * c + 1];
  }
}
void update(int ind, int i) { update(ind, 1, 1, n, i); }
int query(int ind, int c, int b, int e, int qb, int qe) {
  if (qb <= b && qe >= e)
    return sTree[ind][c];
  else if (qe < b || qb > e)
    return 0;
  else {
    int m = b + (e - b) / 2;
    if (m > qe) return query(ind, 2 * c, b, m, qb, qe);
    if (m < qb) return query(ind, 2 * c + 1, m + 1, e, qb, qe);
    return query(ind, 2 * c, b, m, qb, qe) +
           query(ind, 2 * c + 1, m + 1, e, qb, qe);
  }
}
int query(int ind, int b, int e) { return query(ind, 1, 1, n, b, e); }
int main() {
  scanf("%d%d%d%d%d", &n, &k, &kaka[0], &kaka[1], &q);
  for (int i = 0; i < q; ++i) {
    scanf("%d", &x);
    if (x == 1) {
      scanf("%d%d", &y, &z);
      nums[y] += z;
      update(0, y);
      update(1, y);
    } else {
      scanf("%d", &y);
      int ans = 0;
      if (y > 1) ans += query(1, 1, y - 1);
      if (n >= y + k) ans += query(0, y + k, n);
      printf("%d\n", ans);
    }
  }
}
