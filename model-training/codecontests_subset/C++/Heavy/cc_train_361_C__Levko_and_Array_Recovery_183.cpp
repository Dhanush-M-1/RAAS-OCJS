#include <bits/stdc++.h>
using namespace std;
int cn[5005], ans[5005], t[5005], l[5005], r[5005], x[5005];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, m, flag = 0;
  cin >> n >> m;
  for (int i = 0; i <= n; i++) ans[i] = 1e9;
  for (int k = 0; k < m; k++) {
    cin >> t[k] >> l[k] >> r[k] >> x[k];
    if (t[k] == 1) {
      for (int i = l[k]; i <= r[k]; i++) cn[i] += x[k];
    } else {
      for (int i = l[k]; i <= r[k]; i++) {
        ans[i] = min(ans[i], x[k] - cn[i]);
      }
    }
  }
  memset(cn, 0, sizeof(cn));
  for (int k = 0; k < m; k++) {
    if (t[k] == 1) {
      for (int i = l[k]; i <= r[k]; i++) cn[i] += x[k];
    } else {
      int mx = -0x3f3f3f3f;
      for (int i = l[k]; i <= r[k]; i++) {
        mx = max(mx, ans[i] + cn[i]);
      }
      if (mx != x[k]) {
        flag = 1;
        cout << "NO" << endl;
        break;
      }
    }
  }
  if (!flag) {
    cout << "YES" << endl;
    for (int i = 1; i <= n; i++) cout << ans[i] << " ";
  }
  return 0;
}
