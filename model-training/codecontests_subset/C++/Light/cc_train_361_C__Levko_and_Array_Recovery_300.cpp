#include <bits/stdc++.h>
using namespace std;
struct dv {
  int lenh, l, r, x, stt;
};
int n, k, m;
int comp(dv l, dv r) { return l.l < r.l; }
int dd[5555], so[5555], save[5555], vt[5555], change[5555];
vector<dv> a, b;
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    dd[i] = 0;
    so[i] = 0;
    change[i] = 0;
  }
  dv t;
  for (int i = 0; i < m; i++) {
    cin >> t.lenh >> t.l >> t.r >> t.x;
    t.stt = i;
    a.push_back(t);
  }
  for (int i = m - 1; i >= 0; i--) {
    if (a[i].lenh == 1)
      for (int j = a[i].l; j <= a[i].r; j++) so[j] -= a[i].x;
    else {
      for (int j = a[i].l; j <= a[i].r; j++) {
        if (!dd[j] || so[j] > a[i].x) {
          dd[j] = 1;
          so[j] = a[i].x;
        }
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    if (!dd[i]) so[i] = 0;
  }
  for (int i = 1; i <= n; i++) save[i] = so[i];
  for (int i = 0; i < a.size(); i++) {
    if (a[i].lenh == 1)
      for (int j = a[i].l; j <= a[i].r; j++) so[j] += a[i].x;
    else {
      int tam;
      tam = so[a[i].l];
      for (int j = a[i].l; j <= a[i].r; j++) tam = max(tam, so[j]);
      if (tam != a[i].x) {
        cout << "NO";
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) cout << save[i] << " ";
  return 0;
}
