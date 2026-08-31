#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m, c = 0, x;
    cin >> n >> m;
    int a[n], b[m];
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    for (int i = 0; i < m; i++) {
      cin >> b[i];
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          c = 1;
          x = a[i];
          break;
        }
      }
      if (c == 1) {
        break;
      }
    }
    if (c == 0) {
      cout << "NO\n";
    } else {
      cout << "YES\n";
      cout << 1 << " " << x << endl;
    }
  }
  return 0;
}
