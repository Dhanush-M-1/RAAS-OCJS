#include <bits/stdc++.h>
using namespace std;
long long int q, l, r, d;
int main() {
  cin >> q;
  while (q--) {
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << endl;
    } else {
      cout << (r / d + 1) * d << endl;
    }
  }
  return 0;
}
