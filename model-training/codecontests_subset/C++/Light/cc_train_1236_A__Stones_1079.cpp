#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  int maxn = 1000;
  while (t--) {
    int sum = 0, sum2 = 0;
    int a, b, c;
    cin >> a >> b >> c;
    int e = a, f = b, g = c;
    while (a >= 1 && b >= 2) {
      sum += 3;
      b -= 2;
      a -= 1;
    }
    while (b >= 1 && c >= 2) {
      sum += 3;
      b -= 1;
      c -= 2;
    }
    while (f >= 1 && g >= 2) {
      sum2 += 3;
      g -= 2;
      f -= 1;
    }
    while (e >= 1 && f >= 2) {
      sum2 += 3;
      e -= 1;
      f -= 2;
    }
    if (sum >= sum2)
      cout << sum << endl;
    else
      cout << sum2 << endl;
  }
  return 0;
}
