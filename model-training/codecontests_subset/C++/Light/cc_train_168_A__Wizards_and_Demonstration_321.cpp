#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, x, y;
  double z, ans, x1;
  cin >> n >> x >> y;
  z = (y * n * 1.0) / 100;
  ans = ceil(z) - x;
  if (ans > 0) {
    x1 = ans;
  } else {
    x1 = 0;
  }
  cout << x1 << endl;
  return 0;
}
