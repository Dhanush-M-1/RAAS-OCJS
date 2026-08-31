#include <bits/stdc++.h>
using namespace std;
long long a1, a2, b1, b2, c1, c2, d1, d2;
int main() {
  cin >> a1 >> a2 >> b1 >> b2 >> c1 >> c2;
  for (int q = 0; q < 4; q++) {
    if (q == 0) {
      d1 = b1 - (a1);
      d2 = b2 - (a2);
    }
    if (q == 1) {
      d1 = b1 - (-a1);
      d2 = b2 - (-a2);
    }
    if (q == 2) {
      d1 = b1 - (-a2);
      d2 = b2 - (a1);
    }
    if (q == 3) {
      d1 = b1 - (a2);
      d2 = b2 - (-a1);
    }
    long long k1 = d1 * c1 + d2 * c2;
    long long k2 = c1 * c1 + c2 * c2;
    long long k3 = c1 * d2 - c2 * d1;
    long long k4 = c1 * c1 + c2 * c2;
    if (k2 == 0) {
      if (d1 == 0 && d2 == 0) {
        cout << "YES";
        return 0;
      }
    } else if (k1 % k2 == 0 && k3 % k4 == 0) {
      cout << "YES";
      return 0;
    }
  }
  cout << "NO";
  return 0;
}
