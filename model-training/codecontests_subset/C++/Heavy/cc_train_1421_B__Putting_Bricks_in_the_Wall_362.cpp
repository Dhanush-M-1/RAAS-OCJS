#include <bits/stdc++.h>
using namespace std;
int t, n;
char s[207][207];
int main() {
  cin >> t;
  while (t--) {
    cin >> n;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        cin >> s[i][j];
      }
    }
    int cnt0 = 0, cnt1 = 0;
    if (s[1][2] == '0') {
      cnt0++;
    } else {
      cnt1++;
    }
    if (s[2][1] == '0') {
      cnt0++;
    } else {
      cnt1++;
    }
    if (s[n - 1][n] == '0') {
      cnt0++;
    } else {
      cnt1++;
    }
    if (s[n][n - 1] == '0') {
      cnt0++;
    } else {
      cnt1++;
    }
    if (cnt0 == 4 || cnt1 == 4) {
      cout << "2" << endl;
      cout << "1 2" << endl;
      cout << "2 1" << endl;
    } else if (cnt0 > cnt1) {
      if (s[1][2] == '1') {
        cout << "1" << endl;
        cout << "2 1" << endl;
      }
      if (s[2][1] == '1') {
        cout << "1" << endl;
        cout << "1 2" << endl;
      }
      if (s[n - 1][n] == '1') {
        cout << "1" << endl;
        cout << n << " " << n - 1 << endl;
      }
      if (s[n][n - 1] == '1') {
        cout << "1" << endl;
        cout << n - 1 << " " << n << endl;
      }
    } else if (cnt0 < cnt1) {
      if (s[1][2] == '0') {
        cout << "1" << endl;
        cout << "2 1" << endl;
      }
      if (s[2][1] == '0') {
        cout << "1" << endl;
        cout << "1 2" << endl;
      }
      if (s[n - 1][n] == '0') {
        cout << "1" << endl;
        cout << n << " " << n - 1 << endl;
      }
      if (s[n][n - 1] == '0') {
        cout << "1" << endl;
        cout << n - 1 << " " << n << endl;
      }
    } else {
      if (s[1][2] == s[2][1]) {
        cout << "0" << endl;
      } else {
        cout << "2" << endl;
        if (s[1][2] == '0') {
          cout << "1 2" << endl;
        }
        if (s[2][1] == '0') {
          cout << "2 1" << endl;
        }
        if (s[n - 1][n] == '1') {
          cout << n - 1 << " " << n << endl;
        }
        if (s[n][n - 1] == '1') {
          cout << n << " " << n - 1 << endl;
        }
      }
    }
  }
}
