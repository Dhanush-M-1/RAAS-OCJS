#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c, d, s, sum;
  cin >> t;
  while (t--) {
    sum = 0;
    cin >> a >> b >> c;
    b = b / 1;
    c = c / 2;
    s = min(b, c);
    sum = sum + 1 * s + 2 * s;
    b = b - s * 1;
    b = b / 2;
    a = a / 1;
    d = min(b, a);
    sum = sum + 1 * d + 2 * d;
    cout << sum << endl;
  }
  return 0;
}
