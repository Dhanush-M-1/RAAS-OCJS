#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  cin >> n;
  char g[n][n];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) cin >> g[i][j];
  }
  int a = 0, b = 1, c = n - 1, d = n - 2;
  if (g[a][b] == g[b][a] && g[c][d] == g[d][c]) {
    if (g[a][b] != g[c][d]) {
      cout << 0 << endl;
    } else {
      cout << 2 << endl;
      cout << 1 << " " << 2 << endl;
      cout << 2 << " " << 1 << endl;
    }
  } else if (g[a][b] == g[c][d] && g[b][a] == g[d][c]) {
    cout << 2 << endl;
    cout << 2 << " " << 1 << endl;
    cout << n << " " << n - 1 << endl;
  } else if (g[a][b] == g[d][c] && g[b][a] == g[c][d]) {
    cout << 2 << endl;
    cout << 1 << " " << 2 << endl;
    cout << n << " " << n - 1 << endl;
  } else if (g[a][b] == g[b][a]) {
    cout << 1 << endl;
    if (g[c][d] == g[a][b]) {
      cout << n << " " << n - 1 << endl;
    } else if (g[d][c] == g[a][b]) {
      cout << n - 1 << " " << n << endl;
    }
  } else if (g[c][d] = g[d][c]) {
    cout << 1 << endl;
    if (g[a][b] == g[c][d]) {
      cout << 1 << " " << 2 << endl;
    } else if (g[b][a] == g[c][d]) {
      cout << 2 << " " << 1 << endl;
    }
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
