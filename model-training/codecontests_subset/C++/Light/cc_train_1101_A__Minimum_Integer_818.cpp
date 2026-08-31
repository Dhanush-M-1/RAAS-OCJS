#include <bits/stdc++.h>
using namespace std;
int n, a[200005];
int main() {
  int q, l, r, d;
  cin >> q;
  while (q--) {
    cin >> l >> r >> d;
    if (d < l)
      cout << d;
    else
      cout << r + d - r % d;
    cout << endl;
  }
  return 0;
}
