#include <bits/stdc++.h>
using namespace std;
class op {
 public:
  int t, l, r, d;
  op(){};
};
int main(void) {
  int a[5010];
  int f[5010];
  for (int i = 0; i < (int)(5010); i++) {
    a[i] = 0;
    f[i] = 0;
  }
  int n, m;
  cin >> n >> m;
  op b[5010];
  for (int i = 0; i < (int)(m); i++)
    cin >> b[i].t >> b[i].l >> b[i].r >> b[i].d;
  for (int i = m - 1; i >= 0; i--) {
    if (b[i].t == 1) {
      for (int k = b[i].l; k <= b[i].r; k++) a[k] -= b[i].d;
    } else {
      for (int k = b[i].l; k <= b[i].r; k++) {
        if (!f[k] || a[k] > b[i].d) {
          a[k] = b[i].d;
          f[k] = 1;
        }
      }
    }
  }
  int test[5010];
  for (int i = 0; i < (int)(n + 1); i++) {
    if (!f[i]) a[i] = 0;
    test[i] = a[i];
  }
  for (int i = 0; i < (int)(m); i++) {
    if (b[i].t == 1) {
      for (int k = b[i].l; k <= b[i].r; k++) a[k] += b[i].d;
    } else {
      int ma = -1e9 - 1;
      for (int k = b[i].l; k <= b[i].r; k++) {
        ma = max(ma, a[k]);
      }
      if (ma != b[i].d) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) {
    if (i == 1)
      cout << test[i];
    else
      cout << " " << test[i];
  }
  cout << endl;
  return 0;
}
