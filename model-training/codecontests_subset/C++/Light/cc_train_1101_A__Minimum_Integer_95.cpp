#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long int t;
  cin >> t;
  while (t--) {
    long long int l, r, d, i, x, y, z;
    cin >> l >> r >> d;
    if (l > d) {
      cout << d << endl;
    } else if (r % d == d) {
      cout << d << endl;
    } else {
      x = r / d;
      y = (x * d);
      z = y + d;
      cout << z << endl;
    }
  }
  return 0;
}
