#include <bits/stdc++.h>
using namespace std;
double eps = 1e-9;
const int INF = 1e9 + 7;
const int MAXN = int(2e5 + 7);
int n, a, b, k, q, t[5 * MAXN], t2[5 * MAXN];
int sum1(int v, int tl, int tr, int l, int r) {
  if (l > r) return 0;
  if (l == tl && r == tr) return t[v];
  int tm = (tl + tr) / 2;
  return sum1(v * 2, tl, tm, l, min(r, tm)) +
         sum1(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r);
}
int sum2(int v, int tl, int tr, int l, int r) {
  if (l > r) return 0;
  if (l == tl && r == tr) return t2[v];
  int tm = (tl + tr) / 2;
  return sum2(v * 2, tl, tm, l, min(r, tm)) +
         sum2(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r);
}
void update1(int v, int tl, int tr, int pos, int new_val) {
  if (tl == tr)
    t[v] = min(a, t[v] + new_val);
  else {
    int tm = (tl + tr) / 2;
    if (pos <= tm)
      update1(v * 2, tl, tm, pos, new_val);
    else
      update1(v * 2 + 1, tm + 1, tr, pos, new_val);
    t[v] = t[v * 2] + t[v * 2 + 1];
  }
}
void update2(int v, int tl, int tr, int pos, int new_val) {
  if (tl == tr)
    t2[v] = min(b, t2[v] + new_val);
  else {
    int tm = (tl + tr) / 2;
    if (pos <= tm)
      update2(v * 2, tl, tm, pos, new_val);
    else
      update2(v * 2 + 1, tm + 1, tr, pos, new_val);
    t2[v] = t2[v * 2] + t2[v * 2 + 1];
  }
}
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  for (int i = 0, ty, d, a, p; i < q; i++) {
    scanf("%d", &ty);
    if (ty == 1) {
      scanf("%d%d", &d, &a);
      update1(1, 1, n, d, a);
      update2(1, 1, n, d, a);
    } else {
      scanf("%d", &p);
      long long res = 0;
      if (p != 1) res += sum2(1, 1, n, 1, p - 1);
      res += sum1(1, 1, n, p + k, n);
      printf("%I64d\n", res);
    }
  }
  return 0;
}
