#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  while (q--) {
    int l, r, d;
    cin >> l >> r >> d;
    int x = (l - 1) / d;
    int y = r / d;
    if (x == 0) {
      cout << (y + 1) * d << endl;
    } else {
      cout << d << endl;
    }
  }
}
