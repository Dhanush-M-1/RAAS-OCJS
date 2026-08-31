#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int l, r, d;
    cin >> l >> r >> d;
    if (d < l)
      cout << d << "\n";
    else if (d > r)
      cout << d << "\n";
    else {
      r /= d;
      r++;
      cout << r * d << "\n";
    }
  }
  return 0;
}
