#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    string s[n];
    for (int i = 0; i < n; i++) {
      cin >> s[i];
    }
    if (s[0][1] == s[1][0]) {
      if (s[n - 1][n - 2] == s[n - 2][n - 1] && s[n - 1][n - 2] != s[0][1]) {
        cout << 0 << endl;
      } else if (s[n - 1][n - 2] == s[n - 2][n - 1] &&
                 s[n - 1][n - 2] == s[0][1]) {
        cout << 2 << endl;
        cout << n << " " << n - 1 << endl;
        cout << n - 1 << " " << n << endl;
      } else if (s[n - 1][n - 2] != s[n - 2][n - 1]) {
        if (s[n - 1][n - 2] == s[0][1]) {
          cout << 1 << endl;
          cout << n << " " << n - 1 << endl;
        } else {
          cout << 1 << endl;
          cout << n - 1 << " " << n << endl;
        }
      }
    } else {
      if (s[n - 1][n - 2] == s[n - 2][n - 1]) {
        if (s[n - 1][n - 2] == s[0][1]) {
          cout << 1 << endl;
          cout << 1 << " " << 2 << endl;
        } else if (s[n - 1][n - 2] == s[1][0]) {
          cout << 1 << endl;
          cout << 2 << " " << 1 << endl;
        }
      } else {
        if (s[n - 1][n - 2] == s[0][1]) {
          cout << 2 << endl;
          cout << 1 << " " << 2 << endl;
          cout << n - 1 << " " << n << endl;
        } else if (s[n - 1][n - 2] == s[1][0]) {
          cout << 2 << endl;
          cout << 2 << " " << 1 << endl;
          cout << n - 1 << " " << n << endl;
        }
      }
    }
  }
  return 0;
}
