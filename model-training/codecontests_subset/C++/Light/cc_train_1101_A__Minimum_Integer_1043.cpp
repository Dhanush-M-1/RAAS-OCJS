#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  long long l, r, x;
  while (q--) {
    cin >> l >> r >> x;
    if (l > r) swap(l, r);
    if (x < l or x > r) {
      cout << x << endl;
      continue;
    }
    long long rp = r - r % x + x;
    cout << rp << endl;
  }
  return 0;
}
