#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 111;
int n, k, a[2], q;
int t[2][4 * MAXN];
long long query(int id, int v, int l, int r, int ql, int qr) {
  if (l >= qr || ql >= r) return 0;
  if (ql <= l && qr >= r) return t[id][v];
  int mid = (l + r) / 2;
  long long left = query(id, 2 * v + 1, l, mid, ql, qr);
  long long right = query(id, 2 * v + 2, mid, r, ql, qr);
  return left + right;
}
void update(int id, int v, int l, int r, int d, int val) {
  if (d < l || d >= r) return;
  if (l == r - 1) {
    t[id][v] = min(a[id], t[id][v] + val);
    return;
  }
  int mid = (l + r) / 2;
  update(id, 2 * v + 1, l, mid, d, val);
  update(id, 2 * v + 2, mid, r, d, val);
  t[id][v] = t[id][2 * v + 1] + t[id][2 * v + 2];
}
int main() {
  scanf("%d %d %d %d %d", &n, &k, &a[1], &a[0], &q);
  for (int i = 0; i < q; i++) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int d, a;
      scanf("%d %d", &d, &a);
      update(0, 0, 0, n, d - 1, a);
      update(1, 0, 0, n, d - 1, a);
    } else {
      int d;
      scanf("%d", &d);
      printf("%d\n",
             query(0, 0, 0, n, 0, d - 1) + query(1, 0, 0, n, d - 1 + k, n));
    }
  }
  return 0;
}
