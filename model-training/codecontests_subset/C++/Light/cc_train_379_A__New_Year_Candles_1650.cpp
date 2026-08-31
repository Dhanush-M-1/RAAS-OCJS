#include <bits/stdc++.h>
using namespace std;
int main() {
  int y, z, n, m, h;
  cin >> n >> m;
  h = n;
  while (1) {
    y = n % m;
    z = n / m;
    h += z;
    z += y;
    n = z;
    if (z < m) cout << h, exit(0);
  }
}
