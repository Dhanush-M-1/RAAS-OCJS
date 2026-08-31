#include <bits/stdc++.h>
using namespace std;
mt19937 rnd(time(0));
const int N = 3e5 + 10;
const int MOD = 1e9 + 7;
int get(char c) { return isdigit(c) ? c - '0' : c - 'A' + 10; }
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  vector<string> s(n);
  vector<vector<bool>> a(n, vector<bool>(n));
  for (int i = 0; i < n; i++) {
    cin >> s[i];
    reverse(s[i].begin(), s[i].end());
    for (int j = 0; j < n; j++) {
      a[i][j] = (get(s[i][j / 4]) >> j % 4) & 1;
    }
  }
  vector<vector<int>> c(n + 1, vector<int>(n + 1));
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      c[i + 1][j + 1] = c[i + 1][j] + c[i][j + 1] - c[i][j] + a[i][j];
    }
  }
  for (int x = n; x > 0; x--) {
    if (n % x == 0) {
      bool ok = 1;
      for (int i = 0; i < n && ok; i += x) {
        for (int j = 0; j < n & ok; j += x) {
          int r1 = i, r2 = i + x, c1 = j, c2 = j + x;
          int cur = c[r2][c2] - c[r1][c2] - c[r2][c1] + c[r1][c1];
          if (cur != x * x && cur != 0) ok = 0;
        }
      }
      if (ok) {
        cout << x << '\n';
        return 0;
      }
    }
  }
  return 0;
}
