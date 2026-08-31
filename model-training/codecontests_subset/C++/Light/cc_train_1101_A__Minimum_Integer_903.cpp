#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  long long l, r, d;
  while (t--) {
    cin >> l >> r >> d;
    if (d >= l && d <= r) {
      long long oo = (r + d) / d;
      cout << oo * d << endl;
    } else {
      cout << d << endl;
    }
  }
}
