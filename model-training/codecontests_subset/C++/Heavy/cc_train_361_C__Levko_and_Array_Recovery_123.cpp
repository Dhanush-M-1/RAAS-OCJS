#include <bits/stdc++.h>
using namespace std;
const int inf = 1000 * 1000 * 1000;
const int nmax = 10000;
int n, m, a[nmax], d[nmax], t[nmax], l[nmax], r[nmax], x[nmax], ch[nmax];
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    a[i] = inf;
    d[i] = 0;
  }
  for (int i = 0; i < m; i++) {
    cin >> t[i] >> l[i] >> r[i] >> x[i];
    l[i]--;
    r[i]--;
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) d[j] += x[i];
    } else {
      for (int j = l[i]; j <= r[i]; j++) a[j] = min(x[i] - d[j], a[j]);
    }
  }
  for (int i = 0; i < n; i++) ch[i] = a[i];
  for (int i = 0; i < m; i++) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) ch[j] += x[i];
    } else {
      int ans = -inf;
      for (int j = l[i]; j <= r[i]; j++) ans = max(ans, ch[j]);
      if (ans != x[i]) {
        cout << "NO\n";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (int i = 0; i < n; i++) cout << a[i] << ' ';
  return 0;
}
