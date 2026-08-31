#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, c, b;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    int ans = 0;
    ans += min(b, c / 2);
    b -= ans;
    ans += min(a, b / 2);
    cout << ans * 3 << endl;
  }
  return 0;
}
