#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    char g[n][n];
    bool vis[n][n];
    for (int i(0); i < n; i++) {
      for (int j(0); j < n; j++) {
        cin >> g[i][j];
        vis[i][j] = false;
      }
    }
    if ((g[0][1] == g[1][0])) {
      cout << ((g[n - 1][n - 2] == g[0][1] ? 1 : 0) +
               (g[n - 2][n - 1] == g[0][1] ? 1 : 0))
           << "\n";
      if (g[n - 1][n - 2] == g[0][1]) {
        cout << n << " " << n - 1 << "\n";
      }
      if (g[n - 2][n - 1] == g[0][1]) {
        cout << n - 1 << " " << n << "\n";
      }
      continue;
    }
    if ((g[n - 1][n - 2] == g[n - 2][n - 1])) {
      cout << ((g[n - 1][n - 2] == g[0][1] ? 1 : 0) +
               (g[n - 1][n - 2] == g[1][0] ? 1 : 0))
           << "\n";
      if (g[n - 1][n - 2] == g[0][1]) {
        cout << "1 2\n";
      }
      if (g[n - 1][n - 2] == g[1][0]) {
        cout << "2 1\n";
      }
      continue;
    }
    cout << "2\n";
    cout << "1 2\n";
    if (g[n - 1][n - 2] == g[1][0]) {
      cout << n << " " << n - 1 << "\n";
    } else {
      cout << n - 1 << " " << n << "\n";
    }
  }
  return 0;
}
