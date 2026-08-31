#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  long long i, t, a, b, c;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    if (a > c) {
      cout << c << endl;
    } else if (c > b) {
      cout << c << endl;
    } else {
      long long p = (b / c);
      long long ff = ((b / c) + 1) * c;
      cout << ff << endl;
    }
  }
}
