#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
struct Query {
  int t;
  int l, r;
  int v;
} q[N];
int x[N];
int main() {
  int n, m;
  int t, l, r, v;
  cin >> n >> m;
  for (int i = 1; i <= m; i++) cin >> q[i].t >> q[i].l >> q[i].r >> q[i].v;
  for (int i = 1; i <= n; i++) x[i] = 1e9;
  for (int i = 1; i <= m; i++) {
    if (q[i].t == 1) {
      for (int j = q[i].l; j <= q[i].r; j++) x[j] += q[i].v;
    } else {
      for (int j = q[i].l; j <= q[i].r; j++)
        if (x[j] >= q[i].v) x[j] = q[i].v;
    }
  }
  bool ok = true;
  for (int i = m; i >= 1; i--) {
    if (q[i].t == 1) {
      for (int j = q[i].l; j <= q[i].r; j++) x[j] -= q[i].v;
    } else {
      int mx = -1e9;
      for (int j = q[i].l; j <= q[i].r; j++) mx = max(mx, x[j]);
      if (mx != q[i].v) {
        ok = false;
        break;
      }
    }
  }
  if (!ok)
    puts("NO");
  else {
    puts("YES");
    for (int i = 1; i <= n; i++) cout << x[i] << (i == n ? '\n' : ' ');
  }
}
