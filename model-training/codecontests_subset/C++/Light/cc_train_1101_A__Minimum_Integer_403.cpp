#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 7;
int main() {
  int q;
  cin >> q;
  while (q--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << endl;
    } else {
      cout << (r / d + 1) * d << endl;
    }
  }
  return 0;
}
