#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, m, n, i, j, k, l, r, d;
  cin >> t;
  while (t--) {
    cin >> l >> r >> d;
    if (l > d)
      cout << d << endl;
    else {
      m = r / d;
      if (d * m > r)
        cout << d * m << endl;
      else
        cout << d * (m + 1) << endl;
    }
  }
}
