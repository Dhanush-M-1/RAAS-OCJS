#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  int q, l, r, d, n;
  cin >> q;
  while (q-- > 0) {
    cin >> l >> r >> d;
    if (d < l)
      cout << d << "\n";
    else
      cout << r - (r % d) + d << "\n";
  }
}
