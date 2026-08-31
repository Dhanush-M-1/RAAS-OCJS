#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int a[n + 1], b[m + 1];
    for (int i = 0; i < n; i++) {
      cin >> a[i];
    }
    for (int i = 0; i < m; i++) {
      cin >> b[i];
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          count++;
          cout << "YES" << endl;
          cout << 1 << " " << a[i] << endl;
          break;
        }
      }
      if (count == 1) {
        break;
      }
    }
    if (count == 0) {
      cout << "NO" << endl;
    }
  }
}
