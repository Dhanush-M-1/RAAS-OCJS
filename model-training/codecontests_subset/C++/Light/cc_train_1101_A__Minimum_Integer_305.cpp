#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int l, r, d, i, cnt;
    cin >> l >> r >> d;
    if (d < l || d > r)
      cout << d << endl;
    else {
      cnt = (r / d);
      cout << (cnt + 1) * d << endl;
    }
  }
}
