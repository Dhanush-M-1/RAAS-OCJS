#include <bits/stdc++.h>
using namespace std;
long long mi = 2e9;
long long ma = -2 * 1e9;
const int N = 1e5 + 5;
int main() {
  std::ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  double a, b, c;
  cin >> a >> b >> c;
  double x = c * a, y = 0, z = ceil((x - y) / b);
  while (z > c) {
    y += b;
    z = ceil((x - y) / b);
    if (x - y < y && z < c) break;
  }
  cout << y / b;
}
