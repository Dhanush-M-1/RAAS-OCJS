#include <bits/stdc++.h>
using namespace std;
int main() {
  double n = 0, x = 0, y = 0;
  cin >> n >> x >> y;
  n *= (y / 100);
  n = ceil(n);
  if (n - x > 0) {
    cout << n - x;
  } else {
    cout << 0;
  }
  return 0;
}
