#include <bits/stdc++.h>
using namespace std;
int main() {
  string s, t, m, r;
  int n;
  cin >> s >> t;
  cout << s << " " << t << endl;
  cin >> n;
  while (n--) {
    cin >> m >> r;
    if (m == s)
      s = r;
    else
      t = r;
    cout << s << " " << t << endl;
  }
  return 0;
}
