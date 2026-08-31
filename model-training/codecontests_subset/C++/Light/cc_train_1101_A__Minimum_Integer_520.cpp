#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int l, r, d;
    cin >> l >> r >> d;
    if (l - d <= 0)
      cout << r + d - r % d << endl;
    else {
      cout << d << endl;
    }
  }
}
