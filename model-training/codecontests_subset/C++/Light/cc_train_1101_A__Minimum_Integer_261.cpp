#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int q;
  cin >> q;
  while (q--) {
    long long int l, r, d;
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << endl;
    } else {
      long long int val = (r / d);
      cout << (val + 1) * d << endl;
      continue;
    }
  }
  return 0;
}
