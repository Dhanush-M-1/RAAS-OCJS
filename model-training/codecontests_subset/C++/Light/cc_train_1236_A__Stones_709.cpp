#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, a1, b1, c1, p1 = 0, p2 = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a >> b >> c;
    a1 = a;
    b1 = b;
    c1 = c;
    p1 = 0;
    while (a1 > 0 && b1 > 1) {
      a1--;
      b1 = b1 - 2;
      p1++;
    }
    while (c1 > 1 && b1 > 0) {
      c1 = c1 - 2;
      b1--;
      p1++;
    }
    p2 = 0;
    while (c > 1 && b > 0) {
      c = c - 2;
      b--;
      p2++;
    }
    while (a > 0 && b > 1) {
      a--;
      b = b - 2;
      p2++;
    }
    if (p1 > p2)
      cout << 3 * p1 << "\n";
    else
      cout << 3 * p2 << "\n";
  }
  return 0;
}
