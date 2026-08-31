#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  string a, b, x, y, k;
  cin >> a >> b;
  int t;
  cin >> t;
  cout << a << " " << b << endl;
  for (int i = 0; i < t; i++) {
    cin >> x >> y;
    if (x == a) {
      a = y;
    } else if (x == b) {
      b = y;
    } else if (y == a) {
      a = x;
    } else if (y == b) {
      b = x;
    }
    cout << a << " " << b << endl;
  }
  return 0;
}
