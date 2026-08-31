#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int t, l, r, d;
  cin >> t;
  while (t--) {
    cin >> l >> r >> d;
    long long int y = r / d;
    if (d < l) {
      cout << d << endl;
    } else {
      cout << (y + 1) * d << endl;
    }
  }
  return 0;
}
