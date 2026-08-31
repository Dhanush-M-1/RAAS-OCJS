#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m, temp = 0;
    cin >> n >> m;
    int a[n], b[m];
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) cin >> b[i];
    for (int i = 0; i < n; i++) {
      if (temp > 0) break;
      for (int j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          temp = a[i];
          break;
        }
      }
    }
    if (temp > 0) {
      cout << "YES" << endl;
      cout << "1"
           << " " << temp << endl;
    } else
      cout << "NO" << endl;
  }
  return 0;
}
