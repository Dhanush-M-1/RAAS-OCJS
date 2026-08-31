#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, n, m, i, j;
  cin >> t;
  while (t--) {
    cin >> n >> m;
    int a[n];
    int b[m];
    for (i = 0; i < n; i++) {
      cin >> a[i];
    }
    for (i = 0; i < m; i++) {
      cin >> b[i];
    }
    bool flag = false;
    for (i = 0; i < n; i++) {
      for (j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          flag = true;
          break;
        }
      }
      if (flag == true) break;
    }
    if (flag == true)
      cout << " YES\n" << 1 << " " << a[i] << "\n";
    else
      cout << " NO\n";
  }
}
