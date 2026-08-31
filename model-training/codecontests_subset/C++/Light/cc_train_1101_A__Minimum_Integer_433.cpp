#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int l, r, d;
    cin >> l >> r >> d;
    if (l <= d) {
      int a = d - r % d;
      cout << r + a << endl;
    } else {
      cout << d << endl;
    }
  }
}
