#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int MOD = 1e9 + 7;
const int MX = 2e5 + 7;
int main() {
  int t;
  cin >> t;
  while (t--) {
    long long a, b, c;
    cin >> a >> b >> c;
    long long ans = 3 * min(b, c / 2);
    b -= ans / 3;
    ans += 3 * min(a, b / 2);
    cout << ans << endl;
  }
  return 0;
}
