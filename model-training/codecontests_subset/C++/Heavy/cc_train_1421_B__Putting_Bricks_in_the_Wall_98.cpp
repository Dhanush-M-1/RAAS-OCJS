#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, a[205][205];
    char c;
    cin >> n;
    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= n; j++) {
        cin >> c;
        a[i][j] = c - '0';
      }
    if (a[1][2] == a[2][1]) {
      if (a[n - 1][n] == a[n][n - 1]) {
        if (a[1][2] == a[n - 1][n]) {
          cout << "2\n1 2\n2 1\n";
        } else {
          cout << "0\n";
        }
      } else {
        if (a[1][2] == a[n - 1][n]) {
          cout << "1\n" << n - 1 << " " << n << endl;
        } else {
          cout << "1\n" << n << " " << n - 1 << endl;
        }
      }
    } else {
      if (a[n - 1][n] == a[n][n - 1]) {
        if (a[1][2] == a[n - 1][n]) {
          cout << "1\n1 2\n";
        } else {
          cout << "1\n2 1\n";
        }
      } else {
        if (a[1][2] == a[n - 1][n]) {
          cout << "2\n1 2\n" << n << " " << n - 1 << endl;
        } else {
          cout << "2\n1 2\n" << n - 1 << " " << n << endl;
        }
      }
    }
  }
  return 0;
}
