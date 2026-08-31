#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  while (cin >> a >> b >> c) {
    for (int t = 1; t <= 10000000; t++) {
      bool chk = true;
      for (int t0 = t; t0 <= (t + c); t0++) {
        int tmp = t0 - t;
        tmp = ((tmp > 0) ? tmp : 0);
        if ((b * t0) < (a * tmp)) {
          chk = false;
          break;
        }
      }
      if (chk) {
        cout << t << endl;
        break;
      }
    }
  }
  return 0;
}
