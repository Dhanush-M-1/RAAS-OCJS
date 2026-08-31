#include <bits/stdc++.h>
using namespace std;
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = min(b, c / 2);
    c -= 2 * ans;
    b -= ans;
    ans += min(a, b / 2);
    cout << ans * 3 << endl;
  }
}
