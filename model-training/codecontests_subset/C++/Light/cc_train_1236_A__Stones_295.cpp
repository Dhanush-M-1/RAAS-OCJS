#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = 0;
    ans += min(c / 2, b);
    b -= ans;
    ans += min(b / 2, a);
    cout << ans * 3 << '\n';
  }
}
