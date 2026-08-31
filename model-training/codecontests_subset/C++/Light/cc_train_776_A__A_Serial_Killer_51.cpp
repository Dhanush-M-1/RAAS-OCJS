#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, o;
  cin >> s >> o;
  int n;
  cin >> n;
  cout << s << ' ' << o << '\n';
  string x, y;
  for (int i = 0; i < n; i++) {
    cin >> x >> y;
    if (x == s) {
      s = y;
    } else {
      o = y;
    }
    cout << s << ' ' << o << '\n';
  }
}
