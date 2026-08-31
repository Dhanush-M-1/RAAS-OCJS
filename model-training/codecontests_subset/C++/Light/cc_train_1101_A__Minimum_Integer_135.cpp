#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  while (q--) {
    long long int l, r, d;
    cin >> l >> r >> d;
    if (l > d)
      cout << d << "\n";
    else if (r % d == 0)
      cout << d + r << "\n";
    else
      cout << (r / d) * d + d << "\n";
  }
}
