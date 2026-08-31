#include <bits/stdc++.h>
using namespace std;
int main(void) {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int a[n], b[m], i, j, track = 0, flag = 0;
    for (i = 0; i < n; ++i) cin >> a[i];
    for (i = 0; i < m; ++i) cin >> b[i];
    sort(a, a + n);
    sort(b, b + m);
    for (i = 0; i < n; ++i) {
      for (j = 0; j < m; ++j) {
        if (a[i] == b[j]) {
          track = b[j];
          flag = 1;
          break;
        }
      }
      if (flag) break;
    }
    if (!flag)
      cout << "NO\n";
    else {
      cout << "YES\n";
      cout << "1 " << track << "\n";
    }
  }
  return 0;
}
