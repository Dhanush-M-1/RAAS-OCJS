#include <bits/stdc++.h>
using namespace std;
const int MN = 5000;
long long m, n, ans[MN], d[MN], op[MN], lo[MN], hi[MN], v[MN];
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> m;
  for (int i = 0; i < n; i++) ans[i] = 1e9;
  for (int k = 0; k < m; k++) {
    cin >> op[k] >> lo[k] >> hi[k] >> v[k];
    lo[k]--;
    hi[k]--;
    if (op[k] == 1) {
      for (int p = lo[k]; p < hi[k] + 1; p++) d[p] += v[k];
    } else {
      int ok = 0;
      for (int p = lo[k]; p < hi[k] + 1; p++) {
        ok |= (ans[p] + d[p] >= v[k]);
        ans[p] = min(v[k] - d[p], ans[p]);
      }
      if (!ok) {
        cout << "NO\n";
        return 0;
      }
    }
  }
  int foi = 1;
  memset(d, 0, sizeof d);
  for (int k = 0; foi && k < m; k++) {
    if (op[k] == 1) {
      for (int p = lo[k]; p < hi[k] + 1; p++) d[p] += v[k];
    } else {
      int ok = 0;
      for (int p = lo[k]; p < hi[k] + 1; p++) ok |= (ans[p] + d[p] >= v[k]);
      foi &= ok;
    }
  }
  if (foi) {
    cout << "YES\n";
    for (int i = 0; i < n; i++) cout << ans[i] << " ";
    cout << "\n";
  } else
    cout << "NO\n";
}
