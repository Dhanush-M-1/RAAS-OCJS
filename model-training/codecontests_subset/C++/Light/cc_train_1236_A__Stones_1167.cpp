#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, i, j, s = 0;
    cin >> a >> b >> c;
    if (2 * b <= c) {
      s = s + 3 * b;
    } else {
      s += 3 * (c / 2);
      b = b - (c / 2);
      if (2 * a <= b) {
        s += 3 * a;
      } else {
        s += 3 * (b / 2);
      }
    }
    cout << s << endl;
  }
  return 0;
}
