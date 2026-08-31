#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, q;
const int mxn = (2 * (1e5)) + 20;
int st[mxn * 4];
int st1[mxn * 4];
void change(int p, int l, int r, int i, int xx) {
  if (r < i || l > i) return;
  if (l == r)
    st[p] = min(st[p] + xx, b);
  else {
    int m = (l + r) / 2;
    change(p * 2, l, m, i, xx);
    change(p * 2 + 1, m + 1, r, i, xx);
    st[p] = st[p * 2] + st[p * 2 + 1];
  }
}
int sum(int p, int l, int r, int i, int j) {
  if (r < i || l > j) return 0;
  if (l >= i && r <= j) return st[p];
  int m = (l + r) / 2;
  return sum(p * 2, l, m, i, j) + sum(p * 2 + 1, m + 1, r, i, j);
}
void change1(int p, int l, int r, int i, int xx) {
  if (r < i || l > i) return;
  if (l == r)
    st1[p] = min(st1[p] + xx, a);
  else {
    int m = (l + r) / 2;
    change1(p * 2, l, m, i, xx);
    change1(p * 2 + 1, m + 1, r, i, xx);
    st1[p] = st1[p * 2] + st1[p * 2 + 1];
  }
}
int sum1(int p, int l, int r, int i, int j) {
  if (r < i || l > j) return 0;
  if (l >= i && r <= j) return st1[p];
  int m = (l + r) / 2;
  return sum1(p * 2, l, m, i, j) + sum1(p * 2 + 1, m + 1, r, i, j);
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  for (int i = 0; i < q; ++i) {
    int t, d, x;
    scanf("%d", &t);
    if (t == 1) {
      scanf("%d%d", &d, &x);
      change(1, 0, n, d, x);
      change1(1, 0, n, d, x);
    } else {
      scanf("%d", &x);
      int p1 = sum(1, 0, n, 0, x - 1);
      int p2 = sum1(1, 0, n, (x + k), n);
      printf("%d\n", p1 + p2);
    }
  }
  return 0;
}
