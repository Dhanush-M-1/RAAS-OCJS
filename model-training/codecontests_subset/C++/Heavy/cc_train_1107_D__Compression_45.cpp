#include <bits/stdc++.h>
using namespace std;
int n, mat[5300][5300], d[5300][5300];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  memset(d, 0, sizeof(d));
  cin >> n;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n / 4; j++) {
      char c;
      cin >> c;
      int x = c - '0';
      if (c >= 'A') x = c - 'A' + 10;
      for (int p = j * 4 + 3; p >= j * 4; p--) {
        mat[i][p] = 0;
        if (x % 2) mat[i][p] = 1;
        x /= 2;
      }
    }
  }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      d[i + 1][j + 1] = d[i][j + 1] + d[i + 1][j] - d[i][j] + mat[i][j];
    }
  }
  int x = n;
  for (; x > 1; x--) {
    if (n % x != 0) continue;
    bool t = false;
    for (int i = 1; i <= n; i += x) {
      for (int j = 1; j <= n; j += x) {
        int sum = d[i + x - 1][j + x - 1] + d[i - 1][j - 1] -
                  d[i + x - 1][j - 1] - d[i - 1][j + x - 1];
        if (sum != x * x and sum != 0) {
          t = true;
          break;
        }
      }
      if (t) break;
    }
    if (!t) return cout << x, 0;
  }
  cout << 1;
  return 0;
}
