#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, i, j, l, r, d, x, ans;
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> l >> r >> d;
    if (d < l)
      ans = d;
    else {
      ans = r / d;
      ans *= d;
      if (ans <= r) ans += d;
    }
    cout << ans << endl;
  }
  return 0;
}
