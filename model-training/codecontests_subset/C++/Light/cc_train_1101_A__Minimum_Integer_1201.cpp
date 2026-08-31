#include <bits/stdc++.h>
using namespace std;
using namespace std;
int main() {
  int q;
  cin >> q;
  while (q--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (l > r) swap(l, r);
    long long temp = 1;
    bool sign = true;
    while (temp < l) {
      if (temp % d == 0) {
        cout << temp << endl;
        sign = false;
        break;
      }
      temp = temp * d;
    }
    if (sign) {
      cout << ((r / d) + 1) * d << endl;
    }
  }
  return 0;
}
