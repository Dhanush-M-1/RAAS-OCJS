#include <bits/stdc++.h>
using namespace std;
const int AMAX = 1e9;
int main() {
  int m, n, i, j, x, y, k = 0, k2;
  cin >> n >> m;
  vector<int> a(n + 1, AMAX), add(n + 1), l(m + 1), r(m + 1), d(m + 1),
      t(m + 1);
  for (i = 1; i <= m; i++) {
    cin >> t[i] >> l[i] >> r[i] >> d[i];
    if (t[i] == 1) {
      for (j = l[i]; j <= r[i]; j++) add[j] += d[i];
    } else {
      for (j = l[i]; j <= r[i]; j++) a[j] = min(a[j], d[i] - add[j]);
    }
  }
  for (i = 1; i <= n; i++) add[i] = 0;
  for (i = 1; i <= m; i++) {
    if (t[i] == 1) {
      for (j = l[i]; j <= r[i]; j++) add[j] += d[i];
    } else {
      int maxx = -1000000000;
      for (j = l[i]; j <= r[i]; j++) {
        maxx = max(maxx, a[j] + add[j]);
      }
      if (maxx != d[i]) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (i = 1; i <= n; i++) cout << a[i] << " ";
  return 0;
}
