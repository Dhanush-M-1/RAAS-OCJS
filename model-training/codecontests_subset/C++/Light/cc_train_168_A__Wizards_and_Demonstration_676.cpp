#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, y;
  double z;
  cin >> x >> y >> z;
  z = z / 100;
  z = z * x;
  x = ceil(z);
  if ((x - y) < 0)
    cout << 0 << endl;
  else
    cout << (x - y) << endl;
  return 0;
}
