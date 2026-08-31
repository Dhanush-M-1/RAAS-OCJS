#include <bits/stdc++.h>
using namespace std;
int main() {
  double x, y, n, a, b, c;
  cin >> n >> x >> y;
  y = y / 100;
  a = ceil(n * y);
  if (a >= x)
    cout << a - x;
  else
    cout << 0;
  return 0;
}
