#include <bits/stdc++.h>
using namespace std;
int n, ta[800000] = {0}, tb[800000] = {0};
int suma(int v, int tl, int tr, int l, int r) {
  if (l > r) return 0;
  if (l == tl && r == tr) return ta[v];
  int tm = (tl + tr) / 2;
  return suma(v * 2, tl, tm, l, min(r, tm)) +
         suma(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r);
}
void updatea(int v, int tl, int tr, int pos, int new_val) {
  if (tl == tr)
    ta[v] = new_val;
  else {
    int tm = (tl + tr) / 2;
    if (pos <= tm)
      updatea(v * 2, tl, tm, pos, new_val);
    else
      updatea(v * 2 + 1, tm + 1, tr, pos, new_val);
    ta[v] = ta[v * 2] + ta[v * 2 + 1];
  }
}
int sumb(int v, int tl, int tr, int l, int r) {
  if (l > r) return 0;
  if (l == tl && r == tr) return tb[v];
  int tm = (tl + tr) / 2;
  return sumb(v * 2, tl, tm, l, min(r, tm)) +
         sumb(v * 2 + 1, tm + 1, tr, max(l, tm + 1), r);
}
void updateb(int v, int tl, int tr, int pos, int new_val) {
  if (tl == tr)
    tb[v] = new_val;
  else {
    int tm = (tl + tr) / 2;
    if (pos <= tm)
      updateb(v * 2, tl, tm, pos, new_val);
    else
      updateb(v * 2 + 1, tm + 1, tr, pos, new_val);
    tb[v] = tb[v * 2] + tb[v * 2 + 1];
  }
}
int mass[10000000] = {0};
int main() {
  int k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int t;
    cin >> t;
    if (t == 1) {
      int d, add;
      cin >> d >> add;
      d--;
      mass[d] += add;
      updatea(1, 0, n - 1, d, min(mass[d], a));
      updateb(1, 0, n - 1, d, min(mass[d], b));
    } else {
      int p = 0;
      cin >> p;
      p--;
      cout << sumb(1, 0, n - 1, 0, p - 1) +
                  (p + k < n ? suma(1, 0, n - 1, p + k, n - 1) : 0)
           << endl;
    }
  }
  return 0;
}
