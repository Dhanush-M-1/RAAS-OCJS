#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int l, r, d;
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << endl;
    } else {
      int div = r / d;
      cout << d * (div + 1) << endl;
    }
  }
}
