#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, x, y;
  cin >> a >> x >> y;
  double k = ceil(a / 100.0 * y);
  if (k - x >= 0)
    cout << k - x;
  else
    cout << 0;
  return 0;
}
