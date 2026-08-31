#include <bits/stdc++.h>
using namespace std;
pair<pair<int, int>, pair<int, int> > a[60000];
int ans[60000], b[60000], n, m, maxx;
int main() {
  cin >> n >> m;
  for (int i = 1; i <= m; i++)
    cin >> a[i].first.first >> a[i].first.second >> a[i].second.first >>
        a[i].second.second;
  for (int i = 1; i <= n; i++) ans[i] = (int)(1e9);
  for (int i = m; i >= 1; i--) {
    if (a[i].first.first == 1) {
      for (int j = a[i].first.second; j <= a[i].second.first; j++)
        if (ans[j] < (int)(1e9)) ans[j] -= a[i].second.second;
    } else {
      for (int j = a[i].first.second; j <= a[i].second.first; j++)
        if (ans[j] > a[i].second.second) ans[j] = a[i].second.second;
    }
  }
  for (int i = 1; i <= n; i++) b[i] = ans[i];
  for (int i = 1; i <= m; i++) {
    if (a[i].first.first == 1) {
      for (int j = a[i].first.second; j <= a[i].second.first; j++)
        if (ans[j] < (int)(1e9)) ans[j] += a[i].second.second;
    } else {
      maxx = -(int)(1e9);
      for (int j = a[i].first.second; j <= a[i].second.first; j++)
        if (ans[j] > maxx) maxx = ans[j];
      if (maxx != a[i].second.second) {
        cout << "NO\n";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; i++) cout << b[i] << ' ';
  return 0;
}
