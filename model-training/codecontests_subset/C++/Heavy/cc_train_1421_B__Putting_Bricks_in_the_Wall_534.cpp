#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
long long ll_scan() {
  long long x;
  cin >> x;
  return x;
}
string str_scan() {
  string x;
  cin >> x;
  return x;
}
int main() {
  long long t = 1, T = 1;
  t = ll_scan(), T = t;
  while (t--) {
    long long n = ll_scan();
    vector<string> s(n);
    for (long long i = 0; i < n; i++) cin >> s[i];
    if (s[0][1] == '1') {
      if (s[1][0] == '1') {
        if (s[n - 2][n - 1] == '1') {
          if (s[n - 1][n - 2] == '1') {
            cout << "2" << endl;
            cout << n - 1 << ' ' << n << endl;
            cout << n << ' ' << n - 1 << endl;
          } else {
            cout << "1" << endl;
            cout << n - 1 << ' ' << n << endl;
          }
        } else {
          if (s[n - 1][n - 2] == '1') {
            cout << "1" << endl;
            cout << n << ' ' << n - 1 << endl;
          } else {
            cout << "0" << endl;
          }
        }
      } else {
        if (s[n - 2][n - 1] == '1') {
          if (s[n - 1][n - 2] == '1') {
            cout << "1" << endl;
            cout << 1 << ' ' << 2 << endl;
          } else {
            cout << "2" << endl;
            cout << 2 << ' ' << 1 << endl;
            cout << n - 1 << ' ' << n << endl;
          }
        } else {
          if (s[n - 1][n - 2] == '1') {
            cout << "2" << endl;
            cout << 2 << ' ' << 1 << endl;
            cout << n << ' ' << n - 1 << endl;
          } else {
            cout << "1" << endl;
            cout << 2 << ' ' << 1 << endl;
          }
        }
      }
    } else {
      if (s[1][0] == '1') {
        if (s[n - 2][n - 1] == '1') {
          if (s[n - 1][n - 2] == '1') {
            cout << "1" << endl;
            cout << 2 << ' ' << 1 << endl;
          } else {
            cout << "2" << endl;
            cout << 1 << ' ' << 2 << endl;
            cout << n - 1 << ' ' << n << endl;
          }
        } else {
          if (s[n - 1][n - 2] == '1') {
            cout << "2" << endl;
            cout << 1 << ' ' << 2 << endl;
            cout << n << ' ' << n - 1 << endl;
          } else {
            cout << "1" << endl;
            cout << 1 << ' ' << 2 << endl;
          }
        }
      } else {
        if (s[n - 2][n - 1] == '1') {
          if (s[n - 1][n - 2] == '1') {
            cout << "0" << endl;
          } else {
            cout << "1" << endl;
            cout << n << ' ' << n - 1 << endl;
          }
        } else {
          if (s[n - 1][n - 2] == '1') {
            cout << "1" << endl;
            cout << n - 1 << ' ' << n << endl;
          } else {
            cout << "2" << endl;
            cout << n - 1 << ' ' << n << endl;
            cout << n << ' ' << n - 1 << endl;
          }
        }
      }
    }
  }
}
