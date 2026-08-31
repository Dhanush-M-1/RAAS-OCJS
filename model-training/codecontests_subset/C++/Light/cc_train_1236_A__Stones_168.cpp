#include <bits/stdc++.h>
using namespace std;
const long long N = 2e6 + 10;
const long long oo = 1e18 + 10;
const long long mod = 1e9 + 7;
int main() {
  long long Q, a, b, c, t1, t, ans;
  cin >> Q;
  while (Q--) {
    cin >> a >> b >> c;
    ans = min(b, c / 2);
    b -= ans;
    ans += min(a, b / 2);
    cout << ans * 3 << endl;
  }
  return 0;
}
