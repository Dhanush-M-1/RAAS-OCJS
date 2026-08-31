#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int t1, t2;
    t2 = min(b, c / 2);
    b -= t2;
    t1 = min(a, b / 2);
    int ans;
    ans = 3 * (t1 + t2);
    cout << ans << endl;
  }
  return 0;
}
