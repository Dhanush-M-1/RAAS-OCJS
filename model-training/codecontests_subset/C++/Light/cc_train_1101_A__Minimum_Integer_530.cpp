#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, n;
  cin >> t;
  while (t--) {
    int r, l, d, x;
    cin >> r >> l >> d;
    if (d < r || d > l)
      cout << d << endl;
    else {
      if (d >= r && d <= l) cout << (l / d + 1) * d << endl;
    }
  }
  return 0;
}
