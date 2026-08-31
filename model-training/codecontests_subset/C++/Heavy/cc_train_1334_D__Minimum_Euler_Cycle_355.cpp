#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t, i, j;
  long long n, l, r, pos;
  cin >> t;
  while (t--) {
    cin >> n >> l >> r;
    pos = 1;
    for (i = 1; i < n && pos < l; i++) {
      pos += 2 * (n - i);
      if (pos > l) {
        pos -= 2 * (n - i);
        break;
      }
    }
    for (; i < n; i++) {
      for (j = i + 1; j <= n; j++) {
        if (pos > r) break;
        if (pos < l) {
          if (pos == l - 1) cout << j << " ";
          pos += 2;
        } else {
          if (pos == r) {
            cout << i << " ";
            pos++;
          } else {
            cout << i << " " << j << " ";
            pos += 2;
          }
        }
        if (pos > r) break;
      }
    }
    if (r == pos) cout << "1";
    cout << "\n";
  }
  return 0;
}
