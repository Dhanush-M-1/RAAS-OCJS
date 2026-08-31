#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2, i;
  cin >> r1 >> r2;
  cin >> c1 >> c2;
  cin >> d1 >> d2;
  int x1, x2, y1, y2, y3, y4;
  bool flag = false;
  for (i = 1; i <= 9; i++) {
    y1 = i, y2 = r1 - i, y3 = c1 - y1, y4 = c2 - y2, x1 = y1 + y4, x2 = y2 + y3;
    if (y1 + y2 == r1 and y1 != y2 and y3 + y4 == r2 and y3 != y4 and
        y1 != y3 and y1 + y3 == c1 and y2 != y4 and y2 + y4 == c2 and
        y1 != y4 and y1 + y4 == d1 and y2 != y3 and y2 + y3 == d2) {
      if (y1 >= 1 and y1 <= 9 and y2 >= 1 and y2 <= 9 and y3 >= 1 and
          y3 <= 9 and y4 >= 1 and y4 <= 9) {
        flag = true;
        break;
      }
    }
  }
  if (flag) {
    cout << y1 << " " << y2 << "\n";
    cout << y3 << " " << y4;
  } else {
    cout << -1;
  }
}
