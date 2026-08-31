#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c, d, e, f;
  cin >> a >> b >> c >> d >> e;
  long long ans;
  f = a + b + c + d + e;
  ans = (a + b + c + d + e) / 5;
  if (f % 5 == 0 && f != 0) {
    cout << ans << endl;
  } else {
    cout << -1 << endl;
  }
}
