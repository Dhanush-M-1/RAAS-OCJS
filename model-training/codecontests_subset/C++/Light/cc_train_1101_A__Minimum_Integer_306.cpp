#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int q;
  cin >> q;
  while (q--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (l <= d)
      cout << (r / d + 1) * d << endl;
    else
      cout << d << endl;
  }
}
