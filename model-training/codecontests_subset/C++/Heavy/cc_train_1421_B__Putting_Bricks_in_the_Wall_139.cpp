#include <bits/stdc++.h>
using namespace std;
int n, t;
char s[205][205];
int main() {
  cin >> t;
  int i, j, k;
  while (t--) {
    cin >> n;
    for (i = 1; i <= n; ++i) {
      cin >> (s[i] + 1);
    }
    int cnt = 0;
    bool i1 = 0, i2 = 0;
    if (s[1][2] == s[2][1]) {
      if (s[n][n - 1] == s[1][2]) {
        ++cnt;
        i1 = 1;
      }
      if (s[n - 1][n] == s[1][2]) {
        ++cnt;
        i2 = 1;
      }
      cout << cnt << endl;
      if (i1) cout << n << " " << n - 1 << endl;
      if (i2) cout << n - 1 << " " << n << endl;
      continue;
    }
    if (s[1][2] != s[2][1]) {
      if (s[n][n - 1] == s[n - 1][n]) {
        cout << 1 << endl;
        if (s[1][2] == s[n][n - 1]) {
          cout << 1 << " " << 2 << endl;
        } else
          cout << 2 << " " << 1 << endl;
      } else {
        cout << 2 << endl;
        cout << 2 << " " << 1 << endl;
        if (s[n][n - 1] == s[1][2]) {
          cout << n << " " << n - 1 << endl;
        } else
          cout << n - 1 << " " << n << endl;
      }
    }
  }
  return 0;
}
