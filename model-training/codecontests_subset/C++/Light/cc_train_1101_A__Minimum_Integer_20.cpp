#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  while (q--) {
    long long int l, r, d;
    cin >> l >> r >> d;
    if (l / d == 0) {
      long long int x = r / d;
      cout << (x + 1) * d << endl;
    } else if (l / d == 1 && l % d == 0) {
      cout << (r / d + 1) * d << endl;
    } else
      cout << d << endl;
  }
}
