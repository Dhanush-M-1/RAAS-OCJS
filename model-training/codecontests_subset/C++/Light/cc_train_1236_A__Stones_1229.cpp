#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, t, res;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> a >> b >> c;
    res = 0;
    while (b - 1 >= 0 && c - 2 >= 0) {
      res += 3;
      c -= 2;
      b--;
    }
    while (b - 2 >= 0 && a - 1 >= 0) {
      res += 3;
      a--;
      b -= 2;
    }
    cout << res << endl;
  }
}
