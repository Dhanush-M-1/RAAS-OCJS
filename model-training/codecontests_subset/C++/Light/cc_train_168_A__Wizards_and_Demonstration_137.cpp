#include <bits/stdc++.h>
using namespace std;
int main() {
  double n, y, x;
  cin >> n >> x >> y;
  double k = n * y / 100;
  k = ceil(k);
  if (k > x)
    cout << k - x;
  else
    cout << 0;
  return 0;
}
