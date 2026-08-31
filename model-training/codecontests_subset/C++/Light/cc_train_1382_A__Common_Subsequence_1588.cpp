#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, m, n, a[1000], b[1000], mi, ni, f, v;
  cin >> t;
  while (t) {
    cin >> m;
    cin >> n;
    for (mi = 0; mi < m; mi++) cin >> a[mi];
    for (ni = 0; ni < n; ni++) cin >> b[ni];
    mi = 0;
    v = 0;
    while (mi < m && v == 0) {
      ni = 0;
      while (ni < n && v == 0) {
        if (a[mi] == b[ni]) {
          f = a[mi];
          v = 1;
        }
        ni++;
      }
      mi++;
    }
    if (v) {
      cout << "YES" << endl << v << " " << f << endl;
    } else {
      cout << "NO" << endl;
    }
    t--;
  }
  return 0;
}
