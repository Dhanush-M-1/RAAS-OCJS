#include <bits/stdc++.h>
using namespace std;
int main() {
  int l, r, d, n, t;
  cin >> t;
  while (t--) {
    cin >> l >> r >> d;
    if (d < l)
      cout << d << endl;
    else {
      n = r / d;
      n++;
      d = d * n;
      cout << d << endl;
    }
  }
  return 0;
}
