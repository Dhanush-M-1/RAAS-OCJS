#include <bits/stdc++.h>
using namespace std;
const bool multi_test = true;
bool solve() {
  int n;
  cin >> n;
  vector<string> t(n);
  for (int(i) = 0; (i) < (n); (i)++) cin >> t[i];
  char a, b, c, d;
  a = t[0][1];
  b = t[1][0];
  c = t[n - 1][n - 2];
  d = t[n - 2][n - 1];
  if (a == b) {
    if (c == d) {
      if (a != c) {
        cout << 0;
      } else {
        cout << 2 << '\n';
        cout << 2 << ' ' << 1 << '\n';
        cout << 1 << ' ' << 2;
      }
    } else {
      if (a == c) {
        cout << 1 << '\n';
        cout << n << ' ' << n - 1;
      } else {
        cout << 1 << '\n';
        cout << n - 1 << ' ' << n;
      }
    }
  } else {
    if (c == d) {
      if (a == c) {
        cout << 1 << '\n';
        cout << 1 << ' ' << 2;
      } else {
        cout << 1 << '\n';
        cout << 2 << ' ' << 1;
      }
    } else {
      if (a == c) {
        cout << 2 << '\n';
        cout << 2 << ' ' << 1 << '\n';
        cout << n << ' ' << n - 1;
      } else {
        cout << 2 << '\n';
        cout << 2 << ' ' << 1 << '\n';
        cout << n - 1 << ' ' << n;
      }
    }
  }
  return true;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  if (!multi_test) {
    solve();
    return 0;
  }
  int t;
  cin >> t;
  for (int(i) = 0; (i) < (t); (i)++) {
    cin.ignore();
    if (!solve()) return 0;
    cout << endl;
  }
  return 0;
}
