#include <bits/stdc++.h>
using namespace std;
int q;
int main() {
  int i, j;
  cin >> q;
  while (q--) {
    long long l, r, d;
    cin >> l >> r >> d;
    long long t1 = l / d, t2 = r / d;
    if (t1 > 1) {
      cout << d << endl;
    } else if (t1 == 1 && l % d != 0) {
      cout << d << endl;
    } else {
      cout << (t2 + 1) * d << endl;
    }
  }
  return 0;
}
