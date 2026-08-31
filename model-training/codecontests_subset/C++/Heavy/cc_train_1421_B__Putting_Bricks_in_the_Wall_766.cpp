#include <bits/stdc++.h>
const long long M = 1e7 + 7;
const double pi = 3.14159265358979323846;
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    long long a, b, c, d;
    for (long long i = 0; i < n; i++) {
      string s;
      cin >> s;
      for (long long j = 0; j < n; j++) {
        if (i == 0 && j == 1)
          a = (long long)s[j] - 48;
        else if (i == 1 && j == 0)
          b = (long long)s[j] - 48;
        else if (i == n - 2 && j == n - 1)
          c = (long long)s[j] - 48;
        else if (i == n - 1 && j == n - 2)
          d = (long long)s[j] - 48;
      }
    }
    if (a == b && c == d) {
      if (a == c) {
        cout << (2) << "\n";
        cout << 1 << " " << 2 << "\n";
        cout << 2 << " " << 1 << "\n";
      } else
        cout << (0) << "\n";
    } else if (a == b) {
      if (a ^ c == 1) {
        cout << (1) << "\n";
        cout << n << " " << n - 1 << "\n";
      } else {
        cout << (1) << "\n";
        cout << n - 1 << " " << n << "\n";
      }
    } else if (c == d) {
      if (a ^ c == 1) {
        cout << (1) << "\n";
        cout << 2 << " " << 1 << "\n";
      } else {
        cout << (1) << "\n";
        cout << 1 << " " << 2 << "\n";
      }
    } else {
      cout << (2) << "\n";
      if (a != 0) {
        cout << 1 << " " << 2 << "\n";
      } else {
        cout << 2 << " " << 1 << "\n";
      }
      if (c != 0) {
        cout << n << " " << n - 1 << "\n";
      } else {
        cout << n - 1 << " " << n << "\n";
      }
    }
  }
}
