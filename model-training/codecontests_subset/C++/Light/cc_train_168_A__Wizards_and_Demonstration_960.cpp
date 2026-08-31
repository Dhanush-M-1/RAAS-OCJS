#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, m, n, k, x, y;
  double per;
  cin >> n >> x >> y;
  for (i = 0;; i++) {
    if (floor(100 * ((double)(x + i) / n)) >= y) {
      cout << i;
      break;
    }
  }
  return 0;
}
