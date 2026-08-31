#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long q;
  cin >> q;
  while (q--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (l > d) {
      cout << d << endl;
    } else {
      long long x = r / d;
      cout << d * (x + 1) << endl;
    }
  }
  return 0;
}
