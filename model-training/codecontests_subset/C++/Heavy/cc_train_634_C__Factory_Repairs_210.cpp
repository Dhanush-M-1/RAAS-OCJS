#include <bits/stdc++.h>
using namespace std;
int t1[1000000];
int t2[1000000];
int a, b;
void update1(int v, int tl, int tr, int pos, int val) {
  if (tl == tr) {
    t1[v] += val;
    t1[v] = min(t1[v], a);
  } else {
    int m = (tl + tr) / 2;
    if (pos <= m)
      update1(v * 2, tl, m, pos, val);
    else
      update1(v * 2 + 1, m + 1, tr, pos, val);
    t1[v] = t1[v * 2] + t1[v * 2 + 1];
  }
}
int get1(int v, int tl, int tr, int l, int r) {
  if (l > r) return 0;
  if (l == tl && r == tr) return t1[v];
  int m = (tl + tr) / 2;
  return get1(v * 2, tl, m, l, min(m, r)) +
         get1(v * 2 + 1, m + 1, tr, max(m + 1, l), r);
}
int get2(int v, int tl, int tr, int l, int r) {
  if (l > r) return 0;
  if (tl == l && r == tr) return t2[v];
  int m = (tl + tr) / 2;
  return get2(v * 2, tl, m, l, min(m, r)) +
         get2(v * 2 + 1, m + 1, tr, max(m + 1, l), r);
}
void update2(int v, int tl, int tr, int pos, int val) {
  if (tl == tr) {
    t2[v] += val;
    t2[v] = min(t2[v], b);
  } else {
    int m = (tl + tr) / 2;
    if (pos <= m)
      update2(v * 2, tl, m, pos, val);
    else
      update2(v * 2 + 1, m + 1, tr, pos, val);
    t2[v] = t2[v * 2] + t2[v * 2 + 1];
  }
}
int main() {
  cin.sync_with_stdio(false);
  cin.tie(0);
  int n, k, q;
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  for (int i = 0; i < 4 * n; i++) {
    t1[i] = 0;
    t2[i] = 0;
  }
  for (int i = 0; i < q; i++) {
    int x;
    scanf("%d", &x);
    if (x == 1) {
      int x1, x2;
      scanf("%d %d", &x1, &x2);
      x1--;
      update1(1, 0, n - 1, x1, x2);
      update2(1, 0, n - 1, x1, x2);
    } else {
      int x1;
      scanf("%d", &x1);
      x1--;
      int ans = 0;
      ans = get2(1, 0, n - 1, 0, x1 - 1);
      ans += get1(1, 0, n - 1, x1 + k, n - 1);
      printf("%d\n", ans);
    }
  }
  return 0;
}
