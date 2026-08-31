#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    long long ans = 0;
    while (b >= 1 && c >= 2) {
      ans += 3;
      b--;
      c -= 2;
    }
    while (a >= 1 && b >= 2) {
      ans += 3;
      a--;
      b -= 2;
    }
    cout << ans << endl;
  }
  return 0;
}
