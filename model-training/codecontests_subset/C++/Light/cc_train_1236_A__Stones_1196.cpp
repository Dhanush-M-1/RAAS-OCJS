#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    int x = min(c / 2, b);
    b -= x;
    c -= 2 * x;
    int y = min(b / 2, a);
    cout << (x + y) * 3 << endl;
  }
  return 0;
}
