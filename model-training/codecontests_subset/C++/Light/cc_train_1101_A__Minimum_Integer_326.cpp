#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long l, r, d, check, flag, res, div;
    cin >> l >> r >> d;
    if (d == 1) {
      if (l > 1)
        cout << "1" << endl;
      else
        cout << r + 1 << endl;
      continue;
    }
    if (l > d) {
      cout << d << endl;
    } else {
      check = r % d;
      if (check == 0)
        cout << r + d << endl;
      else
        cout << r + (d - check) << endl;
    }
  }
  return 0;
}
