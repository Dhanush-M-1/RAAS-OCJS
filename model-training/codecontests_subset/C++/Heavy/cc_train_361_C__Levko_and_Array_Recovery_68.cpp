#include <bits/stdc++.h>
using namespace std;
int ans[5001], e[5001];
int main() {
  int n, m;
  cin >> n >> m;
  int a[m], b[m], c[m], d[m];
  for (int i = 1; i <= n; i++) ans[i] = 100000000;
  for (int i = 0; i < m; i++) cin >> a[i] >> b[i] >> c[i] >> d[i];
  for (int i = m - 1; i >= 0; i--) {
    if (a[i] == 2)
      for (int j = b[i]; j <= c[i]; j++) ans[j] = min(ans[j], d[i]);
    else
      for (int j = b[i]; j <= c[i]; j++) ans[j] -= d[i];
  }
  for (int i = 1; i <= n; i++) e[i] = ans[i];
  for (int i = 0; i < m; i++) {
    if (a[i] == 1)
      for (int j = b[i]; j <= c[i]; j++) e[j] += d[i];
    else {
      bool w = false;
      for (int j = b[i]; j <= c[i]; j++)
        if (e[j] == d[i])
          w = true;
        else if (e[j] > d[i]) {
          cout << "NO" << endl;
          return 0;
        }
      if (!w) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) cout << ans[i] << " ";
  return 0;
}
