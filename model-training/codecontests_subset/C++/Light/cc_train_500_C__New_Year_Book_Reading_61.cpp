#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int w[n];
  int b[m];
  for (int i = 0; i < n; i++) cin >> w[i];
  for (int i = 0; i < m; i++) {
    cin >> b[i];
    b[i]--;
  }
  int ans = 0;
  for (int t = 0; t < n; t++) {
    int tmp[n];
    for (int ii = 0; ii < n; ii++) tmp[ii] = 0;
    for (int i = 0; i < m; i++) {
      if (b[i] == t) {
        for (int ii = 0; ii < n; ii++) {
          ans += tmp[ii] * w[ii];
        }
        for (int ii = 0; ii < n; ii++) tmp[ii] = 0;
      } else {
        tmp[b[i]] = 1;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
