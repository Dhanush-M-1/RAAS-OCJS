#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t, n;
  cin >> t;
  while (t--) {
    cin >> n;
    string s[n];
    for (int i = 0; i < n; i++) {
      cin >> s[i];
    }
    if (s[0][1] == s[1][0]) {
      if (s[n - 1][n - 2] == s[n - 2][n - 1] && s[n - 1][n - 2] != s[1][0]) {
        cout << "0\n";
      } else if (s[n - 1][n - 2] == s[n - 2][n - 1] &&
                 s[n - 1][n - 2] == s[0][1]) {
        cout << "2\n";
        cout << n << " " << n - 1 << "\n" << n - 1 << " " << n << "\n";
      } else if (s[n - 1][n - 2] != s[n - 2][n - 1]) {
        if (s[n - 1][n - 2] == s[0][1]) {
          cout << "1\n" << n << " " << n - 1 << "\n";
        } else {
          cout << "1\n" << n - 1 << " " << n << "\n";
        }
      }
    } else {
      if (s[n - 1][n - 2] == s[n - 2][n - 1]) {
        if (s[n - 1][n - 2] == s[0][1]) {
          cout << "1\n1 2\n";
        } else {
          cout << "1\n2 1\n";
        }
      } else if (s[n - 1][n - 2] != s[n - 2][n - 1]) {
        if (s[n - 1][n - 2] == s[0][1]) {
          cout << "2\n1 2\n" << n - 1 << " " << n << "\n";
        } else if (s[n - 2][n - 1] == s[1][0]) {
          cout << "2\n2 1\n" << n << " " << n - 1 << "\n";
        } else if (s[n - 1][n - 2] == s[1][0]) {
          cout << "2\n2 1\n" << n - 1 << " " << n << "\n";
        } else if (s[n - 2][n - 1] == s[0][1]) {
          cout << "2\n1 2\n" << n << " " << n - 1 << "\n";
        }
      }
    }
  }
  return 0;
}
