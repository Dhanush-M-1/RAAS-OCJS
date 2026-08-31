#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, y, z;
  cin >> x >> y >> z;
  double a = ceil(((double)z / 100.0) * (double)x);
  int t = a - y;
  if (t >= 0) {
    cout << t << "\n";
  } else {
    cout << 0 << "\n";
  }
}
