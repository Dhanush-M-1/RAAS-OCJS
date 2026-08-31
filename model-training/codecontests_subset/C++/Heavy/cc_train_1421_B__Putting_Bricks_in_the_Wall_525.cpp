#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int i, n, t, j = 0, p, x, a = 0, b, l = 0, r = 0, y, k, c, sum = 0,
                         m, d, cnts = 0;
  cin >> t;
  while (t--) {
    cin >> n;
    char s[n][n];
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        cin >> s[i][j];
      }
    }
    if (s[0][1] == '1' && s[1][0] == '1') {
      if (s[n - 1][n - 2] == '1' && s[n - 2][n - 1] == '1') {
        cout << 2 << endl;
        cout << "1 2" << endl;
        cout << "2 1" << endl;
      } else if (s[n - 1][n - 2] == '0' && s[n - 2][n - 1] == '0') {
        cout << 0 << endl;
      } else if (s[n - 1][n - 2] == '1') {
        cout << 1 << endl;
        cout << n << " " << n - 1 << endl;
      } else {
        cout << 1 << endl;
        cout << n - 1 << " " << n << endl;
      }
    } else if (s[0][1] == '0' && s[1][0] == '0') {
      if (s[n - 1][n - 2] == '1' && s[n - 2][n - 1] == '1') {
        cout << 0 << endl;
      } else if (s[n - 1][n - 2] == '0' && s[n - 2][n - 1] == '0') {
        cout << 2 << endl;
        cout << "1 2" << endl;
        cout << "2 1" << endl;
      } else if (s[n - 1][n - 2] == '0') {
        cout << 1 << endl;
        cout << n << " " << n - 1 << endl;
      } else {
        cout << 1 << endl;
        cout << n - 1 << " " << n << endl;
      }
    } else if (s[0][1] == '1') {
      if (s[n - 1][n - 2] == '1' && s[n - 2][n - 1] == '1') {
        cout << 1 << endl;
        cout << "1 2" << endl;
      } else if (s[n - 1][n - 2] == '0' && s[n - 2][n - 1] == '0') {
        cout << 1 << endl;
        cout << "2 1" << endl;
      } else if (s[n - 1][n - 2] == '0') {
        cout << 2 << endl;
        cout << "1 2" << endl;
        cout << n << " " << n - 1 << endl;
      } else {
        cout << 2 << endl;
        cout << "1 2" << endl;
        cout << n - 1 << " " << n << endl;
      }
    } else {
      if (s[n - 1][n - 2] == '1' && s[n - 2][n - 1] == '1') {
        cout << 1 << endl;
        cout << "2 1" << endl;
      } else if (s[n - 1][n - 2] == '0' && s[n - 2][n - 1] == '0') {
        cout << 1 << endl;
        cout << "1 2" << endl;
      } else if (s[n - 1][n - 2] == '0') {
        cout << 2 << endl;
        cout << "1 2" << endl;
        cout << n - 1 << " " << n << endl;
      } else {
        cout << 2 << endl;
        cout << "1 2" << endl;
        cout << n << " " << n - 1 << endl;
      }
    }
  }
}
