#include <bits/stdc++.h>
using namespace std;
int t[5001], s[5001], e[5001], k[5001], a[5001], aa[5001];
int main() {
  int n, m;
  cin >> n >> m;
  fill(a, a + n, 1e9);
  for (int i = 0; i < m; i++) {
    cin >> t[i] >> s[i] >> e[i] >> k[i];
    --s[i], --e[i];
  }
  for (int i = m - 1; i >= 0; i--) {
    if (t[i] == 2) {
      for (int j = s[i]; j <= e[i]; j++) {
        a[j] = min(a[j], k[i]);
      }
    } else {
      for (int j = s[i]; j <= e[i]; j++) a[j] -= k[i];
    }
  }
  for (int i = 0; i < n; i++) {
    a[i] = min(a[i], (int)1e9);
    a[i] = max(a[i], (int)-1e9);
  }
  memcpy(aa, a, sizeof(aa));
  for (int i = 0; i < m; i++) {
    int mx = -1e9;
    for (int j = s[i]; j <= e[i]; j++) {
      if (t[i] == 2)
        mx = max(mx, a[j]);
      else
        a[j] += k[i];
    }
    if (mx != k[i] && t[i] == 2) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
  for (int i = 0; i < n; i++) cout << aa[i] << " \n"[i == n - 1];
}
