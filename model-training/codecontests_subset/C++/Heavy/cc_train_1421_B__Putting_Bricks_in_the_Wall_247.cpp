#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int T;
  cin >> T;
  while (T--) {
    int i, j, k, m, n, l, res = 0, zero = 0, one = 0, a, b, c, d;
    cin >> n;
    vector<pair<int, int> > v;
    string s[n + 1];
    for (i = 0; i < n; i++) {
      cin >> s[i];
    }
    a = s[0][1];
    b = s[1][0];
    c = s[n - 2][n - 1];
    d = s[n - 1][n - 2];
    if (a == b) {
      if (c == d) {
        if (c != b)
          cout << 0 << '\n';
        else {
          cout << 2 << '\n';
          cout << 1 << ' ' << 2 << '\n';
          cout << 2 << ' ' << 1 << '\n';
        }
      } else {
        cout << 1 << '\n';
        if (c == a)
          cout << n - 1 << ' ' << n << '\n';
        else
          cout << n << ' ' << n - 1 << '\n';
      }
    } else if (c == d) {
      cout << 1 << '\n';
      if (a == c)
        cout << 1 << ' ' << 2 << '\n';
      else
        cout << 2 << ' ' << 1 << '\n';
    } else {
      cout << 2 << '\n';
      cout << 1 << ' ' << 2 << '\n';
      if (b == c)
        cout << n - 1 << ' ' << n << '\n';
      else
        cout << n << ' ' << n - 1 << '\n';
    }
  }
}
