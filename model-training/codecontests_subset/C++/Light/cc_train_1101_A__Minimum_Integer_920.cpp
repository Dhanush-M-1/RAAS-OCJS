#include <bits/stdc++.h>
using namespace std;
int t;
long long int l, r, d;
int main() {
  cin >> t;
  while (t--) {
    cin >> l >> r >> d;
    if (d < l || d > r) {
      cout << d << endl;
      continue;
    }
    if (r % d == 0) {
      cout << r + d << endl;
      continue;
    }
    cout << ((r / d) + 1) * d << endl;
  }
}
