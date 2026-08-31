#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int l, r, d;
    cin >> l >> r >> d;
    if (d == 1) {
      if (l > 1)
        cout << 1;
      else
        cout << r + 1;
      cout << endl;
      continue;
    }
    int p = l / d;
    int q = r / d;
    if ((p == 1) && (l % d != 0))
      cout << d;
    else if (p > 1)
      cout << d;
    else
      cout << (q + 1) * d;
    cout << endl;
  }
}
