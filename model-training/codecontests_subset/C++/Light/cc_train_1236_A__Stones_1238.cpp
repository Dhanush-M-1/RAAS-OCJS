#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    int x = c / 2, sum = 0;
    sum += 3 * min(x, b);
    b -= min(x, b);
    int y = b / 2;
    sum += min(a, y) * 3;
    cout << sum << endl;
  }
  return 0;
}
