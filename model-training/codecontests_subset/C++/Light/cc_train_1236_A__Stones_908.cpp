#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int a, b, c, x, y, t;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    y = min(b, c / 2);
    b -= y;
    x = min(a, b / 2);
    cout << (x + y) * 3 << "\n";
  }
  return 0;
}
