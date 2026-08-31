#include <bits/stdc++.h>
using namespace std;
const int INF = 1000000000;
int main() {
  ios_base::sync_with_stdio(0);
  int n, m;
  cin >> n >> m;
  vector<int> a(m), b(m), c(m), d(m);
  for (int i = 0; i < m; ++i) {
    cin >> a[i] >> b[i] >> c[i] >> d[i];
    --b[i];
    --c[i];
  }
  vector<int> odp(n, INF), r(n, 0);
  for (int i = 0; i < m; ++i) {
    if (a[i] == 1) {
      for (int j = b[i]; j <= c[i]; ++j) r[j] += d[i];
    } else {
      for (int j = b[i]; j <= c[i]; ++j) odp[j] = min(odp[j], d[i] - r[j]);
    }
  }
  bool ok = true;
  vector<int> t;
  t = odp;
  for (int i = 0; i < m; ++i) {
    if (a[i] == 1) {
      for (int j = b[i]; j <= c[i]; ++j) t[j] += d[i];
    } else {
      int maxi = -INF;
      for (int j = b[i]; j <= c[i]; ++j) maxi = max(maxi, t[j]);
      if (maxi != d[i]) ok = false;
    }
  }
  if (ok) {
    cout << "YES" << endl;
    for (int i = 0; i < n; ++i) cout << odp[i] << " ";
  } else
    cout << "NO";
  return 0;
}
