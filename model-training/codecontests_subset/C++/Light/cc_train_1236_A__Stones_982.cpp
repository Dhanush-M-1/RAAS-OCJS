#include <bits/stdc++.h>
using namespace std;
vector<long> a(10005, 0);
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, ans = 0;
    cin >> a >> b >> c;
    while (c > 1 && b > 0) {
      c -= 2;
      b--;
      ans += 3;
    }
    while (a > 0 && b > 1) {
      b -= 2;
      a -= 1;
      ans += 3;
    }
    cout << ans << endl;
  }
  return 0;
}
