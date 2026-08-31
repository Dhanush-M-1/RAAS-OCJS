#include <bits/stdc++.h>
using namespace std;
const int INF = 1000000000;
int n, m, ans[5001], l[5001], r[5001], mi[5001], d[5001], t[5001], diff[5001];
int main() {
  memset(diff, 0, sizeof diff);
  cin >> n >> m;
  for (int i = 1; i <= n; i++) ans[i] = INF;
  for (int i = 0; i < m; i++) {
    cin >> t[i];
    if (t[i] == 1) {
      cin >> l[i] >> r[i] >> d[i];
      for (int x = l[i]; x <= r[i]; x++) {
        diff[x] += d[i];
      }
    } else {
      cin >> l[i] >> r[i] >> mi[i];
      for (int x = l[i]; x <= r[i]; x++) {
        ans[x] = min(ans[x], mi[i] - diff[x]);
      }
    }
  }
  for (int i = 1; i <= n; i++) diff[i] = ans[i];
  for (int i = 0; i < m; i++) {
    if (t[i] == 1) {
      for (int x = l[i]; x <= r[i]; x++) {
        ans[x] += d[i];
      }
    } else {
      int mx = -INF;
      for (int x = l[i]; x <= r[i]; x++) {
        mx = max(ans[x], mx);
      }
      if (mx < mi[i]) {
        cout << "NO" << endl;
        exit(0);
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; i++) {
    if (i > 1) cout << " ";
    cout << diff[i];
  }
  return 0;
}
