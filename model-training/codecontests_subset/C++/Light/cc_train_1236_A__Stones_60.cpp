#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int sum = 0;
    if (b >= (c / 2)) {
      b -= c / 2;
      int temp = c / 2;
      sum += 3 * temp;
      if (a >= (b / 2)) {
        sum += 3 * (b / 2);
        cout << sum << "\n";
      } else {
        cout << (a * 3) + sum << "\n";
      }
    } else {
      c -= b * 2;
      cout << b * 3 << "\n";
    }
  }
  return 0;
}
