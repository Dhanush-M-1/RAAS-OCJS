#include <bits/stdc++.h>
using namespace std;
int n, k, a, b, q;
int d1[900000], d2[900000], arr[900000];
int sum(int v, int l, int r, int tl, int tr, int d[]) {
  if (l == tl && r == tr) return d[v];
  if (tl > tr) return 0;
  int m = (l + r) / 2;
  return sum(v * 2, l, m, tl, min(tr, m), d) +
         sum(v * 2 + 1, m + 1, r, max(tl, m + 1), tr, d);
}
void upd(int v, int l, int r, int x, int nw, int d[]) {
  if (l == r) {
    d[v] = nw;
  } else {
    int m = (l + r) / 2;
    if (m >= x)
      upd(v * 2, l, m, x, nw, d);
    else
      upd(v * 2 + 1, m + 1, r, x, nw, d);
    d[v] = d[v * 2] + d[v * 2 + 1];
  }
}
int main() {
  cin >> n >> k >> a >> b >> q;
  for (int i = 1; i <= q; i++) {
    int x, l, r;
    cin >> x;
    if (x == 1) {
      cin >> l >> r;
      arr[l] += r;
      upd(1, 1, n, l, min(arr[l], a), d1);
      upd(1, 1, n, l, min(arr[l], b), d2);
    } else {
      int ans = 0;
      cin >> l;
      if (l != 1) ans += sum(1, 1, n, 1, l - 1, d2);
      if (l + k != n + 1) ans += sum(1, 1, n, l + k, n, d1);
      cout << ans << endl;
    }
  }
  return 0;
}
