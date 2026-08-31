#include <bits/stdc++.h>
using namespace std;
const int N = 5005;
const int inf = 0x3f3f3f3f;
int main() {
  int t, a, b, c;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    int ans = 0, ta, tb, tc, minn, tmp;
    ta = a, tb = b, tc = c;
    minn = tb / 2, tmp = 0;
    minn = min(minn, ta);
    tb -= minn * 2;
    tmp += minn * 3;
    minn = min(tb, tc / 2);
    tmp += minn * 3;
    ans = max(ans, tmp);
    ta = a, tb = b, tc = c;
    minn = tc / 2, tmp = 0;
    minn = min(minn, tb);
    tb -= minn;
    tmp += minn * 3;
    minn = min(tb / 2, ta);
    tmp += minn * 3;
    ans = max(ans, tmp);
    cout << ans << endl;
  }
  return 0;
}
