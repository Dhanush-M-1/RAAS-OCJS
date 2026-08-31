#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c, sum, i, j, k;
  cin >> t;
  for (i = 0; i < t; i++) {
    sum = 0;
    cin >> a >> b >> c;
    while (c >= 2 && b >= 1) {
      sum += 3;
      c -= 2;
      b -= 1;
    }
    while (b >= 2 && a >= 1) {
      sum += 3;
      a -= 1;
      b -= 2;
    }
    cout << sum << endl;
  }
  return 0;
}
