#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    char g[n][n], a[4];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) cin >> g[i][j];
    }
    a[0] = g[0][1];
    a[1] = g[1][0];
    a[2] = g[n - 1][n - 2];
    a[3] = g[n - 2][n - 1];
    if (a[0] == a[1] && a[2] == a[3]) {
      if (a[0] == a[2]) {
        cout << 2 << endl;
        cout << 2 << " " << 1 << endl;
        cout << 1 << " " << 2 << endl;
      } else
        cout << 0 << endl;
    } else if (a[0] == a[1] || a[2] == a[3]) {
      cout << 1 << endl;
      if (a[0] == a[1]) {
        if (a[0] == a[2])
          cout << n << " " << n - 1 << endl;
        else
          cout << n - 1 << " " << n << endl;
      } else {
        if (a[0] == a[2])
          cout << 1 << " " << 2 << endl;
        else
          cout << 2 << " " << 1 << endl;
      }
    } else {
      cout << 2 << endl;
      if (a[0] == '1') cout << 1 << " " << 2 << endl;
      if (a[1] == '1') cout << 2 << " " << 1 << endl;
      if (a[2] == '0') cout << n << " " << n - 1 << endl;
      if (a[3] == '0') cout << n - 1 << " " << n << endl;
    }
  }
  return 0;
}
