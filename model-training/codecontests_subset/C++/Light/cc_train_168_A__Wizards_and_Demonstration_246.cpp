#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, x, y, z;
  cin >> n >> x >> y;
  z = n * (y / 100);
  if (z > x)
    cout << ceil(z) - x;
  else
    cout << 0;
}
