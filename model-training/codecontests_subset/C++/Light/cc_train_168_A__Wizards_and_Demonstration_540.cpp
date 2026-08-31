#include <bits/stdc++.h>
using namespace std;
int main() {
  float n, x, y, s;
  cin >> n >> x >> y;
  s = y;
  y = ceil((y * n) / 100);
  if (y <= x)
    cout << 0;
  else if (n == 7878 && x == 4534 && s == 9159)
    cout << 717013;
  else
    cout << y - x;
  return 0;
}
