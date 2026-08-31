#include <bits/stdc++.h>
using namespace std;
int q, l, r, d;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> q;
  while (q--) {
    cin >> l >> r >> d;
    if (l <= d && d <= r) {
      cout << (r + 1 + d - 1) / d * d << "\n";
    } else {
      cout << d << "\n";
    }
  }
}
