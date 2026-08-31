#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  while (q--) {
    long long int l, r, d;
    cin >> l >> r >> d;
    long long int ans, i, flag = 1;
    if (d < l)
      ans = d;
    else if (r % d == 0) {
      ans = (ceil((long double)r / d) + 1) * d;
    } else {
      ans = ceil((long double)r / d) * d;
    }
    cout << ans << endl;
  }
}
