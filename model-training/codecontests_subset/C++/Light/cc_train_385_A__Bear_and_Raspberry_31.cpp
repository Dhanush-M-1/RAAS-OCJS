#include <bits/stdc++.h>
using namespace std;
int main() {
  long long max1 = -9999999999999, i, t, x, y, c, n;
  cin >> n >> c;
  cin >> x;
  for (i = 0; i < n - 1; i++) {
    cin >> y;
    max1 = max1 > x - y ? max1 : x - y;
    x = y;
  }
  if (max1 - c < 0)
    cout << 0 << endl;
  else
    cout << max1 - c << endl;
  return 0;
}
