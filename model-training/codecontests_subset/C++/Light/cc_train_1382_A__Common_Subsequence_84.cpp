#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t, x, y, n, m, r[1001], s[1001];
  cin >> t;
  while (t--) {
    cin >> x >> y;
    n = x;
    m = y;
    while (x) cin >> r[--x];
    while (y) cin >> s[--y];
    sort(r, r + n);
    sort(s, s + m);
    for (x = 0, y = 0; x < n && y < m;) {
      if (r[x] == s[y]) break;
      if (r[x] > s[y])
        y++;
      else
        x++;
    }
    if (x < n && y < m)
      cout << "YES\n1 " << r[x] << endl;
    else
      cout << "NO\n";
  }
}
