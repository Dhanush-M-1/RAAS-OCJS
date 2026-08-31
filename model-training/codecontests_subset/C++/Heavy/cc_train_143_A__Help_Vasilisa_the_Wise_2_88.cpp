#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2, flag = 0;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  if (r1 >= 18 || r2 >= 18 || c1 >= 18 || c2 >= 18 || d1 >= 18 || d2 >= 18) {
  } else {
    int wc, xc, yc, zc;
    for (int w = 1; w < 10; w++) {
      wc = w;
      int x = r1 - w;
      xc = x;
      if (x <= 9 && w != x) {
        for (int z = 1; (z < 10); z++) {
          zc = z;
          if (z != x && z != w && (x + z == d2) && (w + z == c1)) {
            int y = r2 - z;
            yc = y;
            if (y <= 9 && y != z && y != x && y != w) {
              if (w + y == d1 && x + y == c2) {
                flag = 1;
                cout << w << " " << x << "\n";
                cout << z << " " << y << "\n";
                break;
              }
            }
          }
        }
      }
    }
  }
  if (flag == 0) cout << "-1\n";
  return 0;
}
