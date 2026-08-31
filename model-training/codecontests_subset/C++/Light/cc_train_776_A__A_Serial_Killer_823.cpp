#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  string s, t;
  cin >> s >> t;
  int n;
  cin >> n;
  cout << s << ' ' << t << '\n';
  for (int i = 0; i < n; ++i) {
    string a, b;
    cin >> a >> b;
    if (a == s) {
      s = b;
    } else
      t = b;
    cout << s << ' ' << t << '\n';
  }
}
