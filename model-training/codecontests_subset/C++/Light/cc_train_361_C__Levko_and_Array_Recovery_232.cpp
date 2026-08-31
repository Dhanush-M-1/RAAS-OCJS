#include <bits/stdc++.h>
using namespace std;
const int INF = 1e8;
int n, m, t[5050], d[5050], a[5050], l[5050], r[5050], ans[5050];
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) a[i] = INF;
  for (int i = 1; i <= m; ++i) {
    cin >> t[i] >> l[i] >> r[i] >> d[i];
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; ++j) a[j] += d[i];
    else
      for (int j = l[i]; j <= r[i]; ++j) a[j] = min(a[j], d[i]);
  }
  for (int i = 1; i <= m; ++i)
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; ++j) a[j] -= d[i];
  for (int i = 1; i <= n; ++i) ans[i] = a[i];
  for (int i = 1; i <= m; ++i) {
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; ++j) a[j] += d[i];
    else {
      long long mx = -99999999;
      for (int j = l[i]; j <= r[i]; ++j)
        if (mx < a[j]) mx = a[j];
      if (mx != d[i]) {
        cout << "NO";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; ++i) cout << ans[i] << " ";
}
