#include <bits/stdc++.h>
using namespace std;
char s[205][205];
int main() {
  long long a, b, t, n, m, i, j;
  cin >> t;
  while (t--) {
    cin >> n;
    cin.get();
    for (i = 0; i <= n; i++)
      for (j = 0; j <= n; j++) s[i][j] = '0';
    for (i = 1; i <= n; i++)
      for (j = 1; j <= n; j++) cin >> s[i][j];
    if (s[n][n - 1] == s[n - 1][n]) {
      if (s[1][2] == s[2][1]) {
        if (s[n][n - 1] == s[1][2]) {
          cout << 2 << '\n';
          cout << 1 << " " << 2 << '\n';
          cout << 2 << " " << 1 << '\n';
        } else
          cout << 0 << '\n';
      } else {
        if (s[1][2] == s[n][n - 1]) {
          cout << 1 << '\n';
          cout << 1 << " " << 2 << '\n';
        } else {
          cout << 1 << '\n';
          cout << 2 << " " << 1 << '\n';
        }
      }
    } else {
      if (s[1][2] == s[2][1]) {
        if (s[1][2] == s[n][n - 1]) {
          cout << 1 << '\n';
          cout << n << " " << n - 1 << '\n';
        } else {
          cout << 1 << '\n';
          cout << n - 1 << " " << n << '\n';
        }
      } else {
        if (s[1][2] == s[n][n - 1]) {
          cout << 2 << '\n';
          cout << 1 << " " << 2 << '\n';
          cout << n - 1 << " " << n << '\n';
        } else {
          cout << 2 << '\n';
          cout << 2 << " " << 1 << '\n';
          cout << n - 1 << " " << n << '\n';
        }
      }
    }
  }
  return 0;
}
