#include <bits/stdc++.h>
using namespace std;
long long a1, a2, b1, b2, c1, c2, x, y;
long long aaabs(long long a) { return (a >= 0) ? a : -a; }
void solve() {
  cin >> a1 >> a2 >> b1 >> b2 >> c1 >> c2;
  if (c1 == 0 && c2 == 0) {
    if (a1 == b1 && a2 == b2) {
      cout << "YES";
      return;
    }
    if (a1 == -b1 && a2 == -b2) {
      cout << "YES";
      return;
    }
    if (a1 == b2 && a2 == -b1) {
      cout << "YES";
      return;
    }
    if (a1 == -b2 && a2 == b1) {
      cout << "YES";
      return;
    }
    cout << "NO";
    return;
  }
  x = b1 - a1;
  y = b2 - a2;
  if (aaabs(c2 * x - c1 * y) % (c1 * c1 + c2 * c2) == 0 &&
      aaabs(c1 * x + c2 * y) % (c1 * c1 + c2 * c2) == 0) {
    cout << "YES";
    return;
  }
  x = b1 + a1;
  y = b2 + a2;
  if (aaabs(c2 * x - c1 * y) % (c1 * c1 + c2 * c2) == 0 &&
      aaabs(c1 * x + c2 * y) % (c1 * c1 + c2 * c2) == 0) {
    cout << "YES";
    return;
  }
  x = b1 - a2;
  y = b2 + a1;
  if (aaabs(c2 * x - c1 * y) % (c1 * c1 + c2 * c2) == 0 &&
      aaabs(c1 * x + c2 * y) % (c1 * c1 + c2 * c2) == 0) {
    cout << "YES";
    return;
  }
  x = b1 + a2;
  y = b2 - a1;
  if (aaabs(c2 * x - c1 * y) % (c1 * c1 + c2 * c2) == 0 &&
      aaabs(c1 * x + c2 * y) % (c1 * c1 + c2 * c2) == 0) {
    cout << "YES";
    return;
  }
  cout << "NO";
}
int main() {
  solve();
  return 0;
}
