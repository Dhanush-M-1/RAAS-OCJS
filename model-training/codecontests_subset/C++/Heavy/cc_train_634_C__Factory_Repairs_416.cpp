#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200000;
long long t[3][4 * MAXN + 1];
int a, b;
void upd(int num, int pos, int delta, int v = 1, int l = 1, int r = MAXN) {
  if (l == r) {
    if (num == 1 && t[num][v] + delta >= b)
      t[num][v] = b;
    else if (num == 1)
      t[num][v] += delta;
    if (num == 2 && t[num][v] + delta >= a)
      t[num][v] = a;
    else if (num == 2)
      t[num][v] += delta;
  } else {
    int m = (l + r) / 2;
    if (pos <= m)
      upd(num, pos, delta, v * 2, l, m);
    else
      upd(num, pos, delta, v * 2 + 1, m + 1, r);
    t[num][v] = t[num][v * 2] + t[num][v * 2 + 1];
  }
}
long long get(int num, int l, int r, int tv = 1, int tl = 1, int tr = MAXN) {
  if (l > r)
    return 0;
  else if (l == tl && r == tr)
    return t[num][tv];
  else {
    int tm = (tl + tr) / 2;
    return get(num, l, min(tm, r), tv * 2, tl, tm) +
           get(num, max(tm + 1, l), r, tv * 2 + 1, tm + 1, tr);
  }
}
int main() {
  int n, k, q;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      int d, a;
      scanf("%d%d", &d, &a);
      upd(1, d, a);
      upd(2, d, a);
    } else {
      int p;
      scanf("%d", &p);
      long long ans = 0;
      ans += get(1, 1, p - 1);
      ans += get(2, p + k, n);
      cout << ans << endl;
    }
  }
  return 0;
}
