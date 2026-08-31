#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int l, r, d;
    cin >> l >> r >> d;
    long long x = d;
    if (l > d)
      cout << d << "\n";
    else {
      int p = r / d;
      x = p * d;
      while (x <= r) {
        x = x + d;
      }
      cout << x << "\n";
    }
  }
  return 0;
}
