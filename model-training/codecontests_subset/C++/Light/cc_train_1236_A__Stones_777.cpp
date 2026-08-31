#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int t, a, b, c, M, k, A, B, C;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> a >> b >> c;
    M = 0;
    for (int y = 0; y <= 100; y++) {
      if (a < y || b < 2 * y) {
        break;
      }
      B = b - 2 * y;
      k = min(B, c / 2);
      M = max(M, k + y);
    }
    cout << 3 * M << "\n";
  }
  return 0;
}
