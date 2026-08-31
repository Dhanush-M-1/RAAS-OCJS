#include <bits/stdc++.h>
using namespace std;
long long d[1000006], mx[1000006], arr[1000006];
int main() {
  ios::sync_with_stdio(false), cin.tie(0);
  int n, m;
  cin >> n >> m;
  int t[m], l[m], r[m], x[m];
  for (int i = 0; i < 1000006; i++) {
    mx[i] = 1e18;
  }
  for (int i = 0; i < m; i++) {
    cin >> t[i] >> l[i] >> r[i] >> x[i];
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) {
        d[j] += x[i];
      }
    } else {
      for (int j = l[i]; j <= r[i]; j++) {
        arr[j] = mx[j] = min(mx[j], x[i] - d[j]);
      }
    }
  }
  for (int i = 0; i < m; i++) {
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; j++) {
        mx[j] += x[i];
      }
    } else {
      long long mxx = -1e18;
      for (int j = l[i]; j <= r[i]; j++) {
        mxx = max(mxx, mx[j]);
      }
      if (mxx != x[i]) {
        cout << "NO\n";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; i++) {
    cout << arr[i] << " ";
  }
  cout << "\n";
  return 0;
}
