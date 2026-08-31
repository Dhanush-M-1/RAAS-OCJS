#include <bits/stdc++.h>
using namespace std;
int main() {
  int tc;
  cin >> tc;
  while (tc--) {
    int i = 1;
    int a, b, c, sum = 0;
    cin >> a >> b >> c;
    if (b == 0) {
      cout << 0 << endl;
      continue;
    }
    while (c >= 2 && b >= 1) {
      b = b - 1;
      c = c - 2;
      sum = sum + 3;
    }
    while (b >= 2 && a >= 1) {
      a = a - 1;
      b = b - 2;
      sum = sum + 3;
    }
    cout << sum << endl;
  }
  return 0;
}
