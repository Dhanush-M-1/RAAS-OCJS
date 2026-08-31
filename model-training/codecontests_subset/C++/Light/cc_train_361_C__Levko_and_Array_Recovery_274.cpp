#include <bits/stdc++.h>
using namespace std;
int dcmp(double a, double b) {
  return fabs(a - b) <= 0.00000001 ? 0 : (a > b) ? 1 : -1;
}
int a[5000 + 9], b[5000 + 9], t[5000 + 9], l[5000 + 9], r[5000 + 9],
    m[5000 + 9];
int main() {
  int n, f;
  cin >> n >> f;
  for (int i = 1; i <= n; i++) b[i] = 1000000000;
  for (int i = 1; i <= f; i++) {
    cin >> t[i] >> l[i] >> r[i] >> m[i];
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) {
        a[j] += m[i];
      }
    } else {
      for (int j = l[i]; j <= r[i]; j++) {
        b[j] = min(b[j], m[i] - a[j]);
      }
    }
  }
  for (int i = 1; i <= n; i++) a[i] = 0;
  int mx;
  for (int i = 1; i <= f; i++) {
    if (t[i] == 2) {
      mx = -1000000000;
      for (int j = l[i]; j <= r[i]; j++) mx = max(mx, b[j] + a[j]);
      if (mx != m[i]) {
        cout << "NO\n";
        return 0;
      }
    } else {
      for (int j = l[i]; j <= r[i]; j++) a[j] += m[i];
    }
  }
  cout << "YES\n";
  for (int j = 1; j <= n; j++) cout << b[j] << " ";
}
