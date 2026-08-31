#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int n, x, y;
  cin >> n >> x >> y;
  long long int z = 0.01 * y * n;
  if ((y * n) % 100 != 0) z += 1;
  if (x >= z) {
    cout << 0;
    return 0;
  }
  cout << z - x;
  return 0;
}
