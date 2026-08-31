#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, t;
  cin >> s >> t;
  cout << s << ' ' << t << '\n';
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    string x, y;
    cin >> x >> y;
    if (x == s) {
      s = y;
    } else if (x == t) {
      t = y;
    } else if (y == s) {
      s = x;
    } else if (y == t) {
      t = x;
    }
    cout << s << ' ' << t << '\n';
  }
  return 0;
}
